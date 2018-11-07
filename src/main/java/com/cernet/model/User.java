package com.cernet.model;

import java.util.Date;




public class User {
	
	
	 private Integer id;
	
	 private String loginName;
	 
	 private Integer groupId;
	 
	 private String passwd;
	 
	 private Date expireDate;
	 
	 private String userName;
	 
	 private String identityId;
	 
	 //private Date regDate;
	 
	 private Integer nonece;
	 
	 private String macAddr;
	 
	 private Integer port;
	 
	 private Date authdate;
	 
	 private String didName;
	 
	 private String didAddr;
	 
	 private String ipAddr;
	 
	 private String apName;
	 
	 private String clientName;
	 
	 private String clientType;
	 
	 private String mobile;
	 
	 
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientType() {
		return clientType;
	}

	public void setClientType(String clientType) {
		this.clientType = clientType;
	}

	public String getApName() {
		return apName;
	}

	public void setApName(String apName) {
		this.apName = apName;
	}

	public String getIpAddr() {
		return ipAddr;
	}

	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}

	public String getDidName() {
		return didName;
	}
	
	public void setDidName(String didName) {
		this.didName = didName;
	}
	
	public String getDidAddr() {
		return didAddr;
	}
	public void setDidAddr(String didAddr) {
		this.didAddr = didAddr;
	}
	public Date getAuthdate() {
		return authdate;
	}
	public void setAuthdate(Date authdate) {
		this.authdate = authdate;
	}
	public String getMacAddr() {
		return macAddr;
	}
	public void setMacAddr(String macAddr) {
		this.macAddr = macAddr;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public Integer getGroupId() {
		return groupId;
	}
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public Date getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getIdentityId() {
		return identityId;
	}
	public void setIdentityId(String identityId) {
		this.identityId = identityId;
	}
	
	public Integer getNonece() {
		return nonece;
	}
	public void setNonece(Integer nonece) {
		this.nonece = nonece;
	}
	public Integer getPort() {
		return port;
	}
	public void setPort(Integer port) {
		this.port = port;
	}
	 
	 
}
