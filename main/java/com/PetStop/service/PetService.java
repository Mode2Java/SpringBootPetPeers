package com.PetStop.service;

import java.util.List;

import com.PetStop.model.Pet;
import com.PetStop.model.User;


public interface PetService {
	public List<Pet> searchAllByPetNameOrPetAgeOrPetPlace(String petname,int petage,String petplace);
	public void savePet(Pet pet);
	List<Pet> searchAllByUser(User user);
	//public List<Pet> searchAllByOwnerId(int ownerid);
	//public List<Pet> searchAllByUser(int ownerid);
	List<Pet> searchAll();
}
