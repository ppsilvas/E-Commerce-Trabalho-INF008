import java.io.IOException;

public class Main{
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // Product.deserialize();
        // User.deserialize();
        // UserUI.login();
        Costumer c1 = new Costumer("Pedro", "ppsilvasantana@gmail.com", "pedro", 1, "Rua Duarte da Costa");
        Administrator a1 = new Administrator("admin", "admin", "admin", 2);
        User.add("admin",(Administrator) a1);
        User.add("ppsilvasantana@gmail.com",(Costumer)c1);
        Product p1 = new Product("Banana", "Tropical fruit", 2.5f, 100, "Horti-fruit");
        Product.add(p1);
        User.serialize();
        Product.serialize();
        System.exit(0);
    }
}