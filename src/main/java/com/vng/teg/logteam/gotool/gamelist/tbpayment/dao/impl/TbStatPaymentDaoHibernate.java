package com.vng.teg.logteam.gotool.gamelist.tbpayment.dao.impl;

import com.vng.teg.logteam.gotool.baseinterface.GenericDaoHibernate;
import com.vng.teg.logteam.gotool.gamelist.tbpayment.dao.TbStatPaymentDao;
import com.vng.teg.logteam.gotool.gamelist.tbpayment.model.TbStatPayment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("tbStatPaymentDao")
public class TbStatPaymentDaoHibernate extends GenericDaoHibernate implements TbStatPaymentDao {

    @Override
    public List<TbStatPayment> getList() {
        return getSession()
                .createCriteria(TbStatPayment.class)
                .list();
    }

}
