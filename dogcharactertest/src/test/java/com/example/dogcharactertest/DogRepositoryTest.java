package com.example.dogcharactertest;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.dogcharactertest.domain.Dog;
import com.example.dogcharactertest.domain.DogRepository;




@ExtendWith(SpringExtension.class)
@DataJpaTest
public class DogRepositoryTest {
	
	@Autowired
	private DogRepository repository;
	
	@Test
	public void FindByRegNumberShouldReturnDog() {
		List<Dog> dogs = repository.findByRegNumber("FI12345/22");
		
		assertThat(dogs).hasSize(1);
		assertThat(dogs.get(0).getDogName()).isEqualTo("Frost Lake's Future");
	}
	
	@Test
	public void createNewDog() {
		
		Date newDate = new Date();	

		
		Dog dog = new Dog(newDate,"Australian shepherd","Frost Lake's Past","FI45645/22","+2","+2","-1","+1","+1","+1","+1","+3","+++",156);
    	repository.save(dog);
    	assertThat(dog.getId()).isNotNull();
	}
	
	 @Test
	    public void deleteNewDog() {
			List<Dog> dogs = repository.findByRegNumber("FI12345/22");
			Dog dog = dogs.get(0);
			repository.delete(dog);
			List<Dog> newDogs = repository.findByRegNumber("FI12345/22");
			assertThat(newDogs).hasSize(0);
	 }

	

}
