package com.example.dogcharactertest.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface DogRepository extends CrudRepository<Dog, Long> {
	List<Dog> findByRegNumber(String regNumber);
	
}
