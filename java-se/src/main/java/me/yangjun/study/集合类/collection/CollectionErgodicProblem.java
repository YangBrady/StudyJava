package me.yangjun.study.集合类.collection;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Slf4j
public class CollectionErgodicProblem {
    private final List<String> list1 = new ArrayList<>();

    private void addData() {
        this.list1.add("abcd1");
        this.list1.add("abcd2");
        this.list1.add("abcd3");
        this.list1.add("abcd4");
        this.list1.add("abcd5");
    }

    /**
     * 遍历的时候修改原集合，remove方法会导致集合中其他元素的下标改变
     */
    @Test
    public void removeWhileErgodic_Error() {
        this.addData();
        log.info("" + this.list1.size()); // 5
        log.info("" + this.list1);// [abcd1, abcd2, abcd3, abcd4, abcd5]

        // 错误
        for (int i = 0; i < this.list1.size(); i++) {
            if ((this.list1.get(i)).startsWith("abcd")) {
                this.list1.remove(i);
            }
        }
        log.info("" + this.list1.size());// 2
        log.info("" + this.list1);// [abcd2, abcd4]
    }

    /**
     * 因此遍历的时候修改原集合不能用forEach，要用迭代器
     */
    @Test
    public void removeWhileErgodic() {
        this.addData();
        log.info("" + this.list1.size()); // 5
        log.info("" + this.list1);// [abcd1, abcd2, abcd3, abcd4, abcd5]

        // 正确
        Iterator<String> it = this.list1.iterator();
        while (it.hasNext()) {
            if (it.next().startsWith("abcd")) {
                it.remove();
            }
        }
        log.info("" + this.list1.size());// 0
        log.info("" + this.list1);// []
    }
}
