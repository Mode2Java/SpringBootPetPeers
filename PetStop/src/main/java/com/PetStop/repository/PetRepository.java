package com.PetStop.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.PetStop.model.Pet;

@Repository
public interface PetRepository extends PagingAndSortingRepository<Pet, Integer>, CrudRepository<Pet,Integer> {

	//List<Pet> findAllById(int ownerId);
	//List<Pet> findAllById(int id, Pageable pageable);
	//public void save();
	
	//List<Pet> getAllPets();
	//List<Pet> findAllById(Integer ownerId);
	//Optional<Pet> findById(Integer petid);
	
	
	
	//List<Pet> findAll();
	//Page<Pet> findAll(Pageable pagable);

	}
