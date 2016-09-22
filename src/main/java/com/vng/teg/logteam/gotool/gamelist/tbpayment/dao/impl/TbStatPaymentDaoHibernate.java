package com.vng.teg.logteam.gotool.gamelist.tbpayment.dao.impl;

import com.vng.teg.logteam.gotool.baseinterface.GenericDaoHibernate;
import com.vng.teg.logteam.gotool.gamelist.tbpayment.dao.TbStatPaymentDao;
import com.vng.teg.logteam.gotool.gamelist.tbpayment.model.TbStatPayment;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("tbStatPaymentDaoHibernate")
public class TbStatPaymentDaoHibernate extends GenericDaoHibernate implements TbStatPaymentDao {

    @Override
    public List<TbStatPayment> getList() {
        return getSession()
                .createCriteria(TbStatPayment.class)
                .list();
    }

    @Override
    public Long count() {
        return null;
    }

    @Override
    public Long countAndFilter(Map<String, String> mapFilter, String fromDate, String toDate) {
        return null;
    }

    @Override
    public List<List<String>> list(Integer pageSize, Integer startValue, String fromDate, String toDate) {
        return null;
    }
}
