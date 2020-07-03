package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {

        UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();
        userDaoJDBC.createUsersTable();
        System.out.println("Таблица создана");

        User user1 = new User("Solomon", "Kane", (byte) 30);
        User user2 = new User("Charlie", "Chaplin" , (byte) 60);
        User user3 = new User("Oleg", "Olegov", (byte) 54);
        User user4 = new User("Bruce", "Li", (byte) 21);

        userDaoJDBC.saveUser(user1.getName(), user1.getLastName(), user1.getAge());
        System.out.println("User " + user1.getName() + " добавлен в базу данных");
        userDaoJDBC.saveUser(user2.getName(), user2.getLastName(), user2.getAge());
        System.out.println("User " + user2.getName() + " добавлен в базу данных");
        userDaoJDBC.saveUser(user3.getName(), user3.getLastName(), user3.getAge());
        System.out.println("User " + user3.getName() + " добавлен в базу данных");
        userDaoJDBC.saveUser(user4.getName(), user4.getLastName(), user4.getAge());
        System.out.println("User " + user4.getName() + " добавлен в базу данных");

        List<User> userList = new ArrayList<>();
        userList = userDaoJDBC.getAllUsers();
        System.out.println(userList);

        userDaoJDBC.cleanUsersTable();
        userDaoJDBC.dropUsersTable();

    }
}
