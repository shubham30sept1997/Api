package neebal.com.repository;

import org.springframework.data.repository.CrudRepository;

import neebal.com.entity.User;


public interface RegisterRepo extends CrudRepository<User,Integer> {

		//generic type class can perform the operation on any type of object,Database table
		//create
		//read
		//update
		//delete

	 Boolean existsByEmail(String email);
	}


