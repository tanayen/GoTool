package com.vng.teg.logteam.gotool.gamelist.tbpayment.dao.impl;

import com.vng.teg.logteam.gotool.baseinterface.GenericDaoHibernateSupport;
import com.vng.teg.logteam.gotool.gamelist.tbpayment.dao.TbStatPaymentDao;

import com.vng.teg.logteam.gotool.gamelist.tbpayment.model.TbStatPayment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("testDao")
public class TbStatPaymentDaoHibernate extends GenericDaoHibernateSupport implements TbStatPaymentDao {

    @Override
    public List<TbStatPayment> getList() {
        return getSession()
                .createCriteria(TbStatPayment.class).list();
    }

}
