package com.tmanagement.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="csa", uniqueConstraints=
@UniqueConstraint(columnNames={"username"}))
public class CSA {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int csaId;
	public String circle;
	public String name;
	public String username;
	public String pwd;
	
	
	@JsonIgnore
	@OneToMany(mappedBy="csa",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	public List<Tower>towers;
	
	@JsonIgnore
	@OneToMany(mappedBy="csa",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	public List<Complaint>complaints;
	
	public String email;
	
	
	
	public List<Tower> getTowers() {
		return towers;
	}
	public void setTowers(List<Tower> towers) {
		this.towers = towers;
	}
	public List<Complaint> getComplaints() {
		return complaints;
	}
	public void setComplaints(List<Complaint> complaints) {
		this.complaints = complaints;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getCsaId() {
		return csaId;
	}
	public void setCsaId(int csaId) {
		this.csaId = csaId;
	}
	public String getCircle() {
		return circle;
	}
	public void setCircle(String circle) {
		this.circle = circle;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	
}
