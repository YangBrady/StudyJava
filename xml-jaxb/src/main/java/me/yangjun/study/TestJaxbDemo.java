package me.yangjun.study;

import me.yangjun.study.bean.Cat;
import me.yangjun.study.bean.PersonBean;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.util.ArrayList;
import java.util.List;

public class TestJaxbDemo {

    @Test
    public void testDemo001() throws JAXBException {
        PersonBean p1 = new PersonBean();
        p1.setMale(true);
        p1.setName("asd");
        List<Cat> cats = new ArrayList<Cat>();
        Cat c1 = new Cat("cat1", 3, "fish");
        Cat c2 = new Cat("cat2", 4, "fish");
        Cat c3 = new Cat("cat3", 5, "fish");
        p1.setAnimals(cats);
        Cat[] catsArr = new Cat[]{c1,c2,c3};
        p1.setCats(catsArr);


        /* init jaxb marshaler */
        JAXBContext jaxbContext = JAXBContext.newInstance(PersonBean.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        /* set this flag to true to format the output */
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.setProperty(Marshaller.JAXB_ENCODING, "utf-8");
        jaxbMarshaller.setProperty(Marshaller.JAXB_FRAGMENT, false);

        /* marshaling of java objects in xml (output to file and standard output) */
        //StringWriter sw = new StringWriter();
        //jaxbMarshaller.marshal(p1, sw);
        jaxbMarshaller.marshal(p1, System.out);
        //System.out.println("sw=" + sw);

    }
}
