package me.yangjun.study.vo;

import lombok.Data;

@Data
public class MyResult<T> {
    int code;
    String msg;
    T data;

    public static <T> MyResult<T> success(T data) {
        MyResult<T> result = new MyResult<>();
        result.setCode(0);
        result.setMsg("success");
        result.setData(data);
        return result;
    }

    public static <T> MyResult<T> fail(String msg) {
        MyResult<T> result = new MyResult<>();
        result.setCode(1);
        result.setMsg(msg);
        return result;
    }
}
