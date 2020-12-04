package neebal.com.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import neebal.com.entity.Movie;
import neebal.com.entity.User;

	public interface LoginRepo extends CrudRepository<User,Integer>{
		//generic type class can perform the operation on any type of object,Database table
		//create
		//read
		//update
		//delete
		 Boolean existsByEmail(String email);
		 Boolean existsByPassword(String password);
		 public User findByemailLike(String email);
	
	}


