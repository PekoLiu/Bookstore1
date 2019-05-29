package dao;

import entity.User;

public interface UserDao {

	int insert(User user);
	
	User queryOne(User user);
	
}

