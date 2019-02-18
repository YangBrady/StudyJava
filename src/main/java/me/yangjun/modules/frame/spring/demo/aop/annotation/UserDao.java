package me.yangjun.modules.frame.spring.demo.aop.annotation;

import org.springframework.stereotype.Component;

@Component
public class UserDao implements IUser {

    @Override
    public void save() {
        System.out.println("DB:保存用户");
    }

}