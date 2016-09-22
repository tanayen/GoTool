package com.vng.teg.logteam.gotool.gamelist.tbpayment.dao;


import com.vng.teg.logteam.gotool.baseinterface.GenericDao;
import com.vng.teg.logteam.gotool.gamelist.tbpayment.model.TbStatPayment;

import java.util.List;
import java.util.Map;

public interface TbStatPaymentDao extends GenericDao {
    List<TbStatPayment> getList();

    Long count();

    Long countAndFilter(Map<String, String> mapFilter, String fromDate, String toDate);

    List<List<String>> list(Integer pageSize, Integer startValue, String fromDate, String toDate);
}
