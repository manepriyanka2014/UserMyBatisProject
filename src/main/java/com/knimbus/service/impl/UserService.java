package com.knimbus.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.knimbus.dao.UserMapper;
import com.knimbus.model.User;
import com.knimbus.model.UserRole;
import com.knimbus.service.IUserService;

//import com.knimbus.util.config.MyBatisSqlSessionFactory;
@Service
public class UserService implements IUserService {
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserMapper userMapper;
//	public static final String password = "test123!";

	public void createUser(User user) {
		System.out.println("-----------------------Inside createUser-----------------");
		String encodedPassword = passwordEncoder.encode(User.defaultPassword);

		user.setPassword(encodedPassword);

		userMapper.createUser(user);

	}

	public User updateUser(User user) {
		System.out.println("Input user:" + user.toString());
		if (Objects.nonNull(user.getPassword()) && !"".equalsIgnoreCase(user.getPassword())) {
			String encodedPassword = passwordEncoder.encode(user.getPassword());
			user.setPassword(encodedPassword);
		}
		User updatedUser = userMapper.updateUser(user);
		System.out.println("Details of the user after update operation");
		System.out.println(updatedUser.toString());

		return updatedUser;
	}

	public HashMap<String, Object> isDefaultPassword(User user) {
		HashMap<String, Object> map = userMapper.isDefaultPassword(user);
		return map;
	}

	public User getUser(int userId) {
		User user = userMapper.getUser(userId);
		System.out.println("Details of the user :");
		System.out.println(user.toString());
		return user;
	}

	public User getUserByEmailId(String email) {
		System.out.println("Email:" + email);
		User user = userMapper.getUserByEmailId(email);
		System.out.println("Details of the user :");
		if (user != null) {
			System.out.println(user.toString());
		} else {
			System.out.println("User Does not exist");
		}

		return user;
	}

	public void deleteUser(int userId) {
		userMapper.deleteUser(userId);
	}

	public List<User> getAllUser() {
		System.out.println("-----------------------Inside All user list-----------------");
		List<User> userList = userMapper.getAllUser();
		System.out.println("User Count" + userList.size());
		return userList;
	}

	public String loginUser(User user) {

		String roleName = "";
			System.out.println(user.getEmail());
			System.out.println("-----------------------Inside loginUser-----------------");
			roleName = userMapper.loginUser(user);
		
		return roleName;
	}

	public String resetPassword(User user) {
		System.out.println("Input user:" + user.toString());
		if (Objects.nonNull(user.getPassword()) && !"".equalsIgnoreCase(user.getPassword())) {
			String encodedPassword = passwordEncoder.encode(user.getPassword());
			user.setPassword(encodedPassword);
		}
		User userWithUpdatedPwd = userMapper.resetPassword(user);
		System.out.println("after set new password");
		System.out.println(userWithUpdatedPwd.getPassword());
		return userWithUpdatedPwd.getPassword();
	}

}
