package com.vng.teg.logteam.gotool.user.login.dao;


import com.vng.teg.logteam.gotool.user.login.model.RolePermission;
import com.vng.teg.logteam.gotool.user.login.model.UserAccount;

import java.util.Set;

public interface SecurityDao {
    UserAccount loadUserByUsername(String username);

    Set<RolePermission> loadRoles(Long userId);
}
