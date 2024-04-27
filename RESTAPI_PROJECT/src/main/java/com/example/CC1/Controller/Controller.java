package com.example.CC1.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CC1.Model.Model;
import com.example.CC1.Service.SService;

@RestController
@RequestMapping("/login")
public class Controller {
	@Autowired
	SService services;
	@PostMapping("/createUserID")
	public ResponseEntity<Model> createNewUser(@NonNull @RequestBody Model user){
		Model created_user=services.createNewUser(user);
		return new ResponseEntity<>(created_user,HttpStatus.CREATED);
	}
	
	@GetMapping("/readUser")
	public ResponseEntity<List<Model>> getAllUserDetails(){
		List<Model> allDetails=services.getAllUserDetais();
		return new ResponseEntity<>(allDetails, HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/update/{email}")
	public ResponseEntity<Model> updateUser(@NonNull @PathVariable String email,@RequestBody Model user){
		Model updatedDetailsModel=services.updateUserDetails(email, user);
		return new ResponseEntity<>(updatedDetailsModel,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteUser(@NonNull @PathVariable Integer id) {
		services.RemoveUser(id);
	}
}