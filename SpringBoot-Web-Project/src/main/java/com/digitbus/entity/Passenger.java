package com.digitbus.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

@Entity
@Table(name = "Passenger")
public class Passenger implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "passenger_id")
	private int id;

	@Column(name = "passenger_name", columnDefinition = "varchar(30)", nullable = false)
	private String name;

	@Column(name = "passenger_phone", unique = true, nullable = false)
	private long phone;

	@Column(name = "passenger_gender")
	private String gender;

	@Column(name = "passenger_age")
	private int age;

	@Column(name = "passenger_email", unique = true, nullable = false)
	private String email;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "passenger_city", columnDefinition = "varchar(30)", nullable = true)
	private String city;

	@Column(name = "passenger_pincode")
	private int pincode;

	@CreationTimestamp
	@Column(name = "created")
	private Timestamp createdDate;

	@UpdateTimestamp
	@Column(name = "modified")
	private Timestamp modifiedDate;

	@Version
	@Column(name = "version")
	private int version;

	public Passenger() {
	}

	public Passenger(String name, long phone, String gender, int age, String email, String password, String city,
			int pincode) {
		super();
		this.name = name;
		this.phone = phone;
		this.gender = gender;
		this.age = age;
		this.email = email;
		this.password = password;
		this.city = city;
		this.pincode = pincode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Timestamp getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "Passenger [id=" + id + ", name=" + name + ", phone=" + phone + ", gender=" + gender + ", age=" + age
				+ ", email=" + email + ", password=" + password + ", city=" + city + ", pincode=" + pincode
				+ ", createdDate=" + createdDate + ", modifiedDate=" + modifiedDate + ", version=" + version + "]";
	}

}