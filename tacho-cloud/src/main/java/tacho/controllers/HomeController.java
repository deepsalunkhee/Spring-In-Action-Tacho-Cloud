package tacho.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


//note here I am not doing Rest Mapping
@Controller
public class HomeController {
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
}
