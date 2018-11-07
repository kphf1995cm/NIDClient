package com.cernet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "NT_DOMAIN")
public class Domain {
	
	@Id
    @Column(name = "ID")
	 private Long id;
	
	 @Column(name = "NA_IP")
	 private String naIp;
	
	 
	 @Column(name = "NA_NAME")
	 private String naName;

	 @Column(name = "IP_ADDRESS")
	 private String ipAddress;
	 
	 @Column(name = "ADDOPR")
	 private String addopr;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaIp() {
		return naIp;
	}

	public void setNaIp(String naIp) {
		this.naIp = naIp;
	}

	public String getNaName() {
		return naName;
	}

	public void setNaName(String naName) {
		this.naName = naName;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getAddopr() {
		return addopr;
	}

	public void setAddopr(String addopr) {
		this.addopr = addopr;
	}
	 
	
	 
}
