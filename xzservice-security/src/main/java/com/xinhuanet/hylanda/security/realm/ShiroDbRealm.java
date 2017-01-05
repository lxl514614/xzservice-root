package com.xinhuanet.hylanda.security.realm;

import com.alibaba.druid.util.StringUtils;
import com.xinhuanet.hylanda.common.utils.Digests;
import com.xinhuanet.hylanda.common.utils.Encodes;
import com.xinhuanet.hylanda.dao.UserMapper;
import com.xinhuanet.hylanda.model.entity.User;
import org.apache.commons.collections.CollectionUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.InputStream;
import java.util.Collection;
import java.util.List;
import java.util.Properties;

/**
 * Created by Administrator on 2016/12/9.
 */
public class ShiroDbRealm extends AuthorizingRealm {

    private static final Logger log = LoggerFactory.getLogger(ShiroDbRealm.class);

    private static final int INTERATIONS = 1024;
    private static final int SALT_SIZE = 8;
    private static final String ALGORITHM = "SHA-1";


    @Autowired
    private UserMapper userMapper;

    /**
     * 给ShiroDbRealm提供编码信息，用于密码密码比对
     * 描述
     */
    public ShiroDbRealm() {
        super();
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher(ALGORITHM);
        matcher.setHashIterations(INTERATIONS);

        setCredentialsMatcher(matcher);
    }

    /**
     * 认证回调函数, 登录时调用.(认证)
     */
    // 对认证进行缓存处理
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {

        UsernamePasswordToken token = (UsernamePasswordToken)authcToken;

        User user = userMapper.getByUserName(token.getUsername());
        if (user != null) {
            if (user.getStatus().equals("disabled")) {
                throw new DisabledAccountException();
            }
            byte[] salt = Encodes.decodeHex(user.getSalt());
//            byte[] hashPassword = Digests.sha1(user.getPassword().getBytes(), salt, INTERATIONS);
//            String password = Encodes.encodeHex(hashPassword);
//
//            ((UsernamePasswordToken) authcToken).setPassword(password.toCharArray());
            ShiroUser shiroUser = new ShiroUser(user.getId(), user.getUsername(), user);
            // 这里可以缓存认证
            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(shiroUser, user.getPassword(),
                    ByteSource.Util.bytes(salt), getName());
            return info;
        } else {
            return null;
        }
    }


    /**
     * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用.(授权)
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        Collection<?> collection = principals.fromRealm(getName());
        if (CollectionUtils.isEmpty(collection)) {
            return null;
        }
        ShiroUser shiroUser = (ShiroUser) collection.iterator().next();

//        List<UserRole> userRoles = userRoleService.find(shiroUser.getId());
//        List<OrganizationRole> organizationRoles = organizationRoleService
//                .find(shiroUser.getUser().getOrganization().getId());
//
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//        info.addStringPermissions(makePermissions(userRoles, organizationRoles, shiroUser));

        return info;
    }

    public static class HashPassword {
        public String salt;
        public String password;
    }

    public static HashPassword encryptPassword(String plainPassword) {
        HashPassword result = new HashPassword();
        byte[] salt = Digests.generateSalt(SALT_SIZE);
        result.salt = Encodes.encodeHex(salt);

        byte[] hashPassword = Digests.sha1(plainPassword.getBytes(), salt, INTERATIONS);
        result.password = Encodes.encodeHex(hashPassword);
        return result;
    }

    /**
     * 验证密码
     * @param plainPassword 明文密码
     * @param password 密文密码
     * @param salt 盐值
     * @return
     */
    public static boolean validatePassword(String plainPassword, String password, String salt) {
        byte[] hashPassword = Digests.sha1(plainPassword.getBytes(), Encodes.decodeHex(salt), INTERATIONS);
        String oldPassword = Encodes.encodeHex(hashPassword);
        return password.equals(oldPassword);
    }
}
