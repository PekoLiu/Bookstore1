package service;

import entity.User;

public interface UserService {

    int register(User user);
	
	User login(User user);
	
}
