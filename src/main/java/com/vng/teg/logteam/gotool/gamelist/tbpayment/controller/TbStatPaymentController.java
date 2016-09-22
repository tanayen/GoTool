package com.vng.teg.logteam.gotool.gamelist.tbpayment.controller;

import com.vng.teg.logteam.gotool.baseinterface.BaseController;
import com.vng.teg.logteam.gotool.baseinterface.ModelConstant;
import com.vng.teg.logteam.gotool.gamelist.tbpayment.form.TbStatPaymentForm;
import com.vng.teg.logteam.gotool.gamelist.tbpayment.service.TbStatPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class TbStatPaymentController extends BaseController {

    @Autowired
    private TbStatPaymentService tbStatPaymentService;

    @RequestMapping("data")
    public String index() {
        return "gamelistpage/tbpayment";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/ajax/tbStatPayment")
    public void ajaxListInterHistoryAction(HttpServletResponse response,
                                           @RequestParam(name = "rangeDate", defaultValue = ModelConstant.DEFAULT_VALUE, required = false) String rangeDate,
                                           @ModelAttribute TbStatPaymentForm tbStatPayment) throws IOException {
        tbStatPayment.setRangeDate(rangeDate);
        writeJsonResponse(response, tbStatPaymentService.list(tbStatPayment));
    }
}
