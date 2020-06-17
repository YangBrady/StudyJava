package me.yangjun.study.InterviewQuestions.p20200617;

import lombok.extern.slf4j.Slf4j;

/**
 * 求1+2+3+...+n的值，要求不能使用乘除法，for、while、if、else、switch、case、等关键字及条件判断语句
 * <p>
 * 采用递归和三目表达式注意红色字体一定不能写成n--
 *
 * @author mooejun
 * @since 2020/6/17 2:06 下午
 */
@Slf4j
public class SumTest {

    static int sum;

    public static int add(int n) {
        sum += n;
        sum = n == 0 ? sum : add(--n);
        log.info(String.valueOf(n));
        return sum;
    }

    public static void main(String[] args) {
        add(100);
        log.info("sum=" + sum);
    }
}
