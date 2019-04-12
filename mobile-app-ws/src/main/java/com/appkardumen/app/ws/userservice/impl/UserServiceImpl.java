package com.appkardumen.app.ws.userservice.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appkardumen.app.ws.shared.Utils;
import com.appkardumen.app.ws.ui.model.response.UserRest;
import com.appkardumen.app.ws.ui.model.resquest.UserDetailsRequestModel;
import com.appkardumen.app.ws.userservice.UserService;

@Service
public class UserServiceImpl implements UserService{

	Map<String,UserRest > users;
	
	Utils utils;
	
	public UserServiceImpl(){
		
	}
	
	@Autowired
	public UserServiceImpl(Utils utils) {
		this.utils = utils;
	}
	@Override
	public UserRest createUser(UserDetailsRequestModel userDetails) {
		UserRest returnValue = new UserRest();
		returnValue.setEmail(userDetails.getEmail());
		returnValue.setFirtsName(userDetails.getFirstName());
		returnValue.setLastName(userDetails.getLastName());
		
		String userId = UUID.randomUUID().toString();
		returnValue.setUserId(userId);
		if(users == null) users= new HashMap<>();
		users.put(userId, returnValue);
		
		return returnValue;
	}

}
