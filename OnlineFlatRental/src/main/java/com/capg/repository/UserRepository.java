package com.capg.repository;


import org.springframework.data.repository.CrudRepository;

import com.capg.entity.User;


public interface UserRepository extends CrudRepository<User, Integer>{
	
}
	

