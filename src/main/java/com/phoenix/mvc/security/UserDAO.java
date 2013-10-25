package com.phoenix.mvc.security;

import com.phoenix.mvc.db.entities.User;

public interface UserDAO {

	public User getUser(String emailAddress);
}
