package me.yangjun.study.InterviewQuestions.p20200617;

/**
 * @author mooejun
 * @since 2020/6/17 3:28 下午
 */
public class ClassTest {
    public static void main(String[] args) {
        A a = new C();
        a.doPrint();
    }
}

class A {
    public A() {
        System.out.println("A cons");
    }

    public void doPrint() {
        System.out.println("A print");
    }
}

class B extends A {
    public B() {
        System.out.println("B cons");
    }

    public void doPrint() {
        System.out.println("B print");
    }
}


class C extends B {
    public C() {
        System.out.println("C cons");
    }

    public void doPrint() {
        System.out.println("C print");
    }
}