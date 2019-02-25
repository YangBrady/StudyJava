package me.yangjun.modules.frame.spring.demo.mvc.dto;

import java.util.List;

public class Department {
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
