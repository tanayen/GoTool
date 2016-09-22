package com.vng.teg.logteam.gotool.gamelist.root.controller;

import com.vng.teg.logteam.gotool.baseinterface.BaseController;
import com.vng.teg.logteam.gotool.gamelist.root.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RootController extends BaseController{

    @RequestMapping("/")
    public String index() {
        return "index";
    }
}
