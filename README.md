# xzservice-root
一个多模块的ssm框架项目
目前只是做了基本的项目框架搭建.具体功能还没有实现.
项目为多模块项目,具体区分为以下模块
- xzservice-web:项目的web接口模块.负责前端页面请求及mvc控制
- xzservice-service:项目的业务处理模块.负责项目中各个业务线的业务处理
- xzservice-dao:项目的数据访问控制模块,负责项目中需要与数据库交互的统一入口
- xzservice-model:项目实体模块,负责项目中所有数据库实体对象,及po,jo,vo对象存储
- xzservice-security:项目权限管理控制模块.负责项目中用户访问权限控制
- xzservice-common:项目基础工具模块.负责项目中一些基础工具包的定义及使用

**`注意`**:目前项目还没有完善.只是做了个最基础的版本.
预计后来会加入`nosql`模块.`api`模块.单独提供restful风格的同意api入口.
`mq`模块.负责消息推送及拉取.
