import java.util.Scanner;

public class UserUI {
    private static Costumer costumer = new Costumer();
    private static Administrator administrator = new Administrator();

    public UserUI(){
        
    }

    public static void login(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Username");
        String username = sc.nextLine();
        System.out.println("Passowrd");
        String password = sc.nextLine();
        int credentials = checkCredentials(username, password);
        if(credentials == 1){
            costumerUI(costumer);
        }else if(credentials == 2){
            administratorUI(administrator);
        }else{
            System.out.println("Not possible handle password");
        }
    }

    private static int checkCredentials(String username, String password){
        if(User.getUser(username, password) != null){
            if(User.getUser(username, password).type == 1){
                costumer = (Costumer) User.getUser(username, password);
                return 1;
            }else{
                administrator = (Administrator) User.getUser(username,password);
                return 2;
            }
        }
        return 0;
    }

    private static void costumerUI(Costumer costumer){
        System.out.println("Hello, "+ costumer);
        Scanner sc = new Scanner(System.in);
        System.out.println("[1]-Start new order");
        System.out.println("[0]-Exit");
        int choice1 = sc.nextInt();
        sc.nextLine();
        if(choice1 == 1){
            System.out.println("[1]-Add product");
            System.out.println("[2]-View shopping cart");
            System.out.println("[3]-Finish order");
            System.out.println("[0]-Back");
            int choice2 = sc.nextInt();
            sc.nextLine();
            switch (choice2) {
                case 1:
                    for(Product product:Product.productList)
                        product.display();
                    ShoppingCart.addCart(Product.productList.get(sc.nextInt()));
                    break;
                case 2:
                    ShoppingCart.showCart();
                    break;
                case 3:

                    break;
                case 0:

                    break;
                default:
                    break;
            }
        }else{
            login();
        }
        sc.close();
    }

    private static void administratorUI(Administrator administrator){
        System.out.println("Hello, "+administrator);
        Scanner sc = new Scanner(System.in);
        System.out.println("[1]-Create new User");
        System.out.println("[2]-Create new Product");
        System.out.println("[3]-More expensive order Report");
        System.out.println("[4]-Product with lowest inventory Report");
        System.out.println("[0]-Exit");
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1:
                System.out.println("User's name: ");
                String userName = sc.nextLine();
                System.out.println("User's email: ");
                String userEmail = sc.nextLine();
                System.out.println("User's password: ");
                String userPassword = sc.nextLine();
                Administrator.createUser(userName, userEmail, userPassword);
                break;
            case 2:
                System.out.println("Product's name: ");
                String productName = sc.next();
                System.out.println("Product's description: ");
                String productDescription = sc.next();
                sc.nextLine();
                System.out.println("Product's price: ");
                float productPrice = sc.nextFloat();
                sc.nextLine();
                System.out.println("Total in Inventory: ");
                int productInventory = sc.nextInt();
                sc.nextLine();
                System.out.println("Product's category: ");
                String productCategory = sc.nextLine();
                Administrator.createProduct(productName, productDescription, productPrice, productInventory, productCategory);
                break;
            case 3:

                break;
            case 4:

                break;
            case 0:
                login();
                break;
            default:
                break;
        }
        sc.close();
    }
}
