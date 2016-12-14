 package com.niit.onlineshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.onlineshop.DAO.SupplierDAO;
import com.niit.onlineshop.model.Supplier;



@Controller
public class SupplierController {
	@Autowired
	private SupplierDAO supplierDAO;
	@Autowired
private Supplier supplier;
	
	@RequestMapping(value="/supplier",method=RequestMethod.GET)
	public String listCategories(Model model)
	{
		//log.debug("starting of list categories");
		model.addAttribute("supplier", new Supplier());
		model.addAttribute("supplierlist",supplierDAO.list());
		model.addAttribute("isAdminClickedsupplier","true");
		//log.debug("Endof listsupplier");
		
		return "supplier";
	}
	
	@ModelAttribute("supplier")
	public Supplier s1()
	{
		System.out.println("Creating supplier object");
		return new Supplier();
	}
	
	@RequestMapping(value="/manage_supplier_add",method=RequestMethod.POST)
	public String addsupplier(@ModelAttribute("supplier") Supplier supplier,Model model)
	{
	//log.debug("start of add categy");
	//log.debug("id+supplier.getid");
		System.out.println(supplier.getId());
		supplierDAO.save(supplier);
	/*if (supplierDAO.save(supplier)==true)
	{
		model.addAttribute("msg","successfully created the supplier");
	}
	else
	{
		model.addAttribute("msg","not  created the table from supplier");
	}*/
	model.addAttribute("supplier",supplier);
	model.addAttribute("supplierlist",supplierDAO.list());
	model.addAttribute("isAdminClickedsupplier","true");
	//log.debug("End of addsupplier");
	return "supplier";
	}

	@RequestMapping(value="/manage_supplier_edit-{id}",method=RequestMethod.GET)
	public String editsupplier(@PathVariable("id") String id, Model model)
	{
		supplier=supplierDAO.get(id);
		System.out.println(supplier.getId());
		model.addAttribute("supplier",this.supplierDAO.get(id));
		model.addAttribute("supplierlist",this.supplierDAO.list());
		
		
		return "supplier";
	}
	
	@RequestMapping(value="/manage_supplier_delete-{id}")
	public String deletesupplier(@PathVariable("id") String id, Model model)
	{
		supplierDAO.delete(id);
		
		//model.addAttribute("supplier",this.supplierDAO.delete(supplier)("id"));
		//model.addAttribute("supplierlist",supplierDAO.list());
		
	
		return "redirect:/supplier";
	}
}










