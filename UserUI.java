import java.util.Scanner;

public class UserUI {
    private static Costumer costumer = new Costumer();
    private static Administrator administrator = new Administrator();

    public UserUI(){
        
    }

    public static void login(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Username\n");
        String username = sc.nextLine();
        System.out.println("Passowrd\n");
        String password = sc.nextLine();
        int credentials = checkCredentials(username, password);
        if(credentials == 1){
            costumerUI(costumer);
        }else if(credentials == 2){
            administratorUI(administrator);
        }else{
            System.out.println("Not possible handle password");
        }
        sc.close();
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
        int response = CostumerUI.homePage();
        if(response == 1){
            int choice = CostumerUI.orderPage();
            switch (choice) {
                case 1:
                    CostumerUI.addPage();
                    CostumerUI.homePage();
                    break;
                case 2:
                    CostumerUI.viewCartPage();
                    CostumerUI.homePage();
                    break;
                case 3:
                    CostumerUI.finishOrderPage();
                    CostumerUI.homePage();
                    break;
                case 0:
                    CostumerUI.homePage();
                    break;
                default:
                    break;
            }
        }else{
            login();
        }
    }

    private static void administratorUI(Administrator administrator){
        System.out.println("Hello, "+administrator);
        int response = AdministratorUI.homePage();
        switch (response) {
            case 1:
                AdministratorUI.createUserPage();
                AdministratorUI.homePage();
                break;
            case 2:
                AdministratorUI.createProductPage();
                AdministratorUI.homePage();
                break;
            case 3:
                AdministratorUI.moreExpensiveReportPage();
                AdministratorUI.homePage();
                break;
            case 4:
                AdministratorUI.lowestInventoryReportPage();
                AdministratorUI.homePage();
                break;
            case 0:
                login();
                break;
            default:
                break;
        }
    }
}
