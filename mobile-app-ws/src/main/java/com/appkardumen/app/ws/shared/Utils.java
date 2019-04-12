package com.appkardumen.app.ws.shared;

import java.util.UUID;

public class Utils {
	public String generateUserId() {
		return UUID.randomUUID().toString();
	}

}
