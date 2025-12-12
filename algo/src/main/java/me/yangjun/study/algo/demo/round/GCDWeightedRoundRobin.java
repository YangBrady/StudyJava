package me.yangjun.study.algo.demo.round;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 加权轮询算法 - 最大公约数
 */
public class GCDWeightedRoundRobin {
    private final List<RequestServer> serverList = new ArrayList<>();
    private int maxWeight;

    public void addServer(RequestServer server) {
        serverList.add(server);

        maxWeight = Math.max(server.weight, maxWeight);
    }

    public List<RequestServer> foo() {
        int[] weightArray = serverList.stream().map(RequestServer::getWeight).mapToInt(Integer::valueOf).toArray();

        // 最大公约数
        int gcd = gcd(weightArray);

        // 简化权重
        List<Integer> unitWeightList = serverList.stream().map(RequestServer::getWeight).map(o -> o / gcd)
                .mapToInt(Integer::valueOf).boxed().collect(Collectors.toList());

        List<RequestServer> result = new ArrayList<>();
        boolean reset = false;
        while (!reset) {
            for (int i = 0; i < unitWeightList.size(); i++) {
                Integer unitWeight = unitWeightList.get(i);
                if (unitWeight > 0) {
                    result.add(this.serverList.get(i));
                    unitWeightList.set(i, unitWeight - 1);
                }
            }
            // 重置
            reset = unitWeightList.stream().allMatch(o -> o == 0);
        }
        return result;
    }

    // 多个数的GCD
    public static int gcd(int... numbers) {
        if (numbers.length == 0)
            return 0;

        int result = Math.abs(numbers[0]);
        for (int i = 1; i < numbers.length; i++) {
            result = gcdRecursive(result, Math.abs(numbers[i]));
        }
        return result;
    }

    /**
     * 通过递归获取两个数的最大公约数
     */
    public static int gcdRecursive(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcdRecursive(b, a % b);
    }

    @Getter
    @AllArgsConstructor
    public static final class RequestServer {
        private String name;
        private int weight;
    }

    @Test
    public void test01() {
        GCDWeightedRoundRobin gcdWRR = new GCDWeightedRoundRobin();
        gcdWRR.addServer(new RequestServer("A", 4));
        gcdWRR.addServer(new RequestServer("B", 6));
        gcdWRR.addServer(new RequestServer("C", 2));
        gcdWRR.addServer(new RequestServer("D", 6));

        List<RequestServer> rsl = gcdWRR.foo();
        for (RequestServer rs : rsl) {
            System.out.println(rs.getName());
        }
    }
}
