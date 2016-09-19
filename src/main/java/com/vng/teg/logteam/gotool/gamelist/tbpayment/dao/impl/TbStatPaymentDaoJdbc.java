package com.vng.teg.logteam.gotool.gamelist.tbpayment.dao.impl;

import com.vng.teg.logteam.gotool.baseinterface.GenericDaoJdbc;
import com.vng.teg.logteam.gotool.gamelist.tbpayment.dao.TbStatPaymentDao;
import com.vng.teg.logteam.gotool.gamelist.tbpayment.model.TbStatPayment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("tbStatPaymentDaoJdbc")
public class TbStatPaymentDaoJdbc extends GenericDaoJdbc implements TbStatPaymentDao {

    @Override
    public List getList() {
        String sql = "select * from tb_stat_payment";
        return getJdbcTemplate().query(sql, (rs, rownum) -> {
            TbStatPayment tbStatPayment = new TbStatPayment();
            tbStatPayment.setGameCode(rs.getString("game_code"));
            tbStatPayment.setServerId(rs.getString("server_id"));
            tbStatPayment.setChargeAmt(rs.getDouble("charge_amt"));
            tbStatPayment.setAccount(rs.getString("account"));
            tbStatPayment.setLogDate(rs.getDate("log_date"));
            return tbStatPayment;
        });
    }
}
