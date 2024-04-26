import java.io.File;
import java.io.IOException;

public class UserManagerTest {
    public static void main(String[] args) throws IOException {
        File fileWriter = new File("data/user.txt");
        System.out.println(fileWriter.canRead());
        System.out.println(fileWriter.canWrite());
        UserManager userManager = new UserManager();
//        userManager.readDataToFile();
        userManager.showListUsers();
        System.out.println("Total users: " + userManager.userSize());
        User user1 = new User("Truong12","321","truong@gmail.com");
        userManager.addUser(user1);
        userManager.showListUsers();
        System.out.println("Total users: " + userManager.userSize());
    }
}
