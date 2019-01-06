package me.yangjun.modules.frame.spring.demo.di;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by yangjun on 2018/12/13.
 */
public class TestDemo {

	@Test
	public void testGetBean1() {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:spring/demo/di/bean.xml");

        System.out.println("----------");
		MalePerson malePerson1 = context.getBean("diMalePersonByIndex1", MalePerson.class);
		System.out.println(malePerson1);

		MalePerson malePerson2 = context.getBean("diMalePersonByType1", MalePerson.class);
		System.out.println(malePerson2);
		MalePerson malePerson3 = context.getBean("diMalePersonByType2", MalePerson.class);
		System.out.println(malePerson3);

		MalePerson malePerson4 = context.getBean("diMalePersonByName1", MalePerson.class);
		System.out.println(malePerson4);



        System.out.println("----------");
		MalePerson malePersonFactory1 = context.getBean("diMalePersonFactoryByIndex1", MalePerson.class);
		System.out.println(malePersonFactory1);

		MalePerson malePersonFactory2 = context.getBean("diMalePersonFactory2ByIndex1", MalePerson.class);
		System.out.println(malePersonFactory2);



        System.out.println("----------");
		MalePerson malePersonSetting1 = context.getBean("diMalePersonBySetting1", MalePerson.class);
		System.out.println(malePersonSetting1);
		MalePerson malePersonSetting2 = context.getBean("diMalePersonBySetting2", MalePerson.class);
		System.out.println(malePersonSetting2);
		MalePerson malePersonSetting3 = context.getBean("diMalePersonBySetting3", MalePerson.class);
		System.out.println(malePersonSetting3);



        System.out.println("----------");
        MalePerson malePersonSomething1 = context.getBean("diMalePersonSomething1", MalePerson.class);
        System.out.println(malePersonSomething1);
	}
}
