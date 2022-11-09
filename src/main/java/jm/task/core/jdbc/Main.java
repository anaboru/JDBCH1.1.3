package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl usi = new UserServiceImpl();
        usi.createUsersTable();
        List<User> userList = new ArrayList<>();
        userList.add(new User("Иван", "Иванов", (byte) 11));
        userList.add(new User("Роман", "Романов", (byte) 22));
        userList.add(new User("Игорь", "Игорев", (byte) 33));
        userList.add(new User("Пётр", "Петров", (byte) 44));
        userList.forEach(us -> usi.saveUser(us.getName(), us.getLastName(), us.getAge()));
        System.out.println(usi.getAllUsers());
        usi.cleanUsersTable();
        usi.dropUsersTable();
    }
}