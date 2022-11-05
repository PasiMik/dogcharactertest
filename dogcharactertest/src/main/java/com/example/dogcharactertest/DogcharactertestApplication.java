package com.example.dogcharactertest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.dogcharactertest.domain.Dog;
import com.example.dogcharactertest.domain.DogRepository;
import com.example.dogcharactertest.domain.User;
import com.example.dogcharactertest.domain.UserRepository;


@SpringBootApplication
public class DogcharactertestApplication {

	public static void main(String[] args) {
		SpringApplication.run(DogcharactertestApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner dog(DogRepository repository, UserRepository urepository) {
		return (args) -> {
			
			repository.save(new Dog("25.10.2022","Australian shepherd"," Frost Lake's Future","FI12345/22","+2","+2","-1","+1","+1","+1","+1","+3","+++",142));
			
			User user1 = new User("user", "$2a$10$aeYF.z4171UTtrGFvh/9aOOkk0VPj8Sq0CFRYzMSpuMTyBX8SfRnm", "USER");
			User user2 = new User("admin", "$2a$10$GQOA2HC5rJ0HjARfGcqZUufFdluGJ4sSOR6Z6eC2swOlN47I74nGW", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
		};
		
	}
}
