package com.cn.xx.test.shiro.AuthRealm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Component;

import java.security.Permissions;
import java.util.HashMap;

@Component
public class MyShiroRealm1 extends AuthorizingRealm {


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//        System.out.println("权限配置-->com.cn.lucky.morning.model.web.shiro.MyShiroRealm.doGetAuthorizationInfo()");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

        authorizationInfo.addStringPermission("*:ADD");

        return authorizationInfo;
    }

    /*主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确。*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {
        //获取用户的输入的账号.
        String account = (String)token.getPrincipal();
//        System.out.println(token.getCredentials());
        //通过username从数据库中查找 User对象，如果找到，没找到.
        //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法

        Md5Hash md5Hash = new Md5Hash("111111","111111salt",2);
        System.out.println("MyShiroRealm1    :   " + md5Hash.toHex());
        HashMap hs = new HashMap();
        hs.put("name1","fs");

        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                hs,
                md5Hash.toHex(), //密码
                ByteSource.Util.bytes("111111salt"),//salt=username+salt
                "RealmName1"  //realm name
        );
        return authenticationInfo;
    }

}
