import java.util.Scanner;

public class CostumerUI {
    private static Scanner sc = new Scanner(System.in);

    public static int homePage(){
        System.out.println("[1]-Start new order");
        System.out.println("[0]-Exit\n");
        int choice = sc.nextInt();
        sc.nextLine();
        if(choice == 1){
            return 1;
        }
        return 0;
    }

    public static int orderPage(){
        System.out.println("[1]-Add product");
        System.out.println("[2]-View shopping cart");
        System.out.println("[3]-Finish order");
        System.out.println("[0]-Back\n");
        int choice = sc.nextInt();
        sc.nextLine();
        return choice;
    }

    public static void addPage(){
        int response = 1;
        while (response == 1){
            for(Product product:Product.productList)
                product.display();
            ShoppingCart.addCart(Product.productList.get(sc.nextInt()));
            System.out.println("Continue adding items?\n[1]-YES\n[0]-NO\n");
            response = sc.nextInt();
            sc.nextLine();
        }
    }

    public static void viewCartPage(){
        ShoppingCart.showCart();
    }

    public static void finishOrderPage(){

    }
}
