package com.stock.service;


import com.stock.dao.User;



public interface UserService {
	
	User findByUsername(String username);
	
	User findByEmail(String email);
	
	boolean checkUserExists(String user_id,String email);
	
	boolean checkUserIdExists(String user_id);
	
	boolean checkEmailExists (String email);
	
	void save(User user);
	
	User saveUser(User user);

	User createUser(User user);
	
}
