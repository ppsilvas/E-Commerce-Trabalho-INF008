import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TreeMap;

@SuppressWarnings("unchecked")
public class Order implements Serializable{
    private int id;
    private String date;
    private float orderTotal;
    private int costumerId;
    private static int numberOfOrder = 0;
    private ArrayList<Product> shoppingCart;
    private static TreeMap<Float, Order> orderMap = new TreeMap<Float, Order>();

    public Order(){
        
    }

    public Order(int costumerId, ArrayList<Product> shoppingCart, float orderTotal){
        id = numberOfOrder++;
        this.date = SystemUtil.setDate();
        this.orderTotal = orderTotal;
        this.costumerId = costumerId;
        this.shoppingCart = shoppingCart;
    }

    public static void finishOrder(float total, Order finishedOrder){
        orderMap.put(total, finishedOrder);
    }

    public static void mostExpensiveOrder(){
        float key = orderMap.lastKey();
        Order mostExpensive =  orderMap.get(key);
        System.out.println("["+mostExpensive.id+"] - $"+mostExpensive.orderTotal+" - "+mostExpensive.date);
    }

    public static void deserialize() throws IOException, ClassNotFoundException{
        FileInputStream fis = new FileInputStream("order.dat");
        ObjectInputStream ois = new ObjectInputStream(fis);
        orderMap = (TreeMap<Float, Order>) ois.readObject();
        fis.close();
        System.out.println("Deserialize with sucess");
    }

    public static void serialize() throws IOException{
        FileOutputStream fos = new FileOutputStream("order.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(orderMap);
        fos.close();
        System.out.println("Serialize with success!");
    }
}
