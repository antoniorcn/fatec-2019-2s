package edu.curso.entidade;

import java.io.Serializable;

public class Usuario implements Serializable {
	private static final long serialVersionUID = -7551442623760958472L;
	private String username;
	private String password;
	private String profile;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
}
