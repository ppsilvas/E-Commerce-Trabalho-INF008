import java.util.Scanner;

public class Administrator extends User{
    public Administrator(){
        super(null,null, null, 0);
    }

    public Administrator(String name, String email, String password, int type){
        super(name, email, password, type);
    }

    public static void createUser(String name,String email, String password){
        Scanner sc = new Scanner(System.in);
        System.out.println("[1]-Costumer\n[2]-Administrator:");
        int choice = sc.nextInt();
        if(choice == 1){
            String adress = sc.nextLine();
            Costumer costumer = new Costumer(name, email, password, 1, adress);
            User.add(email, (Costumer)costumer);
        }else{
            Administrator administrator = new Administrator(name, email, password, 2);
            User.add(email, (Administrator)administrator);
        }
        sc.close();
    }

    public static void createProduct(String name, String description, float price, int totalInInventory, String category){
        Product product = new Product(name, description, price, totalInInventory, category);
        Product.add(product);
    }
}
