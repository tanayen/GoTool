package com.vng.teg.logteam.gotool.login.model;

// Generated Sep 18, 2015 5:42:33 PM by Hibernate Tools 4.0.0

import com.vng.teg.logteam.gotool.baseinterface.BaseModel;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Role generated by hbm2java
 */
@Entity
@Table(name = "role")
public class Role extends BaseModel implements java.io.Serializable {

	private Long id;
	private String name;
	private String description;
	

	public Role() {
	}

	public Role(long id, String name, Date creationDate, Date modificationDate,
			Integer status) {
		this.id = id;
		this.name = name;
		this.creationDate = creationDate;
		this.modificationDate = modificationDate;
		this.status = status;
	}

	public Role(long id, String name, String description, Date creationDate,
			Date modificationDate, Integer status) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.creationDate = creationDate;
		this.modificationDate = modificationDate;
		this.status = status;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false)
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "name", nullable = false, length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "description", length = 500)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
}
