package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
/*@RequestMapping("/")*/
public class HomeController {
	
	@RequestMapping("/")
	public String home() {
		return "redirect:/index";
	}

	@RequestMapping("/index")
    public String index() {
        return "index";
    }
	@RequestMapping("shit")
	public String shit() {
		return "shit";
	}
	
	
}
