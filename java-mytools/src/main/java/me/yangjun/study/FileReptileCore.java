package me.yangjun.study;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Node;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class FileReptileCore {
    public static void main(String[] args) {
        try {
            //34个省市县的编码
            String code = "553303";

            String[] codeArr = code.split(";");
            Map<String, List<String>> cityLevelCode = new HashMap<>();
            //基础的访问网址
            String baseUrl = "https://www.openstreetmap.org/relation/";

            for (int i = 0; i < codeArr.length; i++) {
                //输出当前正在爬取的省份编码
                log.info("===========开始输出：" + codeArr[i]);
                String url = baseUrl + codeArr[i];
                org.jsoup.nodes.Document doc = Jsoup.connect(url).ignoreContentType(true).timeout(30000).get();
                //获取节点数据
                List<Node> relationNodeList =
                        doc.body().childNodes().get(3).childNodes().get(1).childNodes().get(9).childNodes().get(3).childNodes()
                                .get(17).childNodes();
                int size = relationNodeList.size();
                List<String> cityCode = new ArrayList<>();
                //循环读取市级节点
                for (int j = 0; j < size; j++) {
                    Node node = relationNodeList.get(j);
                    if (node.toString().equals(" ")) {
                        continue;
                    }
                    String value = node.childNodes().get(1).attributes().get("href");
                    if (value.contains("relation")) {
                        String relationCode = value.split("/")[2];
                        cityCode.add(relationCode);
                        System.out.println(relationCode);
                    }
                }
                cityLevelCode.put(codeArr[i], cityCode);
            }
            //根据市级节点的code，获得县级的code
            for (Map.Entry province : cityLevelCode.entrySet()) {
                List<String> cityCodeArr = (List<String>) province.getValue();
                int cityCodeArrsize = cityCodeArr.size();
                for (int a = 0; a < cityCodeArrsize; a++) {
                    log.info("===========开始输出：" + cityCodeArr.get(a));
                    String url = baseUrl + cityCodeArr.get(a);
                    org.jsoup.nodes.Document doc = Jsoup.connect(url).ignoreContentType(true).timeout(30000).get();
                    List<Node> relationNodeList =
                            doc.body().childNodes().get(3).childNodes().get(1).childNodes().get(9).childNodes().get(3).childNodes()
                                    .get(17).childNodes();
                    int size = relationNodeList.size();
                    for (int j = 0; j < size; j++) {
                        Node node = relationNodeList.get(j);
                        if (node.toString().equals(" ")) {
                            continue;
                        }
                        String value = node.childNodes().get(1).attributes().get("href");
                        if (value.contains("relation")) {
                            String relationCode = value.split("/")[2];
                            System.out.println(relationCode);
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
