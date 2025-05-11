package me.yangjun.study.config.aop;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MethodExecuteResult {
    private boolean successFlag;
    private Exception throwable;
    private String str;
}
