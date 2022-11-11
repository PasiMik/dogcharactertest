package com.example.dogcharactertest.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.dogcharactertest.domain.SignUpForm;
import com.example.dogcharactertest.domain.User;
import com.example.dogcharactertest.domain.UserRepository;



@Controller
public class UserController {
	@Autowired
	private UserRepository repository;
	
	 @RequestMapping(value = "signup")// creating a new user  
	    public String addUser(Model model){
	    	model.addAttribute("signupform", new SignUpForm());
	        return "signup";
	    }	
	 
	 @RequestMapping(value = "saveuser", method = RequestMethod.POST)//saving user if the user doesn't already exist
	    public String save(@Valid @ModelAttribute("signupform") SignUpForm signUpForm, BindingResult bindingResult) {
	    	if (!bindingResult.hasErrors()) { 
	    		if (signUpForm.getPassword().equals(signUpForm.getPasswordCheck())) { 		
		    		String pwd = signUpForm.getPassword();
			    	BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
			    	String hashPwd = bc.encode(pwd);
		
			    	User newUser = new User();
			    	newUser.setPasswordHash(hashPwd);
			    	newUser.setUsername(signUpForm.getUsername());
			    	newUser.setRole("USER");
			    	if (repository.findByUsername(signUpForm.getUsername()) == null) {
			    		repository.save(newUser);
			    	}
			    	else {
		    			bindingResult.rejectValue("username", "err.username", "Username already exists");    	
		    			return "signup";		    		
			    	}
	    		}
	    		else {
	    			bindingResult.rejectValue("passwordCheck", "err.passCheck", "Passwords does not match");    	
	    			return "signup";
	    		}
	    	}
	    	else {
	    		return "signup";
	    	}
	    	return "redirect:/login";    	
	    }  	    

}
