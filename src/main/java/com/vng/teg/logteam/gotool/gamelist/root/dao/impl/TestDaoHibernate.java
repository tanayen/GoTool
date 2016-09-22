package com.vng.teg.logteam.gotool.gamelist.root.dao.impl;

import com.vng.teg.logteam.gotool.baseinterface.GenericDaoHibernate;
import com.vng.teg.logteam.gotool.gamelist.root.dao.TestDao;
import com.vng.teg.logteam.gotool.gamelist.root.model.Test;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("testDao")
public class TestDaoHibernate extends GenericDaoHibernate implements TestDao {

    @Override
    public List<Test> getList() {
        return getSession()
                .createCriteria(Test.class).list();
    }

}
