package me.yangjun.study;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * 使用Java自带的DOM解析XML
 *
 * @author yangjun
 */
public class DomParse {
	public static void main(String[] args) {
		// 第一步：创建DocumentBuilderFactory对象
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		try {
			// 第二步：创建DocumentBuilder对象
			DocumentBuilder db = dbf.newDocumentBuilder();

			// 第三步：调用DocumentBuilder的parse方法读取XML文件
			Document doc = db.parse("src/me/yangjun/study/myxml.xml");

			// 第四步：解析XML文件
			NodeList nodeList = doc.getElementsByTagName("author");
			for (int i = 0; i < nodeList.getLength(); i++) {
				System.out.println(nodeList.item(i).getFirstChild().getNodeValue());
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
