/* package com.niit.onlineshop.controller;

import java.nio.file.Paths;


import org.apache.taglibs.standard.extra.spath.Path;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.niit.onlineshop.DAO.CategoryDAO;
import com.niit.onlineshop.DAO.ProductDAO;
import com.niit.onlineshop.DAO.SupplierDAO;
import com.niit.onlineshop.model.Category;
import com.niit.onlineshop.model.Product;
import com.niit.onlineshop.model.Supplier;

@Controller
public class ProductController {
	
	@Autowired
	private ProductDAO productDAO;
	@Autowired
    private Product product;
	
	@Autowired
	private SupplierDAO supplierDAO;
	@Autowired
	private Supplier supplier;
	
	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private Category category;
	
	
	
	
	
	
	
	//..................................LIST PRODUCT FUNTON................................//
	
	@RequestMapping(value="/product",method=RequestMethod.GET)
	public String listproduct(Model model)
	{
		//log.debug("starting of list categories");
		model.addAttribute("product", new Product());
		model.addAttribute("category", new Category());
		model.addAttribute("supplier", new Supplier());
		model.addAttribute("productlist", this.productDAO.list());
		model.addAttribute("isAdminClickedproduct","true");
		  model.addAttribute("categoryList", this.categoryDAO.list());
		  model.addAttribute("supplierList", this.supplierDAO.list());
		//log.debug("Endof listproduct");
		
		return "product";
	}
	
	
	
	
	//..............................PRODUCT SAVE FUNTION.....................................................//
	
	@RequestMapping(value="/manage_product_add",method=RequestMethod.POST)
	public String addproduct(@ModelAttribute("product")Product product,Model model)
	{
	//log.debug("start of add categy");
	//log.debug("id+product.getid");
		System.out.println(product.getId());
		//productDAO.save(product);
		
		
		Category category =categoryDAO.getName(product.getCategory().getName());
		categoryDAO.save(category);
		
		Supplier supplier =supplierDAO.getName(product.getSupplier().getName());
		supplierDAO.save(supplier);
		
		product.setCategory(category);
		product.setSupplier(supplier);
	    
		product.setCategory_id(category.getCategory_id());
		product.setSupplier_id(supplier.getSupplier_id());
		
		productDAO.save(product);
		
		
		
		
		
		//Supplier supplier =supplierDAO.getName(product.getSupplier().getName());
		
		
		MultipartFile file=product.getImage();
	
		path = Paths.get(rootDirectory + "\\resources\\image\\" + product.getId() + ".jpg");
		
		
		
		
		if(file!=null && !file.isEmpty()){
			try{
				file.transferTo(new File(path.tostring()));
				System.out.println("image upload tp product.....");
				}catch(Exception e)
			{
					e.printStackTrace();
					throw new RuntimeException("image saving failed ",e);
					
			}
		}
		System.out.println("path converting to String ");
		FileUtil.upload(Path.toString(), file, product.getId() + ".jpg");
		System.out.println("path converting to String" + product.getId());
		return "redirect:/manageproduct";

		
		
	if (productDAO.save(product)==true)
	{
		model.addAttribute("msg","successfully created the product");
	}
	else
	{
		model.addAttribute("msg","not  created the table from product");
	}
	
	
	
	
	return "product";
	}
	
	
	
	
//...................*PRODUCT EDIT*..............//
	
	@RequestMapping(value="/manage_product_edit-{id}",method=RequestMethod.GET)
	public String editproduct(@PathVariable("id") String id, Model model)
	{
		product=productDAO.get(id);
		System.out.println(product.getId());
   		model.addAttribute("product",this.productDAO.get(id));
		model.addAttribute("productlist",this.productDAO.list());
		
		
		return "product";
	}
	
	

	
	
	
	//....................PRODUCT DELETE....................................//
	
	@RequestMapping(value="/manage_product_delete-{id}")
	public String deleteproduct(@PathVariable("id") String id, Model model)
	{
		productDAO.delete(id);
		
		//model.addAttribute("product",this.productDAO.delete(product)("id"));
		//model.addAttribute("productlist",productDAO.list());
		
	
		return "redirect:/product";
	}
}*/

/*package com.niit.onlineshop.controller;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.niit.onlineshop.DAO.CategoryDAO;
import com.niit.onlineshop.DAO.ProductDAO;
import com.niit.onlineshop.DAO.SupplierDAO;
import com.niit.onlineshop.model.Category;
import com.niit.onlineshop.model.Product;
import com.niit.onlineshop.model.Supplier;


@SuppressWarnings("unused")
@Controller
public class ProductController {

	private static Logger log = LoggerFactory.getLogger(ProductController.class);

  @Autowired
  private Product product;
  
  @Autowired
  private ProductDAO productDAO;
  
  @Autowired
  private Category category;
  
  @Autowired
  private CategoryDAO categoryDAO;
  
  @Autowired
  private Supplier supplier;
  
  @Autowired
  private SupplierDAO supplierDAO;
  
  private Path path;
  
 // private String path = "D:\\ShoppingCartFrontEnd\\img";
  
	

-------------------------SAVE FUNCTION FOR PRODUCT-----------------------------------

	@RequestMapping(value = "/productadd", method = RequestMethod.POST)
	public String addprofun(@ModelAttribute("product") Product product, HttpServletRequest request)
	{
		
//		Util util=new Util();
//		String id=util.replace(product.getProduct_id(), ",", "");
//		product.setProduct_id(id);
		
		
		Category category = categoryDAO.getName(product.getCategory().getCategory_id());
		System.out.println(category.getName());
		categoryDAO.save(category);
		
		Supplier supplier = supplierDAO.getName(product.getSupplier().getSupplier_id());
		System.out.println(supplier.getName());
		supplierDAO.save(supplier);
		
		product.setCategory(category);
		product.setSupplier(supplier);
		
		product.setCategory_id(category.getCategory_id());
		product.setSupplier_id(supplier.getSupplier_id());
		productDAO.saveOrUpdate(product);

		
		
		MultipartFile file=product.getImage();
		
		String rootDirectory=request.getSession().getServletContext().getRealPath("/");
		path=Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\"+product.getPro_id()+".jpg");
		path = Paths.get(rootDirectory + "\\resources\\image\\" + product.getProduct_id() + ".jpg");
		
		if(file!=null && !file.isEmpty()){
			try{
				file.transferTo(new File(path.toString()));
				System.out.println("Image Uploaded to Product.....");
			}catch(Exception e)
			{
				e.printStackTrace();
				throw new RuntimeException("image saving failed ",e);
			}
		}
		
		System.out.println("path converting to string");
		FileUtil.upload(path.toString(), file, product.getProduct_id() + ".jpg");
		System.out.println("path converted to string" + product.getProduct_id());
		 
		return "product";
	}

	

	@RequestMapping(value="/product", method = RequestMethod.GET)
	public String listproduct(Model model)
	{
		  model.addAttribute("product", new Product());
		  model.addAttribute("category", new Category());
		  model.addAttribute("supplier", new Supplier());
		  model.addAttribute("productList", this.productDAO.list());
		  model.addAttribute("categoryList", this.categoryDAO.list());
		  model.addAttribute("supplierList", this.supplierDAO.list());
		 
		return "product";
	}

	
	@RequestMapping("productdelete-{product_id}")
	public String deleteProduct(@PathVariable("product_id") String product_id, ModelMap model) throws Exception {

		try {
			productDAO.delete(product_id);
			model.addAttribute("message", "Successfully Deleted");
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			e.printStackTrace();
		}
		// redirectAttrs.addFlashAttribute(arg0, arg1)
		return "product";
	}

	
	
 ------------------------------------------------EDIT FUNCTION FOR PRODUCT-----------------------------------------------------------------------

@RequestMapping(value="/productedit-{product_id}",method = RequestMethod.GET)
	public String proeditfunc(@PathVariable("product_id") String product_id, Model model)
	{
		model.addAttribute("product", this.productDAO.getProduct(product_id));
		model.addAttribute("productList", this.productDAO.list());
		model.addAttribute("categoryList", this.categoryDAO.list());
		model.addAttribute("supplierList", this.supplierDAO.list());
		
		return "product";
	}




@RequestMapping(value = "/productdetail-{product_id}")
public String getSelectedProduct(@PathVariable("product_id") String product_id, Model model,
		RedirectAttributes redirectAttributes) {
	
	model.addAttribute("product", new Product());
	  model.addAttribute("category", new Category());
	  model.addAttribute("supplier", new Supplier());
	  model.addAttribute("productList", this.productDAO.list());
	  model.addAttribute("categoryList", this.categoryDAO.list());
	  model.addAttribute("supplierList", this.supplierDAO.list());
	
	redirectAttributes.addFlashAttribute("selectedProduct", productDAO.getProduct(product_id));
	
	
	
	return "product";

}
  
  
  

}
}*/





/*package com.niit.shoppingCart;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.niit.shoppingcart.dao.CartDAO;
import com.niit.shoppingcart.model.cartModel;

public class cartTest
{

	
	public static void main(String[] args)
	{
		AnnotationConfigApplicationContext context =new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		CartDAO cartDAO=(CartDAO) context.getBean("CartDAO");
		 cartModel cart= (cartModel) context.getBean("cartModel");
	
		
		//category .setCat_id("MOB002");
		//category.setCat_name("Iphone7");
		//category.setDescription("Iphone is an Iphone ");
		
		cart.setId("LG00");
		cart.setName("LG");
		cart.setDescription("single");
		
		cartDAO.save(cart);

		
		System.out.println("db is connected");
		cartDAO.delete(cart);
		//System.out.println( "data is deleted");
		//categoryDAO.update(category);
		//suppl.delete(category);
		//System.out.println( "data is deleted");
		//System.out.println( "data is updated");
		
		System.out.println("Data inserted into DB");
		
		
		
	}
	
}
*/

//===============================================================================================================================================//

package com.niit.onlineshop.controller;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.niit.onlineshop.DAO.CategoryDAO;
import com.niit.onlineshop.DAO.ProductDAO;
import com.niit.onlineshop.DAO.SupplierDAO;
import com.niit.onlineshop.model.Category;
import com.niit.onlineshop.model.Product;
import com.niit.onlineshop.model.Supplier;
import com.niit.onlineshop.util.FileUtil;



@Controller
public class ProductController 
{
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	Category category;
	
	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	SupplierDAO supplierDAO;
	
	@Autowired
	Supplier supplier;
	
	@Autowired
	Product product;
	
	private Path path;
	
	@RequestMapping(value="/productadd", method=RequestMethod.POST)
	public String addProduct(Model model,@ModelAttribute("product") Product product,HttpServletRequest request)
	{
		
		Category category=categoryDAO.getName(product.getCategory().getName());
		categoryDAO.save(category);
		
		Supplier supplier=supplierDAO.getName(product.getSupplier().getName());
		supplierDAO.save(supplier);
		
		
		product.setCategory(category);
		product.setSupplier(supplier);
		
		product.setCategory_id(category.getCategory_id());
		product.setSupplier_id(supplier.getSupplier_id());
		
		productDAO.save(product);

		
		//FileUtil.upload(path.toString(), file, product.getp_id()+".jpg");
		//System.out.println("image uploaded"+product.getp_id());
		
	
	//=====================FOR AAD IMAGE PRODUCT============================//
	
	
	MultipartFile file=product.getImage();
	
	String rootDirectory=request.getSession().getServletContext().getRealPath("/");
	
	path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\"+ product.getProduct_id() + ".jpg");
	System.out.println("path value "+path);
	if(file!=null && !file.isEmpty()){
	try{
	file.transferTo(new File(path.toString()));
	System.out.println("image upload...:");
	
	
	}catch(Exception e)
	{
	e.printStackTrace();
	throw new RuntimeException("image saving failed ",e);
	  }
	}
	
	FileUtil.upload(path.toString(), file, product.getProduct_id() + ".jpg");
	System.out.println("image upload.....:"+product.getProduct_id());
	return "redirect:/product";

  }
 
 

/*//==========================================================================//
*/	
	
	@RequestMapping("manage_product_delete-{p_id}")
	public String deleteProduct(@PathVariable("p_id") String p_id, ModelMap model) throws Exception {

		try {
			productDAO.delete(p_id);
			model.addAttribute("message", "Successfully Added");
		} catch (Exception e)
		{
			model.addAttribute("message", e.getMessage());
			e.printStackTrace();
		}
		// redirectAttrs.addFlashAttribute(arg0, arg1)
		return "redirect:/product";
	}
	

	@RequestMapping("/manage_product_edit-{p_id}")
	public String editProduct(@PathVariable("p_id") String p_id, Model model) 
	{
		System.out.println("editProduct");
		
		model.addAttribute("product",this.productDAO.get(p_id));
		model.addAttribute("productList", this.productDAO.list());
		model.addAttribute("categoryList", this.categoryDAO.list());
		model.addAttribute("supplierList", this.supplierDAO.list());
		return "product";
	}
	

	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public String listProducts(Model model)
	{
		model.addAttribute("product",new Product());
		model.addAttribute("supplier",new Supplier());
		model.addAttribute("category",new Category());
		model.addAttribute("productList",this.productDAO.list());
		model.addAttribute("categoryList",this.categoryDAO.list());
		model.addAttribute("supplierList",this.supplierDAO.list());
		return "product";
	}
	
	@RequestMapping(value="product/get/{p_id}")
	public String getSelectedProduct(@PathVariable("p_id") String p_id,Model model,RedirectAttributes redirectAttributes)
	{
		redirectAttributes.addFlashAttribute("selectedProduct",productDAO.get(p_id));
		
		return "redirect:/backToHome";		
	}

	@RequestMapping(value="/backToHome",method=RequestMethod.GET)
	public String backToHome(@ModelAttribute("selectedProduct")
	final Product selectedProduct,final Model model)
	{
		model.addAttribute("selectedProduct",selectedProduct);
		model.addAttribute("categoryList",this.categoryDAO.list());
		return "index";
		
		
	}
	
}