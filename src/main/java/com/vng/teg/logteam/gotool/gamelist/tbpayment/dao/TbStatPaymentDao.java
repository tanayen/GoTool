package com.vng.teg.logteam.gotool.gamelist.tbpayment.dao;


import com.vng.teg.logteam.gotool.baseinterface.GenericDao;
import com.vng.teg.logteam.gotool.gamelist.tbpayment.model.TbStatPayment;

import java.util.List;

public interface TbStatPaymentDao extends GenericDao {
    List<TbStatPayment> getList();

}
