package com.stock.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("stock")
public class HomeController {
	
	
	//For all the request that comes in the form 'stock/' redirects to /index to third method
	@RequestMapping("/")
	public String home() {
		return "redirect:/index";
	}
	
	//for all the request in the form  'stock/home' redirects to /index to third method
	@RequestMapping("/home")
	public String homeSecond() {
		return "redirect:/index";
	}
	
	// for all the request in the form 'stock/index  shows index html resources/templates/index
	@RequestMapping("index")
    public String index() {
        return "index";
    }
	
	
 
	
	
}
