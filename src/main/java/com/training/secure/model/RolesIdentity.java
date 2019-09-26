package com.training.secure.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

import com.sun.istack.NotNull;

@Embeddable
public class RolesIdentity implements Serializable{
	
	private static final long serialVersionUID = -402320144948311753L;


	@NotNull
	private String userName;
	
	
	@NotNull
	private String authority;


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getAuthority() {
		return authority;
	}


	public void setAuthority(String authority) {
		this.authority = authority;
	}

}
