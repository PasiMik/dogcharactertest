package com.example.dogcharactertest.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.dogcharactertest.domain.Dog;
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
	
	@GetMapping("/add_dog")
	public String addDog(Model model){
		model.addAttribute("dog", new Dog());
		return "adddog";
	}
	
	@PostMapping("/save")
	public String save(Dog dog) {
		repository.save(dog);
		return "redirect:testresults";
	}
}	