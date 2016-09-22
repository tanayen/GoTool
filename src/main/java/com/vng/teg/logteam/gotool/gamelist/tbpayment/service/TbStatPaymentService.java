package com.vng.teg.logteam.gotool.gamelist.tbpayment.service;


import com.vng.teg.logteam.gotool.baseinterface.BaseService;
import com.vng.teg.logteam.gotool.gamelist.tbpayment.form.TbStatPaymentForm;
import com.vng.teg.logteam.gotool.gamelist.tbpayment.model.TbStatPayment;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface TbStatPaymentService  {

    List<TbStatPayment> getList();

    Map<String, Object> list(TbStatPaymentForm tbStatPaymentForm);

}
