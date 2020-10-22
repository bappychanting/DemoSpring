package com.bappy.npspring5tutorial.dto;

import java.util.Set;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.bappy.npspring5tutorial.entities.User;
import com.bappy.npspring5tutorial.entities.User.Role;

public class UserEditForm {
	
	@NotNull
	@Size(min=1, max=255, message="{lengthError}")
	private String name;

	private Set<Role> roles;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
}
