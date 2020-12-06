package com.cn.xx.test;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@DisplayName("我的第一个测试用例")
@SpringBootTest
@ExtendWith(SpringExtension.class)

public class UxxTest {

    @Autowired
    SecurityManager securityManager;

    @Autowired
    WebApplicationContext webApplicationContext;


    public MockMvc mockMvc;

    private void login(String username, String password) {

        final UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        final Subject subject = SecurityUtils.getSubject();

        subject.login(token);
    }

    @Test
    public void fd(){

        SecurityUtils.setSecurityManager(securityManager);

        Subject subject = SecurityUtils.getSubject();

        System.out.println(subject);
        UsernamePasswordToken token = new UsernamePasswordToken("twt","111111");
        mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .build();
        System.out.println("start =====================================");
        try {
            subject.login(token);
        }catch (AuthenticationException ex){
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }

        System.out.println(subject.isAuthenticated());

//        subject.getSession(true);
//        System.out.println(subject.getSession().getHost());
//        System.out.println(subject.getSession().getId());

        System.out.println(subject.isPermitted("ADD:vse"));
//        System.out.println(subject.isPermittedAll("fs.ADD", "USER.ADD2"));

        subject.logout();

        System.out.println(subject.isAuthenticated());

        System.out.println("end =====================================");

    }
}
