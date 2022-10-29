package com.example.dogcharactertest.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.dogcharactertest.domain.DogRepository;

@Controller
public class DogController {
	@Autowired
	private DogRepository repository; 
	
	@GetMapping("/testresults")
	public String testresults(Model model) {
		model.addAttribute("results", repository.findAll());
		return "results";
	}
}
