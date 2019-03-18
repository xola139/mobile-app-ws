package com.appkardumen.app.ws.ui.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appkardumen.app.ws.ui.model.response.UserRest;
import com.appkardumen.app.ws.ui.model.resquest.UserDetailsRequestModel;

@RestController
@RequestMapping("users")
public class UserController {
	
	@GetMapping
	public String getUsers(@RequestParam(value="page",defaultValue="1") int page, 
						   @RequestParam(value="limit",defaultValue="50") int limit,
						   @RequestParam(value="sort",required = false) String sort) {
		return "Limit for page " + page +  "    limit   "+ limit;
	}
	
	
	@GetMapping(path="/{userId}",produces= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<UserRest> getUser(@PathVariable String userId) {
			
		UserRest returnValue = new UserRest();
		returnValue.setEmail("elxola139@gmail.com");
		returnValue.setFirtsName("Sergay");
		returnValue.setLastName("Rosas");
		returnValue.setUserId("xola19");
		
		return new ResponseEntity<UserRest>(HttpStatus.ACCEPTED);
	}
	
	@PostMapping(consumes= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE},
				produces= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<UserRest>  createUser(@RequestBody UserDetailsRequestModel userDetails) {
			
		UserRest returnValue = new UserRest();
		returnValue.setEmail(userDetails.getEmail());
		returnValue.setFirtsName(userDetails.getFirstName());
		returnValue.setLastName(userDetails.getLastName());
		
		
		
		return new ResponseEntity<UserRest> (returnValue,HttpStatus.OK);
	}
	
	@PutMapping
	public String updateUser() {
		
		return "udate user";
	}
	
	@DeleteMapping
	public String deleteUser() {
		return "delete user";
	}

}
