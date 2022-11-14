package com.example.dogcharactertest;

import java.text.SimpleDateFormat;
import java.util.Date;

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
			
			Date newDate = new Date();
			
			String testDateString = "25.10.2022";
			Date testDate = new SimpleDateFormat("dd.MM.yyyy").parse(testDateString);
			
			
			repository.save(new Dog(testDate,"Australian shepherd","Frost Lake's Future","FI12345/22","+2","+2","-1","+1","+1","+1","+1","+3","+++",142));
			repository.save(new Dog(newDate,"Australian shepherd","Frost Lake's Past","FI45645/22","+1","+1","-1","+2","+2","+1","+1","+3","+++",146));
			
			User user1 = new User("user", "$2a$10$KWLQQNo/wwLYRik.MUUoI.g3u7yYJtWRHjAIGi.yDMWIfmgcEjiSq", "USER");
			User user2 = new User("admin", "$2a$10$Ks30pQaR1A9QS/4mytTSAuLZA0NHQ2iKkHPUYlxEeaArFtTo.0g52", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
		};
		
	}
}
