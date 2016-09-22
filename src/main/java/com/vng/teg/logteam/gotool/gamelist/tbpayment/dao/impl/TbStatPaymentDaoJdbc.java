package com.vng.teg.logteam.gotool.gamelist.tbpayment.dao.impl;

import com.vng.teg.logteam.gotool.baseinterface.GenericDaoJdbc;
import com.vng.teg.logteam.gotool.baseinterface.JdbcConstant;
import com.vng.teg.logteam.gotool.gamelist.tbpayment.dao.TbStatPaymentDao;
import com.vng.teg.logteam.gotool.gamelist.tbpayment.model.TbStatPayment;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

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

    @Override
    public Long count() {
        String sql = "select count(0) as count from tb_stat_payment";
        return getJdbcTemplate().query(sql, (rs, rownum) -> {
            return rs.getLong("count");
        }).stream().findFirst().orElse(null);
    }

    @Override
    public Long countAndFilter(Map<String, String> mapFilter, String fromDate, String toDate) {
        StringBuilder sql = new StringBuilder("select count(0) as count from tb_stat_payment");

        if (!"".equals(fromDate) && !"".equals(toDate)) {
            sql.append(JdbcConstant.WHERE + "log_date" + JdbcConstant.GE + "'" + fromDate + "'" +
                    JdbcConstant.AND + "log_date" + JdbcConstant.LE + "'" + toDate + "'");
        }

        if (mapFilter != null) {
            if (mapFilter.size() >= 0) {
                mapFilter.keySet().stream().forEach(key -> {
                    if (sql.toString().contains(JdbcConstant.WHERE.trim())) {
                        sql.append(JdbcConstant.AND + key + JdbcConstant.LIKE + "%" + mapFilter.get(key) + "%");
                    } else {
                        sql.append(JdbcConstant.WHERE + key + JdbcConstant.LIKE + "%" + mapFilter.get(key) + "%");
                    }
                });
            }
        }

        return getJdbcTemplate().query(sql.toString(), (rs, rownum) -> {
            return rs.getLong("count");
        }).stream().findFirst().orElse(null);
    }

    @Override
    public List<List<String>> list(Integer pageSize, Integer startValue, String fromDate, String toDate) {
        StringBuilder sql = new StringBuilder("select * from tb_stat_payment");

        if (!"".equals(fromDate) && !"".equals(toDate)) {
            sql.append(JdbcConstant.WHERE + "log_date" + JdbcConstant.GE + "'" + fromDate + "'" +
                    JdbcConstant.AND + "log_date" + JdbcConstant.LE + "'" + toDate + "'");
        }

        sql.append(JdbcConstant.LIMIT + startValue + ", " + pageSize);

        return getJdbcTemplate().query(sql.toString(), (rs, rownum) -> {
            List<String> results = new ArrayList<>();
            results.add(rs.getString("game_code"));
            results.add(rs.getDate("log_date") + "");
            results.add(rs.getString("server_id"));
            results.add(rs.getString("account"));
            results.add(rs.getDouble("charge_amt") + "");
            return results;
        });
    }
}
