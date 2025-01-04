package com.cg.onlineflatrental.repository;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.cg.onlineflatrental.entity.User;

public interface IUserRepository extends CrudRepository<User, Integer>{
	public Optional<User> findByUserName(String userName);
}