package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    private Util util = new Util();
    private Connection connection = util.getConnection();
    private Statement statement;
    private ResultSet resultSet;

    public UserDaoJDBCImpl() {
    }

    public void createUsersTable() {
        try {
            statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE users (id INT  PRIMARY KEY AUTO_INCREMENT, name VARCHAR (30), lastName VARCHAR (30), age INT) ");
        } catch (SQLException s) {

        }

    }

    public void dropUsersTable() {
        try {
            statement = connection.createStatement();
            statement.executeUpdate("DROP TABLE users");
        } catch (SQLException s) {

        }

    }

    public void saveUser(String name, String lastName, byte age) {
        try {
            statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO users (name, lastName, age) VALUES (" + "'" + name + "'" + "," + "'" + lastName + "'" + "," + age + ")");
        } catch (SQLException s) {
            s.printStackTrace();
        }

    }

    public void removeUserById(long id) {
        try {
            statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM users WHERE id =" + id);
        } catch (SQLException s) {
            s.printStackTrace();
        }

    }

    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM users");

            while (resultSet.next()){
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastName"));
                user.setAge(resultSet.getByte("age"));

                list.add(user);
            }
        }catch(SQLException s){
            s.printStackTrace();
        }
        return list;
    }

    public void cleanUsersTable() {
        try{
            statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM users");
        }catch (SQLException s){
            s.printStackTrace();
        }

    }
}
