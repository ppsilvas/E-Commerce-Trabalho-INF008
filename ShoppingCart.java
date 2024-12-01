import java.util.ArrayList;

public class ShoppingCart {
    private static ArrayList<Product> shoppingCart = new ArrayList<Product>();

    public ShoppingCart(){

    }

    public static void addCart(Product product){
        shoppingCart.add(product);
    }

    public static void showCart(){
        for(Product product:shoppingCart)
            product.display();
    }

}
