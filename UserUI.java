import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Iterator;
import java.util.Scanner;

public class UserUI {
    public static void login() throws ClassNotFoundException, IOException, InvalidKeySpecException, NoSuchAlgorithmException{
        User.deserialize();
        Product.deserialize();
        Order.deserialize();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Login");
        System.out.println("Email: ");
        String email = scanner.nextLine();
        System.out.println("Password: ");
        String password = scanner.nextLine();
        User user = User.getUser(email, password);
        if(user == null){
            System.out.println("Invalid Credentials");
        }else{
            if(user.type == 1){
                costumerUI((Costumer)user, scanner);
            }else{
                administratorUI((Administrator)user, scanner);
            }
        }
    }

    public static void costumerUI(Costumer costumer, Scanner scanner) throws IOException{
        boolean repeat1 = true;
        while (repeat1) {
            System.out.println("[1]-Start new order");
            System.out.println("[0]-Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if(choice == 1){
                boolean repeat2 = true;
                while(repeat2){
                    System.out.println("[1]-Add item in cart");
                    System.out.println("[2]-Shopping cart view");
                    System.out.println("[3]-Finish order");
                    System.out.println("[0]-Return");
                    int orderChoice = scanner.nextInt();
                    scanner.nextLine();
                    switch (orderChoice) {
                        case 1:
                            boolean repeat3 = true;
                            while(repeat3){
                                Iterator<Product> i = Product.productList.iterator();
                                while (i.hasNext()) {
                                    i.next().display();
                                }
                                System.out.print("Select a product: ");
                                int index =  scanner.nextInt();
                                scanner.nextLine();
                                ShoppingCart.addCart(Product.productList.get(index)); 
                                System.out.print("Add more?\n[1]-YES\n[0]-NO\nReponse: ");
                                int response = scanner.nextInt();
                                if(response == 0){
                                    repeat3 = false;
                                }
                            } 
                            break;  
                        case 2:
                            ShoppingCart.showCart();
                                break;
                        case 3:
                            ShoppingCart.finishOrder(costumer.id);
                                break;
                        case 0:
                            repeat2 = false;
                                break;
                        default: System.out.println("Invalid option. Try again");
                            break;
                    }
                }
            }else if( choice == 0){
                System.out.println("Logoff");
                User.serialize();
                Product.serialize();
                Order.serialize();
                repeat1 = false;
            }else{
                System.out.println("Invalid option. Try again.");
            }
        }
    }

    public static void administratorUI(Administrator admin, Scanner scanner) throws IOException, InvalidKeySpecException, NoSuchAlgorithmException{
        boolean repeat = true;
        while(repeat){    
            System.out.println("[1]-Create new user");
            System.out.println("[2]-Create new product");
            System.out.println("[3]-Lowest product in invertory-Report");
            System.out.println("[4]-Most expensive order-Report");
            System.out.println("[5]-Show Inventory");
            System.out.println("[0]-Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1->{
                    System.out.println("Name:");
                    String name = scanner.nextLine();
                    System.out.println("E-mail:");
                    String email = scanner.nextLine();
                    System.out.println("Password:");
                    String password = scanner.nextLine();
                    System.out.println("Type:\n[1]-Costumer\n[2]-Administrator\nSelect the type");
                    int type = scanner.nextInt();
                    scanner.nextLine();
                    String adress = "";
                    if(type == 1){
                        System.out.println("Adress:");
                        adress = scanner.nextLine();
                        Administrator.createUser(name, email, password, type, adress);
                    }else if(type ==2){
                        Administrator.createUser(name, email, password, type, adress);
                    }else{
                        System.out.println("Invalid option. Try again");
                    }
                }
                case 2->{
                    System.out.println("Name:");
                    String name = scanner.nextLine();
                    System.out.println("Description:");
                    String description = scanner.nextLine();
                    System.out.println("Price:");
                    float price = scanner.nextFloat();
                    scanner.nextLine();
                    System.out.println("In inventory:");
                    int inInventory = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Category:");
                    String category = scanner.nextLine();
                    Administrator.createProduct(name, description, price, inInventory, category);
                }
                case 3->Administrator.productWithLowestInvetory();
                case 4->Administrator.moreExpensiveOrder();
                case 5->Administrator.showInvetory();
                case 0->{
                    User.serialize();
                    Product.serialize();
                    Order.serialize();
                    System.out.println("Logoff");
                    repeat = false;
                }
                default->System.out.println("Invalid option. Try again");
            }
        }
    }

}
