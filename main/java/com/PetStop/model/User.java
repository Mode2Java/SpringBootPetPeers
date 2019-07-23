package com.PetStop.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.*;

@Entity
@Table(name="petuser", schema="geetham")
@Scope("session")
public class User {
@Id
@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="petuser_ownerid_seq")
@Column(name="ownerid")
private int ownerId;

@Column(name="username",unique=true)
private String userName;

@Column(name="userpasswd")
private String password;

@Transient
private String passwordConfirm;

@OneToMany(mappedBy="user", cascade = CascadeType.ALL)
private List<Pet> pet;

public User() {
	super();
	// TODO Auto-generated constructor stub
}

public User(int ownerId, String userName, String password, String passwordConfirm) {
	super();
	this.ownerId = ownerId;
	this.userName = userName;
	this.password = password;
	this.passwordConfirm = passwordConfirm;
}

public int getOwnerId() {
	return ownerId;
}

public void setOwnerId(int ownerId) {
	this.ownerId = ownerId;
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

public String getPasswordConfirm() {
	return passwordConfirm;
}

public void setPasswordConfirm(String passwordConfirm) {
	this.passwordConfirm = passwordConfirm;
}

public List<Pet> getPet() {
	return pet;
}

public void setPet(List<Pet> pet) {
	this.pet = pet;
}

@Override
public String toString() {
	return "User [ownerId=" + ownerId + ", userName=" + userName + ", password=" + password + ", pet=" + pet + "]";
}



}
