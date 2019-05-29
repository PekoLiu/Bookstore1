package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import entity.User;
import service.UserService;

public class UserServiceImpl implements UserService {
	
	UserDao dao = new UserDaoImpl();
	
	@Override
	public int register(User user) {
		return dao.insert(user);
	}

	@Override
	public User login(User user) {
		return dao.queryOne(user);
	}

}
