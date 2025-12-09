package com.example.demo.round;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import lombok.Setter;
import org.junit.jupiter.api.Test;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 平滑加权轮询算法
 *
 * <p>
 * 计算总权重 <br>
 * 每个服务器记录一个当前权重 <br>
 * 遍历服务器，挨个将 当前权重-总权重 <br>
 * 设置当前权重 += 自己的权重 <br>
 * 直至当前权重列表都是0
 * </p>
 */
public class SmoothWeightedRoundRobin {
    private final List<RequestServer> serverList = new ArrayList<>();

    public void addServer(RequestServer server) {
        serverList.add(server);
        server.setCurrentWeight(server.getWeight());
    }

    public List<RequestServer> foo() {
        List<RequestServer> result = new ArrayList<>();
        boolean reset = false;
        while (!reset) {
            serverList.sort(Comparator.comparing(RequestServer::getCurrentWeight).reversed());
            RequestServer server = serverList.get(0);

            int totalWeight = serverList.stream().mapToInt(RequestServer::getCurrentWeight).sum();
            server.setCurrentWeight(server.getCurrentWeight() - totalWeight);

            // 重置
            reset = serverList.stream().allMatch(o -> o.getCurrentWeight() == 0);

            serverList.forEach(o -> {
                o.setCurrentWeight(o.getCurrentWeight() + o.getWeight());
                System.out.println(o.getName() + ":" + o.getCurrentWeight());
            });

            System.out.println("------");
        }
        return result;
    }

    @Getter
    @Setter
    public static final class RequestServer {
        private String name;
        private int weight;
        private int currentWeight = 0;

        public RequestServer(String name, int weight) {
            this.name = name;
            this.weight = weight;
        }
    }

    @Test
    public void test01() {
        SmoothWeightedRoundRobin sWRR = new SmoothWeightedRoundRobin();
        sWRR.addServer(new RequestServer("A", 4));
        sWRR.addServer(new RequestServer("B", 6));
        sWRR.addServer(new RequestServer("C", 2));
        sWRR.addServer(new RequestServer("D", 6));

        List<RequestServer> rsl = sWRR.foo();
        for (RequestServer rs : rsl) {
            System.out.println(rs.getName());
        }
    }
}
