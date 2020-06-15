package me.yangjun.study.aop.xml;

public class UserDao implements IUser {

    @Override
    public void save() {
        System.out.println("DB:保存用户");
    }

}