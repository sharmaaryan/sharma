package com.niit.onlineshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Homecontroller {
	@RequestMapping("/")
	public String gothome()
	{
		return "index";

	}
	@RequestMapping("/home")
	public String gothome1()
	{
		return "index";

	}
	@RequestMapping("/login")
		public String login(Model model)
		{
			model.addAttribute("userClcikedlogin", true);
		return "login";
		}
		@RequestMapping("/register")
		public String register(Model model)
		{
			model.addAttribute("userClickedregister", true);
			return "register";
		}
		
		@RequestMapping("/validate")
		public String validate(@RequestParam(name="userID")String id,
				@RequestParam(name="password")String pwd,
				Model model)
		{
		if(id.equals("niit") && pwd.equals("niit"))	
		{
			model.addAttribute("successmessage","you successfull logged in");
	
		}
			else
			{
				model.addAttribute("errormessage", "invalid details...please try again");
			
			}
				return"index";

		
		}}