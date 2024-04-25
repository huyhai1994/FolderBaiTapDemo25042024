import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class UserManager {

    public static final String PATH_FILE = "data/user.txt";
    private List<User> users;
    public UserManager(){
        this.users = new ArrayList<User>();
    }
    public void showListUsers(){
        for(User user: users){
            System.out.println(user);
        }
    }
    public void readDataToFile(){
        try{
            FileReader fileReader = new FileReader(PATH_FILE);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            try{
                while((line = bufferedReader.readLine())!=null){
                    String[] txt = line.split(",");
                    String nameUser = txt[0];
                    String passwordUser = txt[1];
                    String emailUser= txt[2];
                    User userExtractFromFile = new User(nameUser,passwordUser,emailUser);
                    this.users.add( userExtractFromFile);
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }

        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
    public int userSize(){
        return users.size();
    }

}
