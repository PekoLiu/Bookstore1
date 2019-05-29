package dao.impl;

import java.util.List;

import dao.BaseDao;
import dao.UserDao;
import entity.User;

public class UserDaoImpl extends BaseDao implements UserDao {

	@Override
	public int insert(User user) {
		String sql = "insert into user(username,password) values(?,?)";
		return executeUpdate(sql, user.getUsername(),user.getPassword());
	}
	
	@Override
	public User queryOne(User user) {
		String sql = "select * from user where username = ? and password = ?";
		List<User> lists = executeQuery(sql, User.class, user.getUsername(),user.getPassword());
		if(!lists.isEmpty()) {
			return lists.get(0);
		}
		return null;
	}

}
