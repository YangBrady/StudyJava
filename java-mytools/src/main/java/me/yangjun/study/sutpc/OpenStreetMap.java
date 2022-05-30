package me.yangjun.study.sutpc;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.*;

/**
 * 处理从OpenStreetMap下载的原始数据，将抽取的数据输出为text文件
 *
 * @author Administrator
 */
public class OpenStreetMap {
	static String s = null;

	public static void main(String[] args) {
		SAXParserFactory saxfac = SAXParserFactory.newInstance();
		try {
			SAXParser saxparser = saxfac.newSAXParser();
			InputStream is = new FileInputStream("D:\\项目\\map");
			MySAXHandler handler = new MySAXHandler();
			saxparser.parse(is, handler);
			;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	//实现自己的解析方式
	static class MySAXHandler extends DefaultHandler {

		FileOutputStream fosPoint;
		FileOutputStream fosArc;
		OutputStreamWriter oswPoint;
		OutputStreamWriter oswArc;
		BufferedWriter bwPoint;
		BufferedWriter bwArc;

		//开始解析时调用
		public void startDocument() throws SAXException {
			// 点信息
			File pointFile = new File("D:\\项目\\mongo\\MapPre\\Point.txt");
			// 弧信息
			File arcFile = new File("D:\\项目\\mongo\\MapPre\\Arc.txt");
			try {
				fosPoint = new FileOutputStream(pointFile);
				fosArc = new FileOutputStream(arcFile);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			oswPoint = new OutputStreamWriter(fosPoint);
			oswArc = new OutputStreamWriter(fosArc);
			bwPoint = new BufferedWriter(oswPoint);
			bwArc = new BufferedWriter(oswArc);
			System.out.println("开始解析文档！");
		}

		//完成解析时调用
		public void endDocument() throws SAXException {
			try {
				bwPoint.close();
				oswPoint.close();
				fosPoint.close();
				bwArc.close();
				oswArc.close();
				fosArc.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("文档解析完成！");
		}

		/**
		 * 开始一个元素的解析
		 *
		 * @param uri
		 * @param localName
		 * @param qName      标签名
		 * @param attributes 属性
		 * @throws SAXException
		 */
		public void startElement(String uri, String localName, String qName,
								 Attributes attributes) throws SAXException {
			if ((attributes != null) && attributes.getLength() > 0) {
				if (qName.equals("node")) {
					StringBuilder sb = new StringBuilder();
					sb.append(attributes.getValue("id") + "      ");
					sb.append(attributes.getValue("lat") + "      ");
					sb.append(attributes.getValue("lon"));
					try {
						bwPoint.write(sb.toString() + "\r\n");
						bwPoint.flush();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(sb.toString());
				} else if (qName.equals("way")) {
					s = attributes.getValue("id") + "      "
							+ attributes.getValue("version") + "      ";
				} else if (qName.equals("nd")) {
					if (s == null)
						return;
					try {
						bwArc.write(s + attributes.getValue("ref") + "      \r\n");
						bwArc.flush();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(s + attributes.getValue("ref") + "      ");
				} else if (qName.equals("tag")) {
					if (s == null)
						return;
					try {
						bwArc.write(s + "      " + attributes.getValue("k") + "\r\n");
						bwArc.flush();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(s + "      " + attributes.getValue("k"));
				} else if (qName.equals("relation")) {
					if (s != null)
						s = null;
				}
			}
		}

		/**
		 * 结束一个元素的解析,遇到结束标签时调用此方法 通常在此方法对标签取值并处理
		 *
		 * @param uri
		 * @param localName
		 * @param qName
		 * @throws SAXException
		 */
		public void endElement(String uri, String localName, String qName)
				throws SAXException {

		}

		//该方法是获得元素间的text文本内容，可以通过new String(ch, start, length)来获得
		public void characters(char[] ch, int start, int length)
				throws SAXException {
			//            System.out.print(new String(ch, start, length));
		}
	}
}