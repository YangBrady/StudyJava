package me.yangjun.study.config;

import java.util.Objects;

public class ReqContext {
    private static final ThreadLocal<Boolean> decorationTag = new ThreadLocal<>();

    public static void setDecoration() {
        decorationTag.set(true);
    }

    public static boolean getDecoration() {
        return Objects.nonNull(decorationTag.get()) && decorationTag.get();
    }
}
