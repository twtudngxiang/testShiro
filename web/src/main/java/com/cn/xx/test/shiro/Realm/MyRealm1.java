package com.cn.xx.test.shiro.Realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Component;


@Component
public class MyRealm1 implements Realm {

    public String getName() {
        return "myrealm1";
    }

    @Override
    public boolean supports(AuthenticationToken authenticationToken) {
        return authenticationToken instanceof UsernamePasswordToken; //仅支持UsernamePasswordToken类型的Token
    }


    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {
        String username = (String)token.getPrincipal();  //得到用户名
        String password = new String((char[])token.getCredentials()); //得到密码
//        if(!"twt".equals(username)) {
//            throw new UnknownAccountException(); //如果用户名错误
//        }
//
        if(!"111111".equals(password)) {
            throw new AuthenticationException(); //如果密码错误
        }
//        //如果身份认证验证成功，返回一个AuthenticationInfo实现；
//        return new SimpleAuthenticationInfo(username, password, getName());

        String userInfo = "principal1";

        Md5Hash md5Hash = new Md5Hash("111111","111111salt",2);
        System.out.println("MyRealm1    :   " + md5Hash.toHex());

        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                userInfo, //用户名
                md5Hash.toHex(), //密码
                ByteSource.Util.bytes("111111salt"),//salt=username+salt
                "RealmName1"
        );
        return authenticationInfo;


    }

    public static void main(String[] args) {
        //原始 密码
        String source = "111111";
        //盐
        String salt = "qwerty";
        //散列次数
        int hashIterations = 2;
        //上边散列1次：f3694f162729b7d0254c6e40260bf15c
        //上边散列2次：36f2dfa24d0a9fa97276abbe13e596fc
        //构造方法中：
        //第一个参数：明文，原始密码
        //第二个参数：盐，通过使用随机数
        //第三个参数：散列的次数，比如散列两次，相当 于md5(md5(''))
        Md5Hash md5Hash = new Md5Hash(source, salt, hashIterations);
        String password_md5 =  md5Hash.toString();
        System.out.println(password_md5);

        Sha256Hash sha256Hash = new Sha256Hash(source, salt, hashIterations);
        String p_sha256Hash =  sha256Hash.toString();
        System.out.println(p_sha256Hash);
        //第一个参数：散列算法
        SimpleHash simpleHashmd5 = new SimpleHash("md5", source, salt, hashIterations);
        System.out.println(simpleHashmd5.toString());

        //第一个参数：散列算法
        SimpleHash simpleHashsha256 = new SimpleHash("SHA-256", source, salt, hashIterations);
        System.out.println(simpleHashsha256.toString());
    }

}
