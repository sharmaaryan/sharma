 package com.niit.onlineshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.onlineshop.DAO.CategoryDAO;
import com.niit.onlineshop.DAO.SupplierDAO;
import com.niit.onlineshop.model.Category;
import com.niit.onlineshop.model.Supplier;



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
		model.addAttribute("category",new Category());
		model.addAttribute("categorylist",categoryDAO.list());
		model.addAttribute("isAdminClickedcategory","true");
		//log.debug("Endof listsupplier");
		
		return "category";
	}
	
	
	@ModelAttribute("category")
	public Category s2()
	{
		System.out.println("Creating category object");
		return new Category();
	}
	
	@RequestMapping(value="/manage_category_add",method=RequestMethod.POST)
	public String addcategory(@ModelAttribute("category") Category category,Model model)
	{
		categoryDAO.save(category);
		
		
		
	//log.debug("start of add categy");
	//log.debug("id+supplier.getid");
		//System.out.println(category.getCategory_id());
		//categoryDAO.save(category);
	/*if (supplierDAO.save(supplier)==true)
	{
		model.addAttribute("msg","successfully created the supplier");
	}
	else
	{
		model.addAttribute("msg","not  created the table from supplier");
	}*/
	model.addAttribute("category",category);
	model.addAttribute("categorylist",categoryDAO.list());
	model.addAttribute("isAdminClickedcategory","true");
	//log.debug("End of addsupplier");
	return "category";
	}

	@RequestMapping(value="/manage_category_edit-{id}",method=RequestMethod.GET)
	public String editcategory(@PathVariable("id") String id, Model model)
	{
		System.out.println("editCtegory");
		//model.addAttributes("category", this.categoryDAO.get(id));
		model.addAttribute("category", this.categoryDAO.get(id));
		model.addAttribute("listCategory",this.categoryDAO.list());
		return "category";
		
		
		
		//category=categoryDAO.get(id);
		//System.out.println(category.getCategory_id());
		//model.addAttribute("category",this.categoryDAO.get(id));
		
		
		
		//return "category";
	}
	
	@RequestMapping(value="/manage_category_delete-{id}")
	public String deletecategory(@PathVariable("id") String id, Model model)
	{
		categoryDAO.delete(id);
		
		//model.addAttribute("supplier",this.supplierDAO.delete(supplier)("id"));
		//model.addAttribute("supplierlist",supplierDAO.list());
		
	
		return "redirect:/category";
	}
}










