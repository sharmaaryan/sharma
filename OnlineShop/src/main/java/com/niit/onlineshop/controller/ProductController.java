 package com.niit.onlineshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.onlineshop.DAO.ProductDAO;
import com.niit.onlineshop.model.Product;

@Controller
public class ProductController {
	@Autowired
	private ProductDAO productDAO;
	@Autowired
private Product product;
	
	@RequestMapping(value="/product",method=RequestMethod.GET)
	public String listCategories(Model model)
	{
		//log.debug("starting of list categories");
		model.addAttribute("product", new Product());
		model.addAttribute("productlist",productDAO.list());
		model.addAttribute("isAdminClickedproduct","true");
		//log.debug("Endof listproduct");
		
		return "product";
	}
	
	@RequestMapping(value="/manage_product_add",method=RequestMethod.POST)
	public String addproduct(@ModelAttribute("product")Product product,Model model)
	{
	//log.debug("start of add categy");
	//log.debug("id+product.getid");
	if (productDAO.save(product)==true)
	{
		model.addAttribute("msg","successfully created the product");
	}
	else
	{
		model.addAttribute("msg","not  created the table from product");
	}
	model.addAttribute("product",product);
	model.addAttribute("productlist",productDAO.list());
	model.addAttribute("isAdminClickedproduct","true");
	//log.debug("End of addproduct");
	return "product";
	}

	@RequestMapping(value="/manage_product_edit/{id}")
	public String editproduct(@PathVariable("id") String id, Model model)
	{
		model.addAttribute("product",this.productDAO.get(id));
		model.addAttribute("productlist",this.productDAO.list());
		
		
		return "product";
	}
	
	@RequestMapping(value="/manage_product_delete/{id}")
	public String deleteproduct(@PathVariable("id") String id, Model model)
	{
		productDAO.delete(id);
		
		//model.addAttribute("product",this.productDAO.delete(product)("id"));
		//model.addAttribute("productlist",productDAO.list());
		
	
		return "redirect:/product";
	}
}