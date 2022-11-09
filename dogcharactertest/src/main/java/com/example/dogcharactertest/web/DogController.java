package com.example.dogcharactertest.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.dogcharactertest.domain.Dog;
import com.example.dogcharactertest.domain.DogRepository;



@Controller
public class DogController {
	@Autowired
	private DogRepository repository;
	
	@RequestMapping(value="/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/explanation")
	public String explanation() {
		return "explanation";
	}
		
	@GetMapping("/testresults")
	public String testresults(Model model) {
		model.addAttribute("results", repository.findAll());
		return "results";
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
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
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/delete/{id}")
	public String deleteDog(@PathVariable("id") long id, Model model) {
	repository.deleteById(id);
	return "redirect:../testresults";
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/editdog/{id}")
	public String edit(@PathVariable("id") long id, Model model){
		model.addAttribute("dog", repository.findById(id));
		return "editdog";
	}
	
}