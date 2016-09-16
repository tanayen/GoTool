package com.vng.teg.logteam.gotool.login.service;

import com.vng.teg.logteam.gotool.login.dao.SecurityDao;
import com.vng.teg.logteam.gotool.login.model.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("myUserDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private SecurityDao securityDao;

	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		UserAccount user = securityDao.loadUserByUsername(username);
		return buildLightweightCredentials(user);
	}
	
	private UserAccount buildLightweightCredentials(UserAccount user){
		UserAccount newUser = new UserAccount(user.getId(), user.getUsername(), user.getPassword(),
				!user.isAccountNonExpired(), !user.isAccountNonLocked(), 
				!user.isCredentialsNonExpired(), user.isEnabled(), user.getRoles());
		return newUser;
	}
}
