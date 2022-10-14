package com.knimbus.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.knimbus.dao.UserMapper;
//import com.knimbus.dao.UserMapper;
import com.knimbus.model.User;
import com.knimbus.service.IUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@Api(tags = "This is user controller")
public class UserController {
	
	@Autowired
	private IUserService userService;

	@Autowired
	UserMapper userMapper;

	private static final String USER = "User";
	private static final String USERlIST = "ListUser";

	@ApiOperation(value = "Get User list")
	@RequestMapping(value = "/listOfUser", method = RequestMethod.GET)
	public ResponseEntity<?> showListOfUser() {
		System.out.println("Inside user List");
		List<User> userList = userService.getAllUser();
		return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
	}	

	@ApiOperation(value = "Saves user details in Database")
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public ResponseEntity<?> createUser(
			@ApiParam(value = "Please enter the user details to be saved", required = true) @RequestBody User user) {
		System.out.println("Inside createuser");
		userService.createUser(user);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@ApiOperation(value = "Login User")
	@RequestMapping(value = "/loginuser", method = RequestMethod.POST)
	public ResponseEntity<?> loginUser(
			@ApiParam(value = "Please enter the user details to be saved", required = true) @RequestBody User user) {
		System.out.println("........Inside loginuser...........");
		String roleName = userService.loginUser(user);
		System.out.println("RoleName:" + roleName);

		
//		String roleId = userMapper.loginUser(user);
//		System.out.println("RoleId:" + roleId);

		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("role", roleName);

		return new ResponseEntity<HashMap>(map, HttpStatus.OK);
	}
	
	@ApiOperation(value = "check Password")
	@RequestMapping(value = "/defaultPassword", method = RequestMethod.POST)
	public ResponseEntity<?> checkPassword(
			@ApiParam(value = "Please enter the user details to be check", required = true) @RequestBody User user) {
		System.out.println("---------Inside check checkPassword-----------");
		HashMap<String , Object> map = userService.isDefaultPassword(user);
		System.out.println("isDefaultPwd:" + map.get("isDefaultPwd"));

		return new ResponseEntity<HashMap>(map, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Update User")
	@RequestMapping(value = "/updateuser", method = RequestMethod.PUT)
	public ResponseEntity<?> updateUser(
			@ApiParam(value = "Please enter the user details to be update", required = true) @RequestBody User user) {
		System.out.println("Inside updateuser");
		User UpdateUser = userService.updateUser(user);
		return new ResponseEntity<User>(UpdateUser, HttpStatus.OK);
	}
	

//	@ApiOperation(value = "Update User")
//	@RequestMapping(value = "/userService", method = RequestMethod.PUT)
//	public ResponseEntity<?> updateUser(
//			@ApiParam(value = "Please enter the user details to be update" , requried = true) @RequestBody User user){
//		System.out.println("Inside update user");
//		User UpdateUser = userMapper.updateUser(user);
//		return new ResponseEntity<Ueer>(UpdateUser, HttpStatus.OK);
//	}
	
		
	@ApiOperation(value = "Get user details")
	@RequestMapping(value = "/getuser/{userId}", method = RequestMethod.GET)
	public ResponseEntity<?> getUser(
			@ApiParam(value = "Please enter the userid to get user information", required = true) @PathVariable("userId") int userId) {
		System.out.println("Inside getUser");
		User user = userService.getUser(userId);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	
	@ApiOperation(value = "Get user details using email ID")
	@RequestMapping(value = "/getuserinfobyemail", method = RequestMethod.GET)
	public ResponseEntity<User> getUserByEmailId(
		//	@ApiParam(value = "please enter the emailId to get user information", required = true) @PathVariable("email") String email){
			@ApiParam(value = "please enter the emailId to get user information", required = true) @RequestParam("email") String email){
	System.out.println(" ----Inside getUserByEmailId---- ");

		System.out.println("EmailId : " +email);
          // return  "EmailId : " +email;  
		User user = userService.getUserByEmailId(email);

		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	

	@ApiOperation(value = "Delete User")
	@RequestMapping(value = "/deleteuser/{userId}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteuser(
			@ApiParam(value = "Please enter the user id which to be delete", required = true) @PathVariable("userId") int userId ) {
		System.out.println("------------Inside deleteuser--------------");
		userService.deleteUser(userId);
		return new ResponseEntity<User>( HttpStatus.OK);
	}
	
	
	@ApiOperation(value = "reset Password of User")
	@RequestMapping(value = "/resetPassword", method = RequestMethod.PUT)
	public ResponseEntity<?> resetPassword(
			@ApiParam(value = "Please enter the password to be reset", required = true) @RequestBody User user) {
		System.out.println("---------Inside resetPassword-----------");
		String resetPassword = userService.resetPassword(user);
		return new ResponseEntity<User>(HttpStatus.OK);
	}
	
	
}
