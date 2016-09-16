package com.vng.teg.logteam.gotool.login.dao;


import com.vng.teg.logteam.gotool.login.model.RolePermission;
import com.vng.teg.logteam.gotool.login.model.UserAccount;

import java.util.Set;

public interface SecurityDao {
    UserAccount loadUserByUsername(String username);

    Set<RolePermission> loadRoles(Long userId);
}
