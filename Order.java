import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Order implements Serializable{
    private int id;
    private Date date;
    protected static float orderTotal = 0;
    private int costumerId;
    private int numberOfOrder = 0;
    private static ArrayList<ShoppingCart> orderList;

    public Order(){

    }

    public Order(Date date, int costumerId){
        id = numberOfOrder++;
        this.date = date;
        this.costumerId = costumerId;
    }
}
