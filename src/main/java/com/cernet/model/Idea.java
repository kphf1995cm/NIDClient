package com.cernet.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "NT_IDEA")
public class Idea {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
	 private Long id;
	
	 @Column(name = "NA_IP")
	 private String naIp;
	
	 
	 @Column(name = "IDEA_KEY")
	 private String ideaKey;

	 @Column(name = "START_TIME")
	 private Date startTime;
	 
	 @Column(name = "END_TIME")
	 private Date endTime;
	 
	 @Column(name = "CREATE_TIME")
	 private Date createTime;
	 
	 @Column(name = "IDEA_TYPE")
	 private String ideaType;

	 @Transient
	 private Long  startMilliSecond;
	 
	 @Transient
	 private Long  endMilliSecond;
	 
	 
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Long getStartMilliSecond() {
		return startMilliSecond;
	}

	public void setStartMilliSecond(Long startMilliSecond) {
		this.startMilliSecond = startMilliSecond;
	}

	public Long getEndMilliSecond() {
		return endMilliSecond;
	}

	public void setEndMilliSecond(Long endMilliSecond) {
		this.endMilliSecond = endMilliSecond;
	}

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

	public String getIdeaKey() {
		return ideaKey;
	}

	public void setIdeaKey(String ideaKey) {
		this.ideaKey = ideaKey;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getIdeaType() {
		return ideaType;
	}

	public void setIdeaType(String ideaType) {
		this.ideaType = ideaType;
	}

	
	 
}
