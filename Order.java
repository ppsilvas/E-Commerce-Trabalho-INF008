import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TreeMap;

public class Order implements Serializable{
    private int id;
    private String date;
    protected static float orderTotal = 0;
    private int costumerId;
    private int numberOfOrder = 0;
    private ArrayList<Product> shoppingCart;
    private static TreeMap<Float, Order> orderMap = new TreeMap<Float, Order>();

    public Order(){

    }

    public Order(int costumerId, ArrayList<Product> shoppingCart){
        id = numberOfOrder++;
        Date x = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        this.date = sdf.format(x);
        this.costumerId = costumerId;
        this.shoppingCart = shoppingCart;

    }

    public static void finishOrder(float total, Order finishedOrder){
        orderMap.put(total, finishedOrder);
    }

    public static Order mostExpensiveOrder(){
        float key = orderMap.lastKey();
        return orderMap.get(key);
    } 

}
