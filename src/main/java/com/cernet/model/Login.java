package com.cernet.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER_INFO_VIEW")
public class Login implements Serializable{
	@Id
	@Column(name = "ACCOUNT_ID")
	private String accountId;
	@Column(name =  "ACCOUNT")
	private String account;
	@Column(name = "KEY")
	private String key;
	@Column(name = "ENC_PW")
	private String encPw;
	
	@Column(name = "DEPARTMENT")
	private String department;
	
	@Column(name = "ROW_ID")
	private Integer rowId;
	
	@Column(name = "REAL_NAME")
	private String realName;
	
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getEncPw() {
		return encPw;
	}
	public void setEncPw(String encPw) {
		this.encPw = encPw;
	}
	public Integer getRowId() {
		return rowId;
	}
	public void setRowId(Integer rowId) {
		this.rowId = rowId;
	}
	
	

}
