import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class Product implements Serializable {
    protected int id;
    protected String name;
    private String description;
    protected float price;
    private int totalInInventory;
    private String category;
    private int numberOfProduct = 0;
    protected static ArrayList<Product> productList = new ArrayList<Product>();

    public Product(){

    }

    public Product(String name, String description, float price, int totalInInventory, String category){
        id = numberOfProduct++;
        this.name = name;
        this.description = description;
        this.price = price;
        this.totalInInventory = totalInInventory;
        this.category = category;
        productList.add(this);
    }

    public static void productBought(int index){
        productList.get(index).totalInInventory--;
    }

    public static void add(Product product){
        productList.add(product);
    }

    public void display(){
        System.out.println("["+id+"]-"+name+"-$:"+price);
    }

    public static void getLowestInventory(){
        Product lowestInventory = productList.getFirst();
        Iterator<Product> producIterator = productList.iterator();
        while(producIterator.hasNext()){
            if(lowestInventory.totalInInventory > producIterator.next().totalInInventory){
                lowestInventory = producIterator.next();
                producIterator.next();
            }
        }
        System.out.println("["+lowestInventory.id+"] -"+lowestInventory.name);
    }

    @SuppressWarnings("unchecked")
    public static void deserialize() throws IOException, ClassNotFoundException{
        FileInputStream fis = new FileInputStream("product.dat");
        ObjectInputStream ois = new ObjectInputStream(fis);
        productList = (ArrayList<Product>) ois.readObject();
        fis.close();
        System.out.println("Deserialize with sucess");
    }

    public static void serialize() throws IOException{
        FileOutputStream fos = new FileOutputStream("product.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(productList);
        fos.close();
        System.out.println("Serialize with success!");
    }
}
