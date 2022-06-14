package me.yangjun.study.流式编程;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
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
        Map<Integer, IntSummaryStatistics> collect = list.stream().collect(Collectors.groupingBy(Foo::getCode,
                Collectors.summarizingInt(Foo::getCount)));
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
        List<Optional<Foo>> customers = Arrays.asList(
                Optional.of(new Foo(11, 18)),
                Optional.of(new Foo(22, 22)),
                Optional.empty(),
                Optional.of(new Foo(44, 21)),
                Optional.empty(),
                Optional.of(new Foo(55, 23)),
                Optional.empty()
        );

        long numberOf65PlusCustomers = customers
                .stream()
                .flatMap(c -> c
                        .map(Stream::of)
                        .orElseGet(Stream::empty))
                .filter(c -> c.getCode() >= 33)
                .count();

        log.debug(numberOf65PlusCustomers + "");
    }
}
