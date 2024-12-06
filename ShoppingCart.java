import java.util.ArrayList;
import java.util.Date;

public class ShoppingCart {
    protected static ArrayList<Product> shoppingCart = new ArrayList<Product>();
    private static float total =0;

    public static void addCart(Product product){
        shoppingCart.add(product);
        total += product.price;
        Product.productBought(product.id);
    }

    public static void showCart(){
        for(Product product:shoppingCart)
            product.display();
    }

    public static void finishOrder(int costumerId){
        Order order = new Order(costumerId, shoppingCart, total);
        Order.finishOrder(costumerId, order);
    }

}
