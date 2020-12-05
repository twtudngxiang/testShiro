package com.cn.xx.test.controller;

import com.cn.xx.test.service.InfoService;
import com.cn.xx.test.service.RedisService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @author wangchen
 */
@Controller
@RequestMapping({"/page/"})
public class PageIndexController {

//    @Value("${spring.savepath}")
//    private String spath;

    @Resource
    RedisService redisService;

    @Resource
    InfoService infoService;

    @RequestMapping({"/", "/index"})
    public String index(Model model) {
        return "page/index";
    }

    @RequestMapping({"/login"})
    public String login(Model model) {
        return "page/login";
    }



}
