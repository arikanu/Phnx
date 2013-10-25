package com.phoenix.mvc.security;

import com.phoenix.mvc.db.entities.User;

public interface UserService {

	public User getUser(String emailAddress);
}
