package com.stock.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stock.dao.User;

@Service
@Transactional
public class UserServiceImplementation implements UserService {

	private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

	 
	@Autowired
	com.stock.registration.UserDao userDao;

	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public User  findByUsername(String user_id) {
		 
		System.out.println("++++++++++++   findByUsername returns   "+userDao.findByUsername(user_id));
	
		return userDao.findByUsername(user_id);
	}

	@Override
	public User findByEmail(String email) {
		
		System.out.println("++++++++++++   findByEmail returns   "+userDao.findByEmail(email));

		return userDao.findByEmail(email);
	}

	@Override
	public boolean checkUserExists(String user_id, String email) {
		
	 	
		if( checkUserIdExists(user_id) || checkEmailExists(email)  ) {
			
		 
			return true;
		}else {
			return false;
		}
		
	}

	@Override
	public boolean checkUserIdExists(String user_id) {
 		if( findByUsername(user_id) !=null) {
			return true;
		}else {
			return false;
	
		}
	}
	

	@Override
	public boolean checkEmailExists(String email) {
		System.out.println("*******************   checkEmailExists(String email) {              00000000000000000000000000000000");
		
		if(findByEmail(email) !=null) {
			return true;
		}else {
			return false;
		}
	}
	
	@Transactional
	  public User createUser(User user) {
	        User localUser = userDao.findByUsername(user.getUsername());

	        if (localUser != null) {
	        	  LOG.info("User with username {} already exist. Nothing will be done. ", user.getUsername());
	        } else {
	          String encryptedPassword = passwordEncoder.encode(user.getPassword());
	           user.setPassword(encryptedPassword);

	           

	        

	         System.out.println(user.getPassword());
	            localUser = userDao.save(user);
	        }

	        return localUser;
	    }
	
	
	
	
	

	@Override
	public User saveUser(User user) {
  
		return  userDao.save(user);
	}

	@Override
	public void save(User user) {
		
			userDao.save(user);
	}

}
