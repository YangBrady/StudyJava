package jrebel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.swing.*;

public class JrebelMain {

    private static final String url =
        "https://headless.zeroturnaround.com/public/api/registrations/add-jrebel-evaluation.php";

    public static void main(String[] args) {

        JFrame jf = new JFrame("JrebelEvaluation");
        jf.setSize(240, 320);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 100, 5));

        JButton button = new JButton();
        button.setText("Get License");
        button.addActionListener(new JrebelMain.ButtonClick());
        panel.add(button);

        jf.setContentPane(panel);
        jf.setVisible(true);
    }

    public static int randNumber(int max, int min) {
        return min + (int)(Math.random() * (max - min + 1));
    }

    public static String uuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static String subText(String source, String startText, String endText, int offSet) {
        int start = source.indexOf(startText, offSet) + 1;
        if (start == -1) {
            return null;
        }
        int end = source.indexOf(endText, start + startText.length() - 1);
        if (end == -1) {
            end = source.length();
        }
        return source.substring(start + startText.length() - 1, end);
    }

    static class ButtonClick implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                action();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private static void action() throws Exception {
        final File jrebelHome = new File(System.getProperty("user.home") + "/.jrebel");
        final String[] jrebelFiless = new String[] {"jrebel.prefs", "jrebel.prefs.lock", "jrebel.properties"};

        Arrays.stream(jrebelFiless).map(it -> new File(jrebelHome.getAbsolutePath() + "/" + it)).filter(File::exists)
            .forEach(File::delete);

        StringBuilder phone = new StringBuilder();
        for (int i = 0; i < randNumber(6, 11); i++) {
            phone.append(randNumber(0, 9));
        }

        Map<String, Object> body = new HashMap<>();
        body.put("referer_url", "IDE");
        body.put("email", uuid() + "%40qq.com");
        body.put("first_name", uuid().substring(0, randNumber(3, 5)));
        body.put("last_name", uuid().substring(0, randNumber(3, 6)));
        body.put("phone", phone.toString());
        body.put("organization", uuid().substring(0, randNumber(1, 5)));
        body.put("output_format", "json");
        body.put("client_os", "Windows+11");
        body.put("guid", uuid());
        body.put("jrebel-version", "2023.1.2");
        body.put("ide", "intellij");
        body.put("ide-product", "IU");
        body.put("ide-version", "2022.3.3");
        body.put("jvm.version", "17.0." + randNumber(0, 20));
        body.put("jvm.vendor", "JetBrains+s.r.o");
        body.put("os.name", "Windows+11");

        // 构建查询参数
        StringBuilder queryBuilder = new StringBuilder();
        for (Map.Entry<String, Object> entry : body.entrySet()) {
            if (queryBuilder.length() > 0) {
                queryBuilder.append("&");
            }
            queryBuilder.append(URLEncoder.encode(entry.getKey(), "UTF-8")).append("=")
                .append(URLEncoder.encode(entry.getValue().toString(), "UTF-8"));
        }

        // 使用 HttpURLConnection 发送 GET 请求
        URI uri = URI.create(url + "?" + queryBuilder.toString());
        java.net.HttpURLConnection connection = (java.net.HttpURLConnection)uri.toURL().openConnection();
        connection.setRequestMethod("GET");
        connection.setDoInput(true);

        InputStream inputStream;
        if (connection.getResponseCode() >= 400) {
            inputStream = connection.getErrorStream();
        } else {
            inputStream = connection.getInputStream();
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }

        String ret = response.toString();
        String content = subText(ret, "content\":\"", "\"", 0);
        System.out.println(content);

        byte[] bin = Base64.getMimeDecoder().decode(content);
        File jrebelLicFile = new File(jrebelHome.getAbsolutePath() + "/jrebel.lic");
        FileOutputStream jrebelLicOutputStream = new FileOutputStream(jrebelLicFile);
        jrebelLicOutputStream.write(bin);
        jrebelLicOutputStream.flush();
        jrebelLicOutputStream.close();

        FileOutputStream jrebelPropertiesOutputStream =
            new FileOutputStream(jrebelHome.getAbsolutePath() + "/jrebel.properties");
        jrebelPropertiesOutputStream.write(("rebel.license=" + jrebelLicFile.getAbsolutePath() + "\r\n").getBytes());
        jrebelPropertiesOutputStream.write(("rebel.preferred.license=0\r\n").getBytes());
        jrebelPropertiesOutputStream.write(("rebel.properties.version=2\r\n").getBytes());
        jrebelPropertiesOutputStream.flush();
        jrebelPropertiesOutputStream.close();

        JOptionPane.showMessageDialog(null, "please restart idea ,  license :  \n" + jrebelLicFile.getAbsolutePath());
    }
}
