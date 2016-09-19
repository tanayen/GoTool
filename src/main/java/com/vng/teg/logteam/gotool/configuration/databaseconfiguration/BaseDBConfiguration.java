package com.vng.teg.logteam.gotool.configuration.databaseconfiguration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

public abstract class BaseDBConfiguration {

    @Value("${jdbc.driverClassName}")
    protected String driver;

    @Value("${jdbc.url}")
    protected String url;

    @Value("${jdbc.username}")
    protected String userName;

    @Value("${jdbc.password}")
    protected String pass;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(userName);
        dataSource.setPassword(pass);
        return dataSource;
    }

}
