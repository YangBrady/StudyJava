package me.yangjun.modules.frame.spring.demo.ioc.bean;

import org.junit.Test;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class TestDemo {

    @Test
    public void test01() {
        // 第1步：装载配置文件，并启动容器
        //Resource res = new ClassPathResource("classpath*:spring/demo/ioc/bean/bean.xml");
        Resource res = new ClassPathResource("spring/demo/ioc/bean/bean.xml");
        ConfigurableBeanFactory beanFactory = new XmlBeanFactory(res);

        // 第2步：向容器中注册MyBeanPostProcesser处理器
        beanFactory.addBeanPostProcessor(new MyBeanPostProcessor());
        // 第3步：向容器中注册MyInstantiationAwareBeanPostProcessor后处理器
        beanFactory.addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor());

        // 第4步：第一次从容器中获取car,将触发容器实例化该Bean,这将引发Bean生命周期方法的调用
        Car car1 = beanFactory.getBean("car", Car.class);
        System.out.println(car1);
        car1.setColor("红色");

        // 第5步：第二次从容器中获取car，直接从缓存池中取(因为 scope="singleton")
        Car car2 = beanFactory.getBean("car", Car.class);

        // 第6步：查看car1和car2是否指向同一引用
        System.out.println("car1==car2 " + (car1 == car2));

        // 第7步：关闭容器
        beanFactory.destroySingletons();
    }
}
