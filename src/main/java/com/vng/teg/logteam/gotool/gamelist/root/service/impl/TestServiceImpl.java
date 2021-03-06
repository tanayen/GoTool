package com.vng.teg.logteam.gotool.gamelist.root.service.impl;

import com.vng.teg.logteam.gotool.gamelist.root.dao.TestDao;
import com.vng.teg.logteam.gotool.gamelist.root.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("testService")
public class TestServiceImpl implements TestService {

    @Autowired
    private TestDao testDao;


    @Override
    @Transactional(transactionManager = "htm", readOnly = true)
    public String getList() {
        return testDao.getList().stream().findFirst().orElse(null).getName();
    }
}
