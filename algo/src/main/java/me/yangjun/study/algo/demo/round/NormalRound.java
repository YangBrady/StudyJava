package me.yangjun.study.algo.demo.round;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 普通轮询
 */
public class NormalRound {
    @Getter
    @AllArgsConstructor
    public static final class RequestServer {
        private String name;
    }

    @Test
    public void test01() {
        List<RequestServer> serverList = new ArrayList<>();
        serverList.add(new RequestServer("A"));
        serverList.add(new RequestServer("B"));
        serverList.add(new RequestServer("C"));

        for (int i = 0; i < 10; i++) {
            System.out.println(serverList.get(i % serverList.size()).getName());
        }
    }
}
