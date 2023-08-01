package me.yangjun.study.集合类.collection.list;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>描述：List截断导致OOM问题</p>
 *
 * @author: Brady Yang
 * @date: 2023/8/2  0:27
 */
@Slf4j
public class SubListOOMTest {
    @Test
    void testSubListError() {
        // 将vm调整一下 -Xms20m -Xmx40m
        List<String> testList = new ArrayList<>();
        testList.add("aa");
        testList.add("bb");
        testList.add("cc");
        testList.add("ee");
        testList.add("ff");
        testList.add("gg");

        // subList强引用testList，如果subList不回收的话，testList也不会回收，如果testList特别大，就会导致OOM
        List<String> subList = testList.subList(0, 1);
    }

    @Test
    void testSubList() {
        // 将vm调整一下 -Xms20m -Xmx40m
        List<String> testList = new ArrayList<>();
        testList.add("aa");
        testList.add("bb");
        testList.add("cc");
        testList.add("ee");
        testList.add("ff");
        testList.add("gg");

        // 建议方式1
        List<String> subList1 = new ArrayList<>(testList.subList(0, 1));
        // 建议方式2
        List<String> subList2 = testList.stream().skip(0).limit(1).collect(Collectors.toList());
    }
}
