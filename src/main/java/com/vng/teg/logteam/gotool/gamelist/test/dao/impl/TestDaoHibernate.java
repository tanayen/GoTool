package com.vng.teg.logteam.gotool.gamelist.test.dao.impl;

import com.vng.teg.logteam.gotool.baseinterface.GenericDaoHibernateSupport;

import com.vng.teg.logteam.gotool.gamelist.test.dao.TestDao;
import com.vng.teg.logteam.gotool.gamelist.test.model.Test;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("testDao")
public class TestDaoHibernate extends GenericDaoHibernateSupport implements TestDao {

    @Override
    public List<Test> getList() {
        return getSession()
                .createCriteria(Test.class).list();
    }

}
