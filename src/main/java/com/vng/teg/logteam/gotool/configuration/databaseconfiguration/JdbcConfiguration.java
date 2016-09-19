package com.vng.teg.logteam.gotool.configuration.databaseconfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan({"com.vng.teg.logteam.gotool.*"})
@PropertySource("classpath:jdbc.properties")
@EnableTransactionManagement
@EnableAspectJAutoProxy
public class JdbcConfiguration extends BaseDBConfiguration {

    @Autowired
    private ApplicationContext ctx;

    @Bean(name = "dstm")
    public DataSourceTransactionManager getTransactionManager() {
        DataSourceTransactionManager tx = new DataSourceTransactionManager();
        tx.setDataSource(dataSource());
        return tx;
    }
}
