package seconddz;

import java.sql.DriverManager;
import java.sql.Connection;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class MainRepository {
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "998123";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/testdbBarkov";
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        UserRepository userRepository = new UserRepositoryJDBCImpl(conn);

        System.out.println("Введите число пользователей, которых хотите ввести");
        int number = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < number; i++) {
            System.out.println("Введите данные пользователя:");

            System.out.print("Имя: ");
            String firstName = scanner.nextLine();

            System.out.print("Фамилия: ");
            String secondName = scanner.nextLine();

            System.out.print("Возраст: ");
            int age = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Email: ");
            String email = scanner.nextLine();

            System.out.print("Пароль: ");
            String passwordInput = scanner.nextLine();

            System.out.print("Роль: ");
            String role = scanner.nextLine();

            User user = new User(null, firstName, secondName, age, email, passwordInput, role);

            userRepository.save(user);
            System.out.println("Пользователь успешно добавлен!");
        }



        List<User> usersByAge = userRepository.findByAge(228);
        usersByAge.stream().map(User::getFirstName)
                .forEach(System.out::println);

        List<User> usersByPassword = userRepository.findByPassword("123");
        usersByPassword.stream().map(User::getFirstName)
                .forEach(System.out::println);

        List<User> usersByRole = userRepository.findByRole("admin");
        usersByRole.stream().map(User::getFirstName)
                .forEach(System.out::println);

        List<User> usersByEmail = userRepository.findByEmail("khas@gmail.com");
        usersByEmail.stream().map(User::getFirstName)
                .forEach(System.out::println);

        Optional<User> userOpt = userRepository.findById(8L);
        userOpt.stream().map(User::getFirstName)
                .forEach(System.out::println);

        if (userOpt.isPresent()) {
            User userToUpdate = userOpt.get();
            userToUpdate = new User(userToUpdate.getId(), "Susel", "Duzel", 22,  userToUpdate.getEmail(), userToUpdate.getPassword(), userToUpdate.getRole());
            userRepository.update(userToUpdate);
        }

        userRepository.removeById(8);


        User user = new User(null, "aboba", "amogus", 100, "ion", "12543", "jigga");

        userRepository.save(user);

        System.out.println(userRepository.findByEmail("ion"));

        userRepository.delete(user);

        System.out.println(userRepository.findByEmail("ion"));


    }
}
