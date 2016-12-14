 package com.niit.onlineshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.onlineshop.DAO.CategoryDAO;
import com.niit.onlineshop.model.Category;

@Controller
public class CategoryController {
	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
private Category category;
	
	@RequestMapping(value="/category",method=RequestMethod.GET)
	public String listCategories(Model model)
	{
		//log.debug("starting of list categories");
		model.addAttribute("category", new Category());
		model.addAttribute("categorylist",categoryDAO.list());
		model.addAttribute("isAdminClickedCategory","true");
		//log.debug("Endof listcategory");
		
		return "category";
	}
	
	@RequestMapping(value="/manage_category_add",method=RequestMethod.POST)
	public String addcategory(@ModelAttribute("category")Category category,Model model)
	{
	//log.debug("start of add categy");
	//log.debug("id+category.getid");
	if (categoryDAO.save(category)==true)
	{
		model.addAttribute("msg","successfully created the category");
	}
	else
	{
		model.addAttribute("msg","not  created the table from category");
	}
	model.addAttribute("category",category);
	model.addAttribute("categorylist",categoryDAO.list());
	model.addAttribute("isAdminClickedCategory","true");
	//log.debug("End of addcategory");
	return "category";
	}

	@RequestMapping(value="/manage_category_edit/{id}")
	public String editCategory(@PathVariable("id") String id, Model model)
	{
		model.addAttribute("category",this.categoryDAO.get(id));
		model.addAttribute("categorylist",this.categoryDAO.list());
		
		
		return "category";
	}
	
	@RequestMapping(value="/manage_category_delete/{id}")
	public String deleteCategory(@PathVariable("id") String id, Model model)
	{
		categoryDAO.delete(id);
		
		//model.addAttribute("category",this.categoryDAO.delete(category)("id"));
		//model.addAttribute("categorylist",categoryDAO.list());
		
	
		return "redirect:/category";
	}
}