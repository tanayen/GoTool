package com.vng.teg.logteam.gotool.gamelist.test.controller;

import com.vng.teg.logteam.gotool.baseinterface.BaseController;
import com.vng.teg.logteam.gotool.gamelist.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController extends BaseController{

    @Autowired
    private TestService testService;

    @RequestMapping("/")
    public String index() {
//        String s = testService.getList();
        return testService.getList();
    }
}
