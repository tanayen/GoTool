package com.vng.teg.logteam.gotool.baseinterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCountCallbackHandler;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public abstract class GenericDaoJdbc {



    @Autowired
    private DataSource dataSource;

    protected DataSource getDataSource() {
        if (dataSource == null) {
            throw new RuntimeException("Datasource not found!");
        }
        return dataSource;
    }

    protected Connection getConnection() throws SQLException {
        return getDataSource().getConnection();
    }

    protected JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(getDataSource());
    }

    protected long count(String sql, Object[] params) {
        RowCountCallbackHandler countCallback = new RowCountCallbackHandler();  // not reusable
        getJdbcTemplate().query(sql, params, countCallback);
        return countCallback.getRowCount();
    }
}
