package com.training.secure.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="authorities")
public class Authorithy {
	
	
	
	
	@EmbeddedId
	private RolesIdentity rolesIdentity;

	public RolesIdentity getRolesIdentity() {
		return rolesIdentity;
	}

	public void setRolesIdentity(RolesIdentity rolesIdentity) {
		this.rolesIdentity = rolesIdentity;
	}
	
}
