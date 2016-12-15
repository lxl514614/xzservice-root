package com.xinhuanet.hylanda.security.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Administrator on 2016/12/9.
 */
public class ShiroDbRealm extends AuthorizingRealm {

    private static final Logger log = LoggerFactory.getLogger(ShiroDbRealm.class);

    private static final int INTERATIONS = 1024;
    private static final int SALT_SIZE = 8;
    private static final String ALGORITHM = "SHA-1";

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

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        return null;
    }
}
