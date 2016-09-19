package com.vng.teg.logteam.gotool.user.login.dao.impl;

import com.vng.teg.logteam.gotool.baseinterface.GenericDaoHibernate;
import com.vng.teg.logteam.gotool.user.login.dao.SecurityDao;
import com.vng.teg.logteam.gotool.user.login.model.Role;
import com.vng.teg.logteam.gotool.user.login.model.RolePermission;
import com.vng.teg.logteam.gotool.user.login.model.User;
import com.vng.teg.logteam.gotool.user.login.model.UserAccount;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by tringuyen on 10/20/15.
 */
@Repository("securityDao")
public class SecurityDaoHibernate extends GenericDaoHibernate implements SecurityDao {

    @Override
    public UserAccount loadUserByUsername(String username) {
        Criteria criteria = getSession().createCriteria(User.class);
        criteria.add(Restrictions.and(Restrictions.eq("username", username)));

        Object result = criteria.uniqueResult();

        if (result == null) {
            throw new UsernameNotFoundException("Username: " + username + " not found");
        }

        User user = (User) result;

        if (!user.isAccountEnabled()) {
            throw new AccountExpiredException("Account is not activated.");
        }

        if (user.isAccountExpired() || user.isAccountLocked() || user.isCredentialsExpired()) {
            throw new AccountExpiredException("Account is expired or locked.");
        }

        Set<RolePermission> roles = new HashSet<>();

        for (Role userRole : user.getRoles()) {
            RolePermission role = new RolePermission(userRole.getId(), userRole.getName());
            roles.add(role);
        }

        UserAccount securityUser = new UserAccount(user.getId(), user.getUsername(), user.getPassword(),
                user.isAccountExpired(), user.isAccountLocked(), user.isCredentialsExpired(), user.isAccountEnabled(),
                roles);

        return securityUser;
    }


    @Override
    public Set<RolePermission> loadRoles(Long userId) {
        // Criteria criteria = getSession().createCriteria(UserRole.class);
        //
        // criteria.add(Restrictions.eq("id.userId", userId));
        //
        // List<UserRole> userRoles = criteria.list();
        //
        // Set<RolePermission> roles = new HashSet<>();
        //
        // for (UserRole userRole : userRoles) {
        // roles.add(new RolePermission(userRole.getId()))
        // }

        return null;
    }
}
