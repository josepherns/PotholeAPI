package com.Pothole.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Table(name = "Pothole")
@Entity
public class Pothole {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="date_time")
	private java.util.Date dateTime;
	
	@Column(name="location")
	private String location;
	
	@Column(name ="latitude")
	private Double latitude;
	
	@Column(name="longitude")
	private Double longitude;
	
	@Lob
	@Type(type="org.hibernate.type.ImageType")
	private byte[] blobData;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public java.util.Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(java.util.Date dateTime) {
		this.dateTime = dateTime;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public byte[] getBlobData() {
		return blobData;
	}

	public void setBlobData(byte[] blobData) {
		this.blobData = blobData;
	}
	
	
	
}
