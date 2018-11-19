package com.solace.streams.types;

public class User implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	public User() {}
	public User(final String id, final String username, final String fullName) {
	    this.id = id;
	    this.username = username;
	    this.fullName = fullName;
    }

	public void setId(final String id) {
		this.id = id;
	}
	public String getId() {
		return this.id;
	}

	public void setFullName(final String fullName) {
		this.fullName = fullName;
	}
	public String getFullName() {
		return this.fullName;
	}

	public void setUsername(final String username) {
		this.username = username;
	}
	public String getUsername() {
		return this.username;
	}
	
	
	private String id;
	private String username;
	private String fullName;
}
