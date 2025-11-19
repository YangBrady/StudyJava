package me.yangjun.study.thread;

public class MyRequestContext {
    public static final ThreadLocal<String> TL_REQUEST_NAME = new ThreadLocal<>();
    public static final ThreadLocal<String> ITL_REQUEST_NAME = new InheritableThreadLocal<>();
}
