package me.yangjun.modules.frame.xml解析.dom4j;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class GetDocument {
	public static void main(String[] args) {
		GetDocument gd = new GetDocument();
		//gd.readStr("<public><hostNmae>127.0.0.1</hostNmae><channel>测试渠道</channel><serialNumber>20180101</serialNumber></public>");
		gd.readXML("src/me/xml解析/dom4j/icbcHost.xml");
		//gd.read();
	}

	// 解析XML形式的文本,得到document对象
	public void readStr(String xmlStr) {
		try {
			Document document = DocumentHelper.parseText(xmlStr);
			System.out.println(document.asXML());
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	// 读取XML文件,获得document对象
	public void readXML(String filePath) {
		try {
			SAXReader reader = new SAXReader();
			Document document = reader.read(new File(filePath));
			System.out.println(document.asXML());
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	// 主动创建document对象
	public void read() {
		Document document = DocumentHelper.createDocument(); // 创建根节点
		Element root = document.addElement("public");
		System.out.println(document.asXML());
	}

}
