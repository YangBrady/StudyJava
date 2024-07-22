package me.yangjun.study.流式编程;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import me.yangjun.study.common.po.UserPO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author mooejun
 * @since 2019/11/27
 */
@Slf4j
public class Demo {

    @Test
    public void test01() {
        Foo foo1 = new Foo(1, 2);
        Foo foo2 = new Foo(2, 23);
        Foo foo3 = new Foo(2, 6);
        List<Foo> list = new ArrayList<>(4);
        list.add(foo1);
        list.add(foo2);
        list.add(foo3);
        Map<Integer, IntSummaryStatistics> collect =
            list.stream().collect(Collectors.groupingBy(Foo::getCode, Collectors.summarizingInt(Foo::getCount)));
        IntSummaryStatistics statistics1 = collect.get(1);
        // IntSummaryStatistics statistics2 = collect.get(2);
        System.out.println(statistics1.getSum());
        System.out.println(statistics1.getAverage());
        System.out.println(statistics1.getMax());
        System.out.println(statistics1.getMin());
        System.out.println(statistics1.getCount());

        // System.out.println(statistics2.getSum());
        // System.out.println(statistics2.getAverage());
        // System.out.println(statistics2.getMax());
        // System.out.println(statistics2.getMin());
        // System.out.println(statistics2.getCount());
    }

    @Test
    public void test02() {
        List<Optional<Foo>> customers =
            Arrays.asList(Optional.of(new Foo(11, 18)), Optional.of(new Foo(22, 22)), Optional.empty(),
                Optional.of(new Foo(44, 21)), Optional.empty(), Optional.of(new Foo(55, 23)), Optional.empty());

        long numberOf65PlusCustomers =
            customers.stream().flatMap(c -> c.map(Stream::of).orElseGet(Stream::empty)).filter(c -> c.getCode() >= 33)
                .count();

        log.debug(numberOf65PlusCustomers + "");
    }

    @Test
    public void testGroup() {
        List<UserPO> userPOList = UserPO.genUserPOList(30);
        Map<Integer, List<UserPO>> collect = userPOList.stream().collect(Collectors.groupingBy(UserPO::getAge));
        log.info("map={}", collect);
    }

    @Test
    public void testGroupCount() {
        List<UserPO> userPOList = UserPO.genUserPOList(30);
        Map<String, Long> collect =
            userPOList.stream().collect(Collectors.groupingBy(UserPO::getSex, Collectors.counting()));
        log.info("map={}", collect);
    }

    @Test
    public void testGroupMax() {
        List<UserPO> userPOList = UserPO.genUserPOList(30);
        Map<String, Optional<UserPO>> collect = userPOList.stream()
            .collect(Collectors.groupingBy(UserPO::getSex, Collectors.maxBy(Comparator.comparing(UserPO::getAge))));
        log.info("map={}", collect);
    }

    @Test
    public void testGroupSum() {
        List<UserPO> userPOList = UserPO.genUserPOList(10);
        Map<String, Integer> collect =
            userPOList.stream().collect(Collectors.groupingBy(UserPO::getSex, Collectors.summingInt(UserPO::getAge)));
        log.info("map={}", collect);
    }

    @Test
    public void toMapNPE() {
        UserPO userPO1 = new UserPO();
        userPO1.setAge(1);
        userPO1.setName("A");

        UserPO userPO2 = new UserPO();
        userPO2.setAge(2);

        UserPO userPO3 = new UserPO();
        userPO3.setAge(2);
        userPO3.setName("C");

        ArrayList<UserPO> userPOList = Lists.newArrayList(userPO1, userPO2, userPO3);

        Assertions.assertThrows(NullPointerException.class, () -> {
            userPOList.stream().collect(Collectors.toMap(UserPO::getAge, UserPO::getName, (o1, o2) -> o1));
        });
    }
}
