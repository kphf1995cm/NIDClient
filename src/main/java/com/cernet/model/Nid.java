package com.cernet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "NT_NID")
public class Nid {
	
	@Id
    @Column(name = "ID")
	 private Long id;
	
	 @Column(name = "DID_BIN")
	 private String didBin;
	
	 
	 @Column(name = "DID_DEC")
	 private Integer didDec;

	 @Column(name = "ORG_DIGIT")
	 private Integer orgDigit;
	 
	 @Column(name = "USR_DIGIT")
	 private Integer usrDigit;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDidBin() {
		return didBin;
	}

	public void setDidBin(String didBin) {
		this.didBin = didBin;
	}

	public Integer getDidDec() {
		return didDec;
	}

	public void setDidDec(Integer didDec) {
		this.didDec = didDec;
	}

	public Integer getOrgDigit() {
		return orgDigit;
	}

	public void setOrgDigit(Integer orgDigit) {
		this.orgDigit = orgDigit;
	}

	public Integer getUsrDigit() {
		return usrDigit;
	}

	public void setUsrDigit(Integer usrDigit) {
		this.usrDigit = usrDigit;
	}

	
}
