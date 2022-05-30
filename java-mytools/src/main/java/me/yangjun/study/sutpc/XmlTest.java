package me.yangjun.study.sutpc;

import cn.hutool.core.collection.CollectionUtil;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Objects;

public class XmlTest {
    public static void main(String[] args) throws Exception {
        // delete();
        fixContractPoint();
    }

    public static void delete() throws Exception {
        SAXReader reader = new SAXReader();
        Document document = reader.read(new File("C:\\Users\\Administrator\\Desktop\\test_futian2.xml"));
        Element root = document.getRootElement();

        List<Element> roads = root.elements("road");
        for (Element road : roads) {
            Element objects = road.element("objects");
            road.remove(objects);
        }

        // 格式化输出流，同时指定编码格式。也可以在FileOutputStream中指定。
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("utf-8");

        XMLWriter writer =
                new XMLWriter(new FileOutputStream("C:\\Users\\Administrator\\Desktop\\test_futian2-2.xml"), format);
        writer.write(document);
        writer.close();
    }

    public static void fixContractPoint() throws Exception {
        SAXReader reader = new SAXReader();
        Document document = reader.read(new File("C:\\Users\\Administrator\\Desktop\\Futian20210114.xml"));
        Element root = document.getRootElement();

        List<Element> roads = root.elements("road");
        for (Element road : roads) {
            Element link = road.element("link");
            if (!Objects.isNull(link) && CollectionUtil.isNotEmpty(link.elements())) {
                Element predecessor = link.element("predecessor");
                if (handleLinkPredecessor(predecessor)) {
                    System.out.println(road.attribute("id").getText());
                }
                Element successor = link.element("successor");
                if (handleLinkSuccessor(successor)) {
                    System.out.println(road.attribute("id").getText());
                }
            }
        }

        // 格式化输出流，同时指定编码格式。也可以在FileOutputStream中指定。
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("utf-8");

        XMLWriter writer =
                new XMLWriter(new FileOutputStream("C:\\Users\\Administrator\\Desktop\\Futian20210114-1.xml"), format);
        writer.write(document);
        writer.close();
    }

    public static boolean handleLinkPredecessor(Element ssor) {
        if (!Objects.isNull(ssor)) {
            Attribute contactPoint = ssor.attribute("contactPoint");
            if (Objects.isNull(contactPoint)) {
                ssor.addAttribute("contactPoint", "start");
                return true;
            }
        }
        return false;
    }

    public static boolean handleLinkSuccessor(Element ssor) {
        if (!Objects.isNull(ssor)) {
            Attribute contactPoint = ssor.attribute("contactPoint");
            if (Objects.isNull(contactPoint)) {
                ssor.addAttribute("contactPoint", "end");
                return true;
            }
        }
        return false;
    }
}
