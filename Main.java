import java.io.IOException;
import java.util.Iterator;

public class Main{
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Product.deserialize();
        User.deserialize();
        Order.deserialize();
        // UserUI.login();
        // Costumer c1 = new Costumer("Pedro", "ppsilvasantana@gmail.com", "pedro", 1, "Rua Duarte da Costa");
        // Administrator a1 = new Administrator("admin", "admin", "admin", 2);
        // User.add("admin",(Administrator) a1);
        // User.add("ppsilvasantana@gmail.com",(Costumer)c1);
        // Product p1 = new Product("Banana", "Tropical fruit", 2.5f, 100, "Horti-fruit");
        // Product.add(p1);
        // Administrator.createProduct("Soup", "Chicken soup", 4.99f, 500, "Food");
        // Administrator.createProduct("T-shir", "Cottom T-shir", 19.99f, 250, "Clothing");
        Iterator<Product> i = Product.productList.iterator();
        while (i.hasNext()) {
            i.next().display();
        }
        Order.serialize();
        User.serialize();
        Product.serialize();
        System.exit(0);
    }
}