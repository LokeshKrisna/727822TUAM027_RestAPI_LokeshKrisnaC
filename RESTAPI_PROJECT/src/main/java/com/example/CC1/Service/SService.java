package com.example.CC1.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.CC1.Model.Model;
import com.example.CC1.Repository.Repository;

@Service
public class SService {
	@Autowired
	private Repository repository;

	public Model createNewUser(@NonNull Model user) {
		return repository.save(user);
	}

	public List<Model> getAllUserDetais() {
		return repository.findAll();
	}

	public Model updateUserDetails(@NonNull String email, @RequestBody Model User) {
		return repository.findByEmail(email).map(existingUser -> {
			existingUser.setEmail(User.getEmail());
			existingUser.setPassword(User.getPassword());
			return repository.save(existingUser);
		}).orElseThrow(() -> new RuntimeException("User not found with this username " + email));
	}
	
	public void RemoveUser(@NonNull Integer id) {
		repository.deleteById(id);
	}

}
