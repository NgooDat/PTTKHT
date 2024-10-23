package com.drl.models;

public class Tai_Khoan {
	private int id;
    private String email;
    private String password;
    private int status;
    private int rulesID;
    
	public Tai_Khoan() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getRulesID() {
		return rulesID;
	}
	public void setRulesID(int rulesID) {
		this.rulesID = rulesID;
	}
	public Tai_Khoan(int id, String email, String password, int status, int rulesID) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.status = status;
		this.rulesID = rulesID;
	}
	public Tai_Khoan(String email, String password, int status, int rulesID) {
		super();
		this.email = email;
		this.password = password;
		this.status = status;
		this.rulesID = rulesID;
	}
	public Tai_Khoan(int id, String email, int status, int rulesID) {
		super();
		this.id = id;
		this.email = email;
		this.status = status;
		this.rulesID = rulesID;
	}
	
    
}
