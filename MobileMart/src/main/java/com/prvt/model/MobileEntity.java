package com.prvt.model;

import java.util.Date;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.GeneratedValue;

@Entity
@Table(name = "MobileDesc")
public class MobileEntity {
	
	@Id
	@GeneratedValue
	private int mobileID;
	private String mobileCompany;
	private String mobileModel;
	private String mobileColor;
	private String androidVersion;
	private String processor;
	private String specialFeature;
	private String accessories;
	private int numberOfCamera;
	private float mobileCamera;
	private float screenSize;
	
	@Column(unique = true)
	private long modelNumber;
	
	private long emiNumber;
	private long price;
	
	@Temporal(TemporalType.DATE)
	private Date dateBuyied = new Date(System.currentTimeMillis());
	@Temporal(TemporalType.DATE)
	private Date gauranteTill;
	@Temporal(TemporalType.DATE)
	private Date warranteTill;


// --------------- * --------------- * --------------- Constructor --------------- * --------------- * ---------------
	
	public MobileEntity() {
		}

	public MobileEntity(int mobileID, String mobileCompany, String mobileModel, String mobileColor,
			String androidVersion, String processor, String specialFeature, String accessories, int numberOfCamera,
			float mobileCamera, float screenSize, long modelNumber, long emiNumber, long price, Date dateBuyied,
			Date gauranteTill, Date warranteTill) {
		super();
		this.mobileID = mobileID;
		this.mobileCompany = mobileCompany;
		this.mobileModel = mobileModel;
		this.mobileColor = mobileColor;
		this.androidVersion = androidVersion;
		this.processor = processor;
		this.specialFeature = specialFeature;
		this.accessories = accessories;
		this.numberOfCamera = numberOfCamera;
		this.mobileCamera = mobileCamera;
		this.screenSize = screenSize;
		this.modelNumber = modelNumber;
		this.emiNumber = emiNumber;
		this.price = price;
		this.dateBuyied = dateBuyied;
		this.gauranteTill = gauranteTill;
		this.warranteTill = warranteTill;
	}


// --------------- * --------------- * --------------- Getter And Setter --------------- * --------------- * ---------------

	public int getMobileID() {
		return mobileID;
	}

	public void setMobileID(int mobileID) {
		this.mobileID = mobileID;
	}

	public String getMobileCompany() {
		return mobileCompany;
	}

	public void setMobileCompany(String mobileCompany) {
		this.mobileCompany = mobileCompany;
	}

	public String getMobileModel() {
		return mobileModel;
	}

	public void setMobileModel(String mobileModel) {
		this.mobileModel = mobileModel;
	}

	public String getMobileColor() {
		return mobileColor;
	}

	public void setMobileColor(String mobileColor) {
		this.mobileColor = mobileColor;
	}

	public String getAndroidVersion() {
		return androidVersion;
	}

	public void setAndroidVersion(String androidVersion) {
		this.androidVersion = androidVersion;
	}

	public String getProcessor() {
		return processor;
	}

	public void setProcessor(String processor) {
		this.processor = processor;
	}

	public String getSpecialFeature() {
		return specialFeature;
	}

	public void setSpecialFeature(String specialFeature) {
		this.specialFeature = specialFeature;
	}

	public String getAccessories() {
		return accessories;
	}

	public void setAccessories(String accessories) {
		this.accessories = accessories;
	}

	public int getNumberOfCamera() {
		return numberOfCamera;
	}

	public void setNumberOfCamera(int numberOfCamera) {
		this.numberOfCamera = numberOfCamera;
	}

	public float getMobileCamera() {
		return mobileCamera;
	}

	public void setMobileCamera(float mobileCamera) {
		this.mobileCamera = mobileCamera;
	}

	public float getScreenSize() {
		return screenSize;
	}

	public void setScreenSize(float screenSize) {
		this.screenSize = screenSize;
	}

	public long getModelNumber() {
		return modelNumber;
	}

	public void setModelNumber(long modelNumber) {
		this.modelNumber = modelNumber;
	}

	public long getEmiNumber() {
		return emiNumber;
	}

	public void setEmiNumber(long emiNumber) {
		this.emiNumber = emiNumber;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public Date getDateBuyied() {
		return dateBuyied;
	}

	public void setDateBuyied(Date dateBuyied) {
		this.dateBuyied = dateBuyied;
	}

	public Date getGauranteTill() {
		return gauranteTill;
	}

	public void setGauranteTill(Date gauranteTill) {
		this.gauranteTill = gauranteTill;
	}

	public Date getWarranteTill() {
		return warranteTill;
	}

	public void setWarranteTill(Date warranteTill) {
		this.warranteTill = warranteTill;
	}

	public void copy(MobileEntity entity) {
		this.mobileCompany = entity.getMobileCompany();
		this.mobileModel = entity.getMobileModel();
		this.mobileColor = entity.getMobileColor();
		this.androidVersion = entity.getAndroidVersion();
		this.processor = entity.getProcessor();
		this.specialFeature = entity.getSpecialFeature();
		this.accessories = entity.getAccessories();
		this.numberOfCamera = entity.getNumberOfCamera();
		this.mobileCamera = entity.getMobileCamera();
		this.screenSize = entity.getScreenSize();
		this.modelNumber = entity.getModelNumber();
		this.emiNumber = entity.getEmiNumber();
		this.price = entity.getPrice();
		this.dateBuyied = entity.getDateBuyied();
		this.gauranteTill = entity.getGauranteTill();
		this.warranteTill = entity.getWarranteTill();
		
	}

	
	
}
