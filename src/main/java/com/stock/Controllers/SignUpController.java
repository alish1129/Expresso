package com.stock.Controllers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stock.dao.User;
import com.stock.service.StockService;
import com.stock.service.UserService;

@RestController
@RequestMapping("user")
public class SignUpController {
//	private HibernateOperator hibernateOperator;

 

	
	@Autowired
	@Qualifier("stockService")
	StockService stockService;
	
	@Autowired
	UserService userService;

	@GetMapping("/signUp")
	public String SignUp(Model  model) {
	

	//	UserImplements tempRegis = new UserImplements( );
	//	model.addAttribute("data",tempRegis);
		return "signUp";
		
	}

 
	
	@PostMapping("/authenticate")
	public String processForm(@RequestBody User user,
			 HttpServletRequest request,Model model, @Valid @ModelAttribute("data") User theuser,
			BindingResult theBindingResult) {
		
	 
		System.out.println(user.getFirst_name());
		System.out.println(user.getLast_name());
		//System.out.println(request.getParameter("username"));
		System.out.println(user.getUsername());
		System.out.println("<------------------------------------------------------" + user);
		System.out.println(user.getEmail());

		if(userService.checkUserExists(user.getUsername(),user.getEmail())){
			System.out.println(" >>>>>>>>>>>> if(userService.checkUserExists(theRegis.getUsername(),theRegis.getEmail())){");
			if(userService.checkUserIdExists(user.getUsername())){
				
				model.addAttribute("user_idExists",true);
				System.out.println("User_id already exist");
				return "Username already exist";
			}  if(userService.checkEmailExists(user.getEmail())) {
				model.addAttribute("emailExists",true);
				System.out.println("email already exist");
				return "Email already exist";
			}
			
			return "fail";
		}else {
			userService.createUser(user);
			return "success";

		}

	 
	 
	}
 
	
	
	
	
	
 
	}
	
	