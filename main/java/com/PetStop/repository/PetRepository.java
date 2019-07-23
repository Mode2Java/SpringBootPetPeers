package com.PetStop.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.PetStop.model.Pet;
import com.PetStop.model.User;

@Repository
public interface PetRepository extends PagingAndSortingRepository<Pet, Integer>,JpaRepository<Pet,Integer> {

	
	
	public List<Pet> findAllByPetNameOrPetAgeOrPetPlace(String petname,int petage,String petplace);
	//public List<Pet> findAllByOwnerId(int ownerid);
	//public void save(pet);
	//List<Pet> findAll();
	//Page<Pet> findAll(Pageable pagable);
	public List<Pet> findAllByUser(User user);
	
	/*@Query(name="select * from pets where ownerid=:ownerid", nativeQuery=true)
	public List<Pet> findAllByUser(@Param("ownerid") int ownerid);
	}*/
}