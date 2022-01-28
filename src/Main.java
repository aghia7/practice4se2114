import db.DB;
import db.postgres.Postgres;
import models.User;
import repositories.EntityRepository;
import repositories.postgres.UserRepository;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        DB db = new Postgres();
        EntityRepository<User> repo = new UserRepository(db);

        while (true) {
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("Please, select option:");
            System.out.println("1. Create user");
            System.out.println("2. Get user by id");
            System.out.println("3. Get all users");
            System.out.println("4. Remove user by id");
            System.out.println("0. Exit");

            int option = sc.nextInt();

            if (option == 1) {
                createUser(repo);
            } else if (option == 2) {
                getUserById(repo);
            } else if (option == 3) {
                getAllUsers(repo);
            } else if (option == 4) {
                removeUserById(repo);
            } else {
                break;
            }
        }

        db.close();
    }

    private static void removeUserById(EntityRepository<User> repo) {
        System.out.println("Please, enter id:");
        int id = sc.nextInt();
        User user = repo.get(id);

        if (user == null) {
            System.out.println("User with id = " + id + " does not exist!");
            return;
        }

        boolean removed = repo.delete(id);
        if (removed)
            System.out.println("User '" + user + "' was removed successfully!");
        else
            System.out.println("User cannot be removed!");

        System.out.println("0. Exit");
        sc.nextInt();
    }

    private static void getAllUsers(EntityRepository<User> repo) {
        List<User> users = repo.getAll();

        for (User user : users)
            System.out.println(user);

        System.out.println("0. Exit");
        sc.nextInt();
    }

    private static void getUserById(EntityRepository<User> repo) {
        System.out.println("Please, enter id:");
        int id = sc.nextInt();
        User user = repo.get(id);

        if (user == null) {
            System.out.println("User with id = " + id + " does not exist!");
        } else {
            System.out.println(user);
        }

        System.out.println("0. Exit");
        sc.nextInt();
    }

    private static void createUser(EntityRepository<User> repo) {
        System.out.println("Enter name: ");
        String name = sc.next();
        System.out.println("Enter surname: ");
        String surname = sc.next();

        User user = new User(name, surname);
        boolean created = repo.create(user);

        if (created)
            System.out.println("A new user " + name + " " + surname + " was added successfully!");
        else
            System.out.println("User cannot be created");

        System.out.println("0. Exit");
        sc.nextInt();
    }
}
