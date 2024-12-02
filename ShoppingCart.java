import java.util.ArrayList;
import java.util.Date;

public class ShoppingCart {
    private int costumerId;
    private static ArrayList<Product> shoppingCart = new ArrayList<Product>();

    public ShoppingCart(int costumerId){
        this.costumerId = costumerId;
    }

    public static void addCart(Product product){
        shoppingCart.add(product);
        Order.orderTotal += product.price;
        Product.productBought(product.id);
    }

    public static void showCart(){
        for(Product product:shoppingCart)
            product.display();
    }

    public void finishOrder(){
        Order order = new Order(costumerId, shoppingCart);
        Order.finishOrder(costumerId, order);
    }

}
