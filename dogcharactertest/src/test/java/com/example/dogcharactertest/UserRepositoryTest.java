package com.example.dogcharactertest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.dogcharactertest.domain.User;
import com.example.dogcharactertest.domain.UserRepository;




@ExtendWith(SpringExtension.class)
@DataJpaTest
public class UserRepositoryTest {
	
	@Autowired
	private UserRepository repository;
	
	@Test
	public void findByNameShouldReturnPassword() {
		User user = repository.findByUsername("user");		
				
		assertThat(user.getPasswordHash()).isEqualTo("$2a$10$aeYF.z4171UTtrGFvh/9aOOkk0VPj8Sq0CFRYzMSpuMTyBX8SfRnm");
	}
	
	@Test
	public void createNewUser() {
		User user = new User("user1", "$2a$10$qGJLKfFs5HLODYuRZ.UZkePImE5E7V2f0lM.tL7iVopA2UIYbk4w6", "USER1");
    	repository.save(user);
    	assertThat(user.getId()).isNotNull();
	}
	
	@Test
	public void deleteNewUser() {
		User user = repository.findByUsername("user");
		repository.delete(user);
		
		User newUser = repository.findByUsername("user");
		assertThat(newUser).isNull();
 }
	

}
