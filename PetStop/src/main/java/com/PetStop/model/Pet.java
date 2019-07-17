package com.PetStop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="pets", schema="geetham")
public class Pet {

@Id
@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="pets_petid_seq")
@Column(name="petid")
private int petId;
@Column(name="petname")
private String petName;
@Column(name="petage")
private int petAge;
@Column(name="petplace")
private String petPlace;


@ManyToOne
@JoinColumn(name="ownerid")
private User user;


public Pet() {
	super();
	// TODO Auto-generated constructor stub
}

public Pet(int petId, String petName, int petAge, String petPlace) {
	super();
	this.petId = petId;
	this.petName = petName;
	this.petAge = petAge;
	this.petPlace = petPlace;
	//this.user = user;
}





public int getPetId() {
	return petId;
}


public void setPetId(int petId) {
	this.petId = petId;
}


public String getPetName() {
	return petName;
}


public void setPetName(String petName) {
	this.petName = petName;
}


public int getPetAge() {
	return petAge;
}


public void setPetAge(int petAge) {
	this.petAge = petAge;
}


public String getPetPlace() {
	return petPlace;
}


public void setPetPlace(String petPlace) {
	this.petPlace = petPlace;
}


public User getUser() {
	return user;
}


public void setUser(User user) {
	this.user = user;
}

@Override
public String toString() {
	return "Pet [petId=" + petId + ", petName=" + petName + ", petAge=" + petAge + ", petPlace=" + petPlace + ", user=" + user + "]";
}




}
