package com.knimbus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping("/")
	public String home()
	{
		return "index";
	}
	@RequestMapping("/addUser")
	public String addUser()
	{
		return "add-user";
	}
	
	@RequestMapping("/dashboardUser")
	public String dashboardUser()
	{
		return "dashboard-user";
	}
	
	@RequestMapping("/editUser")
	public String editUser()
	{
		return "edit-user";
	}
	
	@RequestMapping("/login")
	public String login()
	{
		return "login";
	}
	@RequestMapping("/resetPassword")
	public String resetPassword()
	{
		return "reset-password";
	}
	@RequestMapping("/updateUser")
	public String updateUser()
	{
		return "update-user";
	}
	@RequestMapping("/userInfo")
	public String userInfo()
	{
		return "user-info";
	}
}