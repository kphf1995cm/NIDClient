package com.cernet.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "NT_TRACE_RESULT")
public class TraceResult {
	
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
	 private String didstr;

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
	 private String traceType;//域内或者域间
	 
	 @Column(name = "PORT")
	 private Integer port;
	 
	 @Column(name = "AUDITOPR")
	 private String auditOpr;
	 
	 @Column(name = "LOGINSTYLE")
	 private String loginStyle;//登录方式，1学号，2手机号
	 
	 @Column(name = "IDENTITYID")
	 private String identityId;//身份证号
	 
	 @Column(name = "CLIENTNAME")
	 private String clientName;//学号
	 
	 @Column(name = "MOBLIE")
	 private String mobile;//手机号
	 
	 @Column(name = "DIDNAME")
	 private String didName;//姓名
	 
	 @Column(name = "DIDADDR")
	 private String didAddr;//藉惯
	 
	 @Column(name = "APNAME")
	 private String apName;
	 
	 @Column(name = "SWITCHIP")
	 private String switchIp;//交换机IP
	 
	 @Column(name = "INTYPE")
	 private String inType;//接入类型，1有线，2无线
	 
	 @Column(name = "IDEARTYPE")
	 private String idearType;//1为idear+time ,2为idear+mac
	 
	 
	public String getIdearType() {
		return idearType;
	}

	public void setIdearType(String idearType) {
		this.idearType = idearType;
	}

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

	

	

	public String getDidstr() {
		return didstr;
	}

	public void setDidstr(String didstr) {
		this.didstr = didstr;
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

	public String getLoginStyle() {
		return loginStyle;
	}

	public void setLoginStyle(String loginStyle) {
		this.loginStyle = loginStyle;
	}

	public String getIdentityId() {
		return identityId;
	}

	public void setIdentityId(String identityId) {
		this.identityId = identityId;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
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

	public String getApName() {
		return apName;
	}

	public void setApName(String apName) {
		this.apName = apName;
	}

	public String getSwitchIp() {
		return switchIp;
	}

	public void setSwitchIp(String switchIp) {
		this.switchIp = switchIp;
	}

	public String getInType() {
		return inType;
	}

	public void setInType(String inType) {
		this.inType = inType;
	}

	
	 
	 
}
