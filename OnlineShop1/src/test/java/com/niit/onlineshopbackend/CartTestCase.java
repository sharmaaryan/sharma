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
		cart.setId("ca_03");
		cart.setOrderid("o_01");
		cart.setBillingaddressid("b_01");
		cart.setShippingaddressid("a_01");
		cart.setPaymentmethod("creditcard");
		System.out.println(cartDAO.save(cart));
cartDAO.delete(cart);
cartDAO.update(cart);
		List<Cart> calist=cartDAO.list();
		for(Cart ca:calist)
		{
			System.out.println("Cart BILLING ADDRESS ID:"+ca.getBillingaddressid());
			System.out.println("Cart SHIPPING ADDRESS ID:"+ca.getShippingaddressid());
			System.out.println("Cart ID:"+ca.getId());
			System.out.println("Cart payment method:"+ca.getPaymentmethod());
			System.out.println("Cart orderid:"+ca.getOrderid());
			}

}
}
