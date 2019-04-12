package com.appkardumen.app.ws.userservice;

import com.appkardumen.app.ws.ui.model.response.UserRest;
import com.appkardumen.app.ws.ui.model.resquest.UserDetailsRequestModel;

public interface UserService {
	
	UserRest  createUser(UserDetailsRequestModel userDetails);

}
