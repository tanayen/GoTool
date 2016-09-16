package com.vng.teg.logteam.gotool.gamelist.tbpayment.controller;

import com.vng.teg.logteam.gotool.baseinterface.BaseController;
import com.vng.teg.logteam.gotool.gamelist.tbpayment.service.TbStatPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TbStatPaymentController extends BaseController{

    @Autowired
    private TbStatPaymentService tbStatPaymentService;

    @RequestMapping("/payment")
    public String index(Model model) {
        model.addAttribute("data", tbStatPaymentService.getList());
        return "payment";
    }
}
