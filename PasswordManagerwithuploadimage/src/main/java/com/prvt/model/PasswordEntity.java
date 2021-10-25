package com.prvt.model;


import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@javax.persistence.Entity
@Table(name = "PasswordEntity")
public class PasswordEntity {
	
	@Id
	@GeneratedValue
	private Integer serialNo;
	private String website;
	private String userName;
	private String password;

//	@JsonFormat(pattern = "yyyy-MM-dd", shape = Shape.STRING)
//	@Column(name = "Password Created")
//	private String DateCreated;
//	@JsonFormat(pattern = "yyyy-MM-dd", shape = Shape.STRING)
//	@Column(name = "Password Renew On")
//	private String DateRenew;

	@Temporal(TemporalType.DATE)
	private Date passWordCreated = new Date(System.currentTimeMillis());

//	@Value("${model.PasswordEntity.RenewDate}")
	@Temporal(TemporalType.DATE)
	private Date RenewDate;
	
	
	private int dateRemaing;
	
// --------------- * --------------- * --------------- Constructor --------------- * --------------- * ---------------
	public PasswordEntity() {
	}

	public PasswordEntity(Integer serialNo, String website, String userName, String password, Date passWordCreated,
			Date renewDate, int dateRemaing) {
		super();
		this.serialNo = serialNo;
		this.website = website;
		this.userName = userName;
		this.password = password;
		this.passWordCreated = passWordCreated;
		RenewDate = renewDate;
		this.dateRemaing = dateRemaing;
	}

// --------------- * --------------- * --------------- Getter And Setter --------------- * --------------- * ---------------

	public Integer getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(Integer serialNo) {
		this.serialNo = serialNo;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getPassWordCreated() {
		return passWordCreated;
	}
	
	public Date getRenewDate() {
		return RenewDate;
	}

	public void setRenewDate(Date renewDate) {
		RenewDate = renewDate;
	}
	
	public int getDateRemaing() {
		return dateRemaing;
	}

	public void setDateRemaing(int dateRemaing) {
//		this.dateRemaing = passWordCreated.compareTo(RenewDate);
//		this.dateRemaing = RenewDate.compareTo(passWordCreated);
//		this.dateRemaing =  ChronoUnit.DAYS.between(passWordCreated, RenewDate);
//		this.dateRemaing =  Period.between(passWordCreated, RenewDate);

		System.out.println(dateRemaing);
	}
	
//	public getDateCreated() {
//		return DateCreated;
//	}
//
//	public void setDateCreated(String dateCreated) {
//		DateCreated = dateCreated;
//	}
//	public String getDateRenew() {
//		return DateRenew;
//	}
//
//	public void setDateRenew(String dateRenew) {
//		DateRenew = dateRenew;
//	}


//	@Override
//	public String toString() {
//		return "PasswordEntity [serialNo=" + serialNo + ", website=" + website + ", userName=" + userName
//				+ ", password=" + password + "]";
//	}

	@Override
	public String toString() {
		return "PasswordEntity [serialNo=" + serialNo + ", website=" + website + ", userName=" + userName
				+ ", password=" + password + ", passWordCreated=" + passWordCreated + "]";
	}

	// --------------- * --------------- * --------------- Copy Method --------------- * --------------- * ---------------
	public void copy(PasswordEntity passEntity) {
		this.website = passEntity.getWebsite();
		this.userName = passEntity.getUserName();
		this.password = passEntity.getPassword();
		
	}
}
