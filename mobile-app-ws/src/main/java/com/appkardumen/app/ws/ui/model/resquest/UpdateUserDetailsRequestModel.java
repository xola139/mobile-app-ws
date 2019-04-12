package com.appkardumen.app.ws.ui.model.resquest;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UpdateUserDetailsRequestModel {
	@NotNull(message="firstName cannot be null")
	@Size(min=2,message="Firts name must not be  less than  2 characters")
	private String firstName;
	
	@NotNull(message="lastName cannot be null")
	@Size(min=2,message="Last name must not be  less than  2 characters")
	private String lastName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
