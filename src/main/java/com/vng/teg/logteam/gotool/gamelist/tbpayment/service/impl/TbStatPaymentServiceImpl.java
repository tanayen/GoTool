package com.vng.teg.logteam.gotool.gamelist.tbpayment.service.impl;

import com.vng.teg.logteam.gotool.baseinterface.BaseService;
import com.vng.teg.logteam.gotool.baseinterface.ModelConstant;
import com.vng.teg.logteam.gotool.gamelist.tbpayment.dao.TbStatPaymentDao;
import com.vng.teg.logteam.gotool.gamelist.tbpayment.form.TbStatPaymentForm;
import com.vng.teg.logteam.gotool.gamelist.tbpayment.model.TbStatPayment;
import com.vng.teg.logteam.gotool.gamelist.tbpayment.service.TbStatPaymentService;
import com.vng.teg.logteam.gotool.utils.ConvertUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service("tbStatPaymentService")
public class TbStatPaymentServiceImpl extends BaseService implements TbStatPaymentService {

    private static final String DATE_TIME_SPLIT = "-";

    @Autowired
    @Qualifier("tbStatPaymentDaoJdbc")
    private TbStatPaymentDao tbStatPaymentDao;


    @Override
    @Transactional(transactionManager = "dstm", readOnly = true)
    public List<TbStatPayment> getList() {
        return tbStatPaymentDao.getList();
    }


    @Override
    public Map<String, Object> list(TbStatPaymentForm tbStatPaymentForm) {

        String fromDate = "";
        String toDate = "";
        if (tbStatPaymentForm.getRangeDate() != null && !"".equals(tbStatPaymentForm.getRangeDate())) {
            fromDate = tbStatPaymentForm.getRangeDate().split(" - ")[0].trim().replaceAll("/", DATE_TIME_SPLIT);
            toDate = tbStatPaymentForm.getRangeDate().split(" - ")[1].trim().replaceAll("/", DATE_TIME_SPLIT);
        }


        Long recordsTotal = tbStatPaymentDao.count();
        Long recordsFiltered = tbStatPaymentDao.countAndFilter(null, fromDate, toDate);
        List<List<String>> data = tbStatPaymentDao.list(tbStatPaymentForm.getLength() == null ? ConvertUtils.toInt(ModelConstant.DEFAULT_PAGE_SIZE, 0) : tbStatPaymentForm.getLength(),
                tbStatPaymentForm.getStart() == null ? ConvertUtils.toInt(ModelConstant.DEFAULT_PAGE_SIZE, 0) : tbStatPaymentForm.getStart(),
                fromDate, toDate);
        return new HashMap<String, Object>() {{
            put("recordsTotal", recordsTotal);
            put("recordsFiltered", recordsFiltered);
            put("draw", tbStatPaymentForm.getDraw());
            put("data", data);
        }};
    }
}
