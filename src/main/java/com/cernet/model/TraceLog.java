package com.cernet.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "NT_TRACE_LOG")
public class TraceLog {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
	 private Long id;
	
	 @Column(name = "TRACED_IP")
	 private String tracedIp;
	
	 
	 @Column(name = "TRACED_MACHASH")
	 private String tracedMachash;

	 @Column(name = "NID")
	 private String nid;
	 
	 @Column(name = "DID")
	 private String did;

	 @Column(name = "NID_GROUP_NAME")
	 private String nidGroupName;
	 
	 @Column(name = "IP_GROUP_NAME")
	 private String ipGroupName;
	 
	 @Column(name = "TIME")
	 private String timeDate;
	 
	 @Column(name = "MAC")
	 private String mac;
	 
	 @Column(name = "CREATE_TIME")
	 private Date createTime;
	 
	 @Column(name = "ADDOPR")
	 private String addOpr;

	 @Column(name = "TRACE_TYPE")
	 private String traceType;
	 
	 @Column(name = "PORT")
	 private Integer port;
	 
	 @Column(name = "AUDITOPR")
	 private String auditOpr;
	 
	 
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTracedIp() {
		return tracedIp;
	}

	public void setTracedIp(String tracedIp) {
		this.tracedIp = tracedIp;
	}

	public String getTracedMachash() {
		return tracedMachash;
	}

	public void setTracedMachash(String tracedMachash) {
		this.tracedMachash = tracedMachash;
	}

	public String getNid() {
		return nid;
	}

	public void setNid(String nid) {
		this.nid = nid;
	}

	public String getDid() {
		return did;
	}

	public void setDid(String did) {
		this.did = did;
	}

	

	public String getNidGroupName() {
		return nidGroupName;
	}

	public void setNidGroupName(String nidGroupName) {
		this.nidGroupName = nidGroupName;
	}

	public String getIpGroupName() {
		return ipGroupName;
	}

	public void setIpGroupName(String ipGroupName) {
		this.ipGroupName = ipGroupName;
	}

	


	public String getTimeDate() {
		return timeDate;
	}

	public void setTimeDate(String timeDate) {
		this.timeDate = timeDate;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getAddOpr() {
		return addOpr;
	}

	public void setAddOpr(String addOpr) {
		this.addOpr = addOpr;
	}

	public String getTraceType() {
		return traceType;
	}

	public void setTraceType(String traceType) {
		this.traceType = traceType;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public String getAuditOpr() {
		return auditOpr;
	}

	public void setAuditOpr(String auditOpr) {
		this.auditOpr = auditOpr;
	}

	
	 
	 
}
