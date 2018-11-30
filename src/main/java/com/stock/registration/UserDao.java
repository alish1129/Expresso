package com.stock.registration;

 
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.stock.dao.User;

@Component("userDao")
public interface UserDao extends CrudRepository<User, String> {

	User findByUsername(String id);
	User findByEmail(String email);
}
