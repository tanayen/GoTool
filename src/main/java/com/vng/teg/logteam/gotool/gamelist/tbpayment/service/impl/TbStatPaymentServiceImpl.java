package com.vng.teg.logteam.gotool.gamelist.tbpayment.service.impl;

import com.vng.teg.logteam.gotool.gamelist.tbpayment.dao.TbStatPaymentDao;
import com.vng.teg.logteam.gotool.gamelist.tbpayment.model.TbStatPayment;
import com.vng.teg.logteam.gotool.gamelist.tbpayment.service.TbStatPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("tbStatPaymentService")
public class TbStatPaymentServiceImpl implements TbStatPaymentService {

    @Autowired
    @Qualifier("tbStatPaymentDaoJdbc")
    private TbStatPaymentDao tbStatPaymentDao;


    @Override
    @Transactional(transactionManager = "dstm", readOnly = true)
    public List<TbStatPayment> getList() {
        return tbStatPaymentDao.getList();
    }
}