package pe.edu.upc.market.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// Method: GET y POST
@Controller
@RequestMapping("/")
public class IndexController {
	
	@GetMapping
	public String index(Model model) {
		model.addAttribute("nombre", "Juan Flores");
		return "inicio";
	}
	
	@GetMapping("help")
	public String help() {
		return "help";
	}
	
	
}
