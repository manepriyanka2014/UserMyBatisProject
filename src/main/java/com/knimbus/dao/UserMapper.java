package com.knimbus.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.knimbus.model.UserRole;
import com.knimbus.model.User;
import com.knimbus.config.MyBatisSqlSessionConfiguration;
//import com.knimbus.config.MyBatisSqlSessionFactory;

@Repository
public class UserMapper {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	@Qualifier("session")
	@Lazy
	private SqlSession session;

	public void createUser(User user) {
		System.out.println("-----------------------Inside createUser-----------------");

		// session = MyBatisSqlSessionConfiguration.getSqlSession();
		session.insert("createUser", user);
		session.commit();
		
	}

	public User updateUser(User user) {
		// session = MyBatisSqlSessionConfiguration.getSqlSession();
		session.update("com.knimbus.dao.UserMapper.updateUser", user);
		User updatedUser = (User) session.selectOne("userMapper.getById", user.getUserId());
		session.commit();
		return updatedUser;
	}

	public User getUser(int userId) {
		// session = MyBatisSqlSessionConfiguration.getSqlSession();

		User user = (User) session.selectOne("userMapper.getById", userId);
//	session.commit();
//		session.close();

		return user;
	}

	public User getUserByEmailId(String email) {
		// session = MyBatisSqlSessionConfiguration.getSqlSession();
		User user = (User) session.selectOne("userMapper.getUserByEmailId", email);
//		session.commit();
//		session.close();
		return user;
	}

	public void deleteUser(int userId) {
		// session = MyBatisSqlSessionConfiguration.getSqlSession();
		session.delete("deleteUser", userId);
		session.commit();
//		session.close();
	}

	public List<User> getAllUser() {
		// session = MyBatisSqlSessionConfiguration.getSqlSession();
		System.out.println("-----------------------Inside All user list-----------------");
		@SuppressWarnings("unchecked")
		List<User> userList = session.selectList("getAllUser");
		session.commit();
//		session.close();
		return userList;
	}

	public String loginUser(User user) {
		System.out.println("after encoding :"+user.getEmail()+"--"+ user.getPassword() );
		String roleName = "";
		System.out.println("-----------------------Inside loginUser-----------------");
		// session = MyBatisSqlSessionConfiguration.getSqlSession();
		User user1 = (User) session.selectOne("com.knimbus.dao.UserMapper.validateUserCredential", user);
		System.out.println(user1.toString());
		System.out.println("Existing user password: "+ user1.getPassword());
		if(user1 != null)
		{
			if (passwordEncoder.matches(user.getPassword(), user1.getPassword())) {
				System.out.println(user1.toString());
				System.out.println(user1.getUserId());
				UserRole role = (UserRole) session.selectOne("validateUserRole", user1.getUserId());
				if (role != null) {
					System.out.println("Role information :" + role.toString());
					roleName = role.getRoleName();
				}
			}
		}
		else
		{
			System.out.println("User does not exist");
		}
		
		session.commit();
		return roleName;
	}
	
	public User resetPassword(User user) {
		// session = MyBatisSqlSessionConfiguration.getSqlSession();
		session.update("com.knimbus.dao.UserMapper.resetPassword", user);
		//User userWithUpdatedPwd = (User) session.selectOne("userMapper.getById", user.getUserId());
		session.commit();
		return user;
	}

	public HashMap<String , Object> isDefaultPassword(User user) 
	{
		boolean isDefaultPwd  = false;
		User existingUser = (User) session.selectOne("com.knimbus.dao.UserMapper.validateUserCredential", user);
		
		if (passwordEncoder.matches(User.defaultPassword, existingUser.getPassword())) 
		{
			isDefaultPwd = true;
		}
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("user", user);
		map.put("isDefaultPwd", isDefaultPwd);		
		return map;	
	}
}