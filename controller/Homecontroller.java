package com.niit.onlineshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.onlineshop.DAO.UserDAO;
import com.niit.onlineshop.model.User;

@Controller
public class Homecontroller {
	
	@Autowired
	private User user;
	
	@Autowired
	private UserDAO userDAO;
	
	
	
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
	public ModelAndView loginpage()
	{
		ModelAndView mv = new ModelAndView("login");
		return mv;
		
	}
	@RequestMapping("/register")
	public String register(Model model)
	{
		model.addAttribute("userClickedregister", true);
		return "register";
	}
	@ModelAttribute("user")
	public User f1()
	{
		System.out.println("creating user object");
		return new User();
	}
	 @RequestMapping(value = "/useradd",method=RequestMethod.POST)
	    public String userManagement( @ModelAttribute("user") User user, Model model) 
	    {
		 System.out.println("saving user");
		 user.setRole("ROLE_USER");
	    	userDAO.save(user);
	    	return "login";
	    }
	
	 @RequestMapping(value = "/loginUser")
	    public String login(@RequestParam(value="error", required = false) String error, @RequestParam(value="logout",
	            required = false) String logout, Model model) {
	        if (error!=null) {
	        	System.out.println("Error.....");
	            model.addAttribute("error", "...Invalid username and password");
	        }
	        	
	        if(logout!=null) {
	        	System.out.println("Logout called.....");
	            model.addAttribute("msg", "...You have been logged out");
	        }

	        return "login";
	 }
	   @RequestMapping(value = "/admin")
	    public String adminManagement() 
	    {
	    	System.out.println("ADMIN CALLED.......");
	    	return "admin";
	    }
	   @RequestMapping(value="/user")
	   public String fu()
	   {
		   return "index";
	   }
	/*@RequestMapping("/login")
		public String login(Model model)
		{
			model.addAttribute("userClcikedlogin", true);
		return "login";
		}*/
		
		
		/*@RequestMapping("/validate")
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

		
		}*/
	   }