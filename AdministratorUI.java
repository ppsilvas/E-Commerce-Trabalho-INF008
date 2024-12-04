import java.util.Scanner;

public class AdministratorUI {
    private static Scanner sc = new Scanner(System.in);
    public static int homePage(){
        System.out.println("\n[1]-Create new User");
        System.out.println("[2]-Create new Product");
        System.out.println("[3]-More expensive order Report");
        System.out.println("[4]-Product with lowest inventory Report");
        System.out.println("[0]-Exit\n");
        int choice = sc.nextInt();
        sc.nextLine();
        return choice;
    }

    public static void createUserPage(){
        System.out.println("\nUser's name:");
        String userName = sc.nextLine();
        System.out.println("\nUser's email:");
        String userEmail = sc.nextLine();
        System.out.println("\nUser's password:");
        String userPassword = sc.nextLine();
        System.out.println("\n[1]-Costumer\n[2]-Administrator:");
        int type = sc.nextInt();
        sc.nextLine();
        if(type == 1){
            System.out.println("\nAdress:");
            String adress = sc.nextLine();
            Administrator.createUser(userName, userEmail, userPassword, type, adress);

        }else{
            Administrator.createUser(userName, userEmail, userPassword, type, null);
        }
    }

    public static void createProductPage(){
        System.out.println("\nProduct's name:");
        String productName = sc.nextLine();
        System.out.println("\nProduct's description:");
        String productDescription = sc.nextLine();
        System.out.println("\nProduct's price:");
        float productPrice = sc.nextFloat();
        sc.nextLine();
        System.out.println("\nTotal in Inventory:");
        int productInventory = sc.nextInt();
        sc.nextLine();
        System.out.println("\nProduct's category:");
        String productCategory = sc.nextLine();
        Administrator.createProduct(productName, productDescription, productPrice, productInventory, productCategory); 
    }

    public static void moreExpensiveReportPage(){
        Order.mostExpensiveOrder();
    }

    public static void lowestInventoryReportPage(){
        Product.getLowestInventory();
    }
}
