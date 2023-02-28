package nazar.application;
import java.sql.Date;
import nazar.domain.User;
import nazar.service.UserService;
import nazar.service.impl.UserServiceImpl;
public class Application {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.create(new User(1,"qwerty@gmail.com", "Nazar","Pap""));
        userService.create(new User(2, "qwerty2@gmail.com", "Steve","Kap"));
        System.out.println(userService.read(1));
        userService.update(new User(3,"qwerty3@gmail.com", "Steve","Saq"));
        System.out.println(userService.read(2));
        userService.delete(2);
    }

}