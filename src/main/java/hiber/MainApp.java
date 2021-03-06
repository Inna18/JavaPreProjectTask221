package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
         public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);


      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

      userService.add(new User("User5", "Lastname5", "user5@mail.ru", new Car("BMW", 1)));
      userService.add(new User("User6", "Lastname6", "user6@mail.ru", new Car("Audi", 2)));
      userService.add(new User("User7", "Lastname7", "user7@mail.ru", new Car("Mercedes-Benz", 3)));
      userService.add(new User("User8", "Lastname8", "user8@mail.ru", new Car("Ford", 4)));


      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = " + user.getId());
         System.out.println("First Name = " + user.getFirstName());
         System.out.println("Last Name = " + user.getLastName());
         System.out.println("Email = " + user.getEmail());
         System.out.println("Car Id = " + user.getUserCar());
         System.out.println();
      }


      Car car1 = new Car("BMW", 1);
      List<User> usersWithCar1 = userService.listUserByCarSpec(car1.getModel(), car1.getSeries());
      System.out.println(usersWithCar1);

      Car car2 = new Car("Audi", 2);
      List<User> usersWithCar2 = userService.listUserByCarSpec(car2.getModel(), car2.getSeries());
      System.out.println(usersWithCar2);

      Car car3 = new Car("Mercedes-Benz", 3);
      List<User> usersWithCar3 = userService.listUserByCarSpec(car3.getModel(), car3.getSeries());
      System.out.println(usersWithCar3);

      Car car4 = new Car("Ford", 4);
      List<User> usersWithCar4 = userService.listUserByCarSpec(car4.getModel(), car4.getSeries());
      System.out.println(usersWithCar4);

      context.close();
   }
}
