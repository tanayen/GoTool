package com.vng.teg.logteam.gotool.gamelist.root.dao;


import com.vng.teg.logteam.gotool.baseinterface.GenericDao;
import com.vng.teg.logteam.gotool.gamelist.root.model.Test;

import java.util.List;

public interface TestDao extends GenericDao {
    List<Test> getList();

}
