package com.cernet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "NT_GROUP")
public class Group {
	
	@Id
    @Column(name = "ID")
	 private Long id;
	
	 @Column(name = "GROUP_NAME")
	 private String groupName;
	
	 
	 @Column(name = "DIVID_ID")
	 private String dividId;

	 @Column(name = "ORG_ID")
	 private String orgId;
	 
	 @Column(name = "NA_IP")
	 private String naIp;

	 @Column(name = "ADDOPR")
	 private String addopr;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getDividId() {
		return dividId;
	}

	public void setDividId(String dividId) {
		this.dividId = dividId;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getNaIp() {
		return naIp;
	}

	public void setNaIp(String naIp) {
		this.naIp = naIp;
	}

	public String getAddopr() {
		return addopr;
	}

	public void setAddopr(String addopr) {
		this.addopr = addopr;
	}
	 
	 
}
