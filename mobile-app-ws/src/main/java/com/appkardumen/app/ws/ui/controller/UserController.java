package com.appkardumen.app.ws.ui.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.appkardumen.app.ws.exception.UserServiceException;
import com.appkardumen.app.ws.ui.model.response.UserRest;
import com.appkardumen.app.ws.ui.model.resquest.UpdateUserDetailsRequestModel;
import com.appkardumen.app.ws.ui.model.resquest.UserDetailsRequestModel;
import com.appkardumen.app.ws.userservice.UserService;
import com.appkardumen.app.ws.userservice.impl.UserServiceImpl;

@RestController
@RequestMapping("users")
public class UserController {
	
	Map<String,UserRest > users;
	@Autowired
	UserService userSerice;
	
	
	
	@GetMapping
	public String getUsers(@RequestParam(value="page",defaultValue="1") int page, 
						   @RequestParam(value="limit",defaultValue="50") int limit,
						   @RequestParam(value="sort",required = false) String sort) {
		return "Limit for page " + page +  "    limit   "+ limit;
	}
	
	
	@GetMapping(path="/{userId}",produces= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<UserRest> getUser(@PathVariable String userId) {
			
		if(true)throw new  UserServiceException("A user service  exception is thrown");
		
		if(users.containsKey(userId)) {
			return  new ResponseEntity<UserRest>(users.get(userId),HttpStatus.OK);
		}else {
			return  new ResponseEntity<UserRest>(HttpStatus.NO_CONTENT);
		}
	}
	
	@PostMapping(consumes= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE},
				produces= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<UserRest>  createUser(@Valid @RequestBody UserDetailsRequestModel userDetails) {
			
 
		
		UserRest returnValue = userSerice.createUser(userDetails);
		return new ResponseEntity<UserRest> (returnValue,HttpStatus.OK );
	}
	
	
	@PutMapping(path="{userId}",consumes= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE},
	produces= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public UserRest updateUser(@PathVariable String userId, @Valid @RequestBody UpdateUserDetailsRequestModel userDetails ) {
		
		UserRest storedUserDetails = users.get(userId);
		storedUserDetails.setFirtsName(userDetails.getFirstName());
		storedUserDetails.setLastName(userDetails.getLastName());
		
		users.put(userId, storedUserDetails);
		
		return storedUserDetails;
	}
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable String id ) {
		users.remove(id);
		
		return ResponseEntity.noContent().build();
	}

}
