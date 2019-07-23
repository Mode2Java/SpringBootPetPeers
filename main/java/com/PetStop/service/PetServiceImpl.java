package com.PetStop.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.PetStop.model.Pet;
import com.PetStop.model.User;
import com.PetStop.repository.PetRepository;

@Service
@SessionAttributes("sessionuser")
public class PetServiceImpl implements PetService {

	@Autowired
	PetRepository petRepository;
	
	
	@Override
	public void savePet(Pet pet) {
		petRepository.save(pet);		
	}

	

	

	@Override
	public List<Pet> searchAllByPetNameOrPetAgeOrPetPlace(String petname, int petage, String petplace) {
		// TODO Auto-generated method stub
		return petRepository.findAllByPetNameOrPetAgeOrPetPlace(petname, petage, petplace);
	}

	@Override
	public List<Pet> searchAll() {
		// TODO Auto-generated method stub
		return petRepository.findAll();
	}





	@Override
	public List<Pet> searchAllByUser(User user) {
		// TODO Auto-generated method stub
		return  petRepository.findAllByUser(user);
	}

	

	
	

	
	

}
