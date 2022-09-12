package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User user1 = new User("User1", "Lastname1", "user1@mail.ru");
      User user2 = new User("User2", "Lastname2", "user2@mail.ru");

      user1.setCar(new Car("Logan", 5524));
      user2.setCar(new Car("Largus", 7728));

      userService.add(user1);
      userService.add(user2);

      for (User user : userService.listUsers()) {
         System.out.println(user);
         System.out.println();
      }

      System.out.println(userService.findUser("Logan", 5524));

      context.close();
   }
}
