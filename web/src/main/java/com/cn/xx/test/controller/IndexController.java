package com.cn.xx.test.controller;

import com.cn.xx.test.service.InfoService;
import com.cn.xx.test.service.RedisService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author wangchen
 */
@Controller
public class IndexController {

//    @Value("${spring.savepath}")
//    private String spath;

    @Resource
    RedisService redisService;

    @Resource
    InfoService infoService;

    @RequestMapping({"/", "/index"})
    public String index(Model model) {
//        infoService.getById(Long.valueOf(1));
//        redisService.set("a" , UUID.randomUUID().toString());

        Subject subject = SecurityUtils.getSubject();

        System.out.println(subject.isAuthenticated());
        UsernamePasswordToken token = new UsernamePasswordToken("twt","111111");
        System.out.println("start =====================================");
        try {
            subject.login(token);
        }catch (AuthenticationException ex){
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }

        return "index";
    }

}
