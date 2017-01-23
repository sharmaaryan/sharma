package com.niit.onlineshopbackend;
import java.util.List;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.niit.onlineshop.DAO.CartDAO;
import com.niit.onlineshop.model.Cart;
public class CartTestCase {
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
         CartDAO cartDAO =(CartDAO) context.getBean("CartDAO");
		Cart cart=(Cart) context.getBean("cart");
		cart.setId(1);
		cart.setCartproduct_id("o_01");
		cart.setPrice(200);
		cart.setProductName("Apple laptop");
		cart.setQuantity("1");
		cart.setUser_id("U001");
		System.out.println(cartDAO.save(cart));
cartDAO.delete(cart);
cartDAO.save(cart);
		List<Cart> calist=cartDAO.list();
		for(Cart ca:calist)
		{
			System.out.println("Cart cart product ID:"+ca.getCartproduct_id());
			System.out.println("Cart  ID:"+ca.getId());
			System.out.println("product name"+ca.getProductName());
			System.out.println("product price:"+ca.getPrice());
			System.out.println("Quantity:"+ca.getQuantity());
			System.out.println("Cart userid:"+ca.getUser_id());
			}

}
}
