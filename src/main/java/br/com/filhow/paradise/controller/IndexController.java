package br.com.filhow.paradise.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("/greeting")
	public void greeting(Model model) {
		model.addAttribute("name", "Marcos");
	}
}
