package com.vng.teg.logteam.gotool.user.login.model;

import org.springframework.security.core.GrantedAuthority;

public class RolePermission implements GrantedAuthority {
	private static final long serialVersionUID = 8631858321740129572L;

	private Long id;
	private String name;

	public RolePermission(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String getAuthority() {
		return name;
	}

}
