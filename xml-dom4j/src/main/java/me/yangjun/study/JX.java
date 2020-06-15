package me.yangjun.study;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.Iterator;
import java.util.List;

public class JX {
	public static void main(String[] args) {
		JX a = new JX();
		// 使用相对路径或绝对路径都可以
		//a.parserXmlTest("src/me/yangjun/study/icbcHost.xml");
		a.readStr("src/me/yangjun/study/icbcHost.xml");
	}

	public void readStr(String xmlPath) {
		try {
			SAXReader reader = new SAXReader();
			Document doc = reader.read(xmlPath);
			Node icbcNode = doc.selectSingleNode("icbc");
			icbcNode.selectSingleNode("private");
			List<Node> books = icbcNode.selectNodes("book");
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Dom4j 解析XML文档
	 */
	public void parserXmlTest(String fileName) {
		File inputXml = new File(fileName);
		SAXReader saxReader = new SAXReader();

		try {
			Document document = saxReader.read(inputXml);
			Element users = document.getRootElement();
			for (Iterator<Element> i = users.elementIterator(); i.hasNext(); ) {
				Element user = (Element) i.next();
				for (Iterator<Element> j = user.elementIterator(); j.hasNext(); ) {
					Element node = (Element) j.next();
					System.out.println(node.getName() + ":" + node.getText());
				}
				System.out.println();
			}
		} catch (DocumentException e) {
			System.out.println(e.getMessage());
		}
	}

}