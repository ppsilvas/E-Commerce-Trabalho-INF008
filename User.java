import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;

public class User implements Serializable{
    protected int id;
    private String name;
    private String email;
    private String password;
    protected int type;
    private static int numberOfUser = 0;
    private static HashMap<String, User> userMap = new HashMap<String,User>();

    private User(){
        
    }

    public User(String name, String email, String password, int  type){
        id = numberOfUser++;
        this.name = name;
        this.email = email;
        this.password = password;
        this.type = type;
    }

    public static void add(String email, User user){
        userMap.putIfAbsent(email, user);
    }

    public static User getUser(String username, String password){
        User user = userMap.get(username);
        if(user != null && user.password != null){
            if(user.password.equals(password)){
                return user;
            }
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public static void deserialize() throws IOException, ClassNotFoundException{
        FileInputStream fis = new FileInputStream("user.dat");
        ObjectInputStream ois = new ObjectInputStream(fis);
        userMap = (HashMap<String, User>) ois.readObject();
        fis.close();
        System.out.println("Deserialize with sucess");
    }

    public static void serialize() throws IOException{
        FileOutputStream fos = new FileOutputStream("user.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(userMap);
        fos.close();
        System.out.println("Serialize with success!");
    }
}
