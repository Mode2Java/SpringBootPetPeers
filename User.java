package com.projectpet.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component
@Entity
@Table(name="pet_user")
@Scope("session")
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="id_seq")
	@SequenceGenerator(name="id_seq",initialValue=100,allocationSize=1)
	private int id;
	@Column(name="user_name",unique=true)
	private String username;
	@Column(name="user_passwd")
	private String password;
	@Transient
	private String confirmPassword;
	//List <Pet> pet;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int id, String username, String password, String confirmpassword) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.confirmPassword = confirmpassword;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmpassword) {
		this.confirmPassword = confirmpassword;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", confirmpassword="
				+ confirmPassword + "]";
	}
		
}
