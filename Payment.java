package com.niit.onlineshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Payment {

	@RequestMapping("/pay")
	public String pay()
	{
		return "paynow";
	}
}
