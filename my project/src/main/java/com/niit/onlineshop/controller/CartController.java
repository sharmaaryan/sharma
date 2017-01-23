package com.niit.onlineshop.controller;

import java.nio.file.Path;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.niit.onlineshop.DAO.CartDAO;
import com.niit.onlineshop.DAO.ProductDAO;
import com.niit.onlineshop.DAO.SupplierDAO;
import com.niit.onlineshop.model.Cart;
import com.niit.onlineshop.model.Product;
import com.niit.onlineshop.model.Supplier;


@Controller
public class CartController {
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	Cart cart;
	
	@Autowired
	CartDAO cartDAO;
	
	@Autowired
	SupplierDAO supplierDAO;
	
	@Autowired
	Supplier supplier;
	
	@Autowired
	Product product;
	
	private Path path;

	
	
	@RequestMapping(value="/cartadd-{id}")
	public String addCart(@PathVariable("id") String id, Model model,Principal p)
	{
		product=productDAO.get(id);
		cart.setProduct_id(id);
		cart.setProductName(product.getProduct_name());
		cart.setQuantity("1");
		cart.setPrice(product.getProduct_price());
		cart.setCartproduct_id(product.getProduct_id());
		try
		{
		cart.setUser_id(p.getName());
		}
		catch(Exception e)
		{
			model.addAttribute("msg","Plz login");
			return "cart";
		}
		cartDAO.save(cart);

		model.addAttribute("cart",new Cart());
		model.addAttribute("cartList",cartDAO.usercartlist(p.getName()));
		
		int i,j=0;
		int s=0;
		int n=cartDAO.usercartlist(p.getName()).size();
		System.out.println(n);
		for(i=0;i<n;i++){
			s=s+cartDAO.usercartlist(p.getName()).get(i).getPrice();
		}
		System.out.println(s);
		model.addAttribute("sum",s);
		
	return "redirect:/cart";

  }
 
 

/*//==========================================================================//
*/	
	
	@RequestMapping("cart/delete/{id}")
	public String deleteCart(@PathVariable("id") String id, ModelMap model) throws Exception {

		try {
			cart=cartDAO.get(id);
			cartDAO.delete(cart);
			model.addAttribute("message", "Successfully deleted");
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		// redirectAttrs.addFlashAttribute(arg0, arg1)
		return "redirect:/cart";
	}
	

	@RequestMapping("/manage_cart_edit-{id}")
	public String edit(@PathVariable("id") String id, Model model) 
	{
		System.out.println("editCart");
		
		model.addAttribute("cart",this.cartDAO.get(id));
		model.addAttribute("cartList", this.cartDAO.list());
		//model.addAttribute("categoryList", this.categoryDAO.list());
		//model.addAttribute("supplierList", this.supplierDAO.list());
		return "cart";
	}
	

	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public String listCart(Model model,Principal p)
	{
		//model.addAttribute("product",new Product());
		//model.addAttribute("supplier",new Supplier());
		model.addAttribute("cart",new Cart());
		model.addAttribute("cartList",this.cartDAO.usercartlist(p.getName()));
		//model.addAttribute("categoryList",this.categoryDAO.list());
		//model.addAttribute("supplierList",this.supplierDAO.list());
		
		int i,j=0;
		int s=0;
		int n=cartDAO.usercartlist(p.getName()).size();
		System.out.println(n);
		for(i=0;i<n;i++){
			s=s+cartDAO.usercartlist(p.getName()).get(i).getPrice();
		}
		System.out.println(s);
		model.addAttribute("sum",s);
		
		return "cart";
	}
	
	/*@RequestMapping(value="cart/get/{c_id}")
	public String getSelectedProduct(@PathVariable("c_id") String c_id,Model model,RedirectAttributes redirectAttributes)
	{
		redirectAttributes.addFlashAttribute("selectedProduct",productDAO.get(c_id));
		
		return "redirect:/backToHome";		
	}

	@RequestMapping(value="/backToHome",method=RequestMethod.GET)
	public String backToHome(@ModelAttribute("selectedProduct")
	final Cart selectedProduct,final Model model)
	{
		model.addAttribute("selectedCart",selectedProduct);
		model.addAttribute("categoryList",this.cartDAO.list());
		return "index";
		
		
	}*/
}
