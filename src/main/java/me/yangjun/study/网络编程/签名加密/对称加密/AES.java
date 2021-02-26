package me.yangjun.study.网络编程.签名加密.对称加密;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

@Slf4j
public class AES {
    public static void main(String[] args) throws Exception {
        /*
         * 此处使用AES-128-ECB加密模式，key需要为16位。
         */
        String cKey = "1234567890123456";
        // 需要加密的字串
        String cSrc = "buxuewushu";
        log.info(cSrc);
        // 加密
        String enString = Encrypt(cSrc, cKey);
        log.info("加密后的字串是：" + enString);

        // 解密
        String DeString = Decrypt(enString, cKey);
        log.info("解密后的字串是：" + DeString);
    }

    // 加密
    private static String Encrypt(String sSrc, String sKey) throws Exception {
        if (sKey == null) {
            log.info("Key为空null");
            return null;
        }
        // 判断Key是否为16位
        if (sKey.length() != 16) {
            log.info("Key长度不是16位");
            return null;
        }
        byte[] raw = sKey.getBytes(StandardCharsets.UTF_8);
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");//"算法/模式/补码方式"
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
        byte[] encrypted = cipher.doFinal(sSrc.getBytes(StandardCharsets.UTF_8));

        return new Base64().encodeToString(encrypted);//此处使用BASE64做转码功能，同时能起到2次加密的作用。
    }

    // 解密
    private static String Decrypt(String sSrc, String sKey) throws Exception {
        try {
            // 判断Key是否正确
            if (sKey == null) {
                log.info("Key为空null");
                return null;
            }
            // 判断Key是否为16位
            if (sKey.length() != 16) {
                log.info("Key长度不是16位");
                return null;
            }
            byte[] raw = sKey.getBytes(StandardCharsets.UTF_8);
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec);
            byte[] encrypted1 = new Base64().decode(sSrc);//先用base64解密
            try {
                byte[] original = cipher.doFinal(encrypted1);
                return new String(original, StandardCharsets.UTF_8);
            } catch (Exception e) {
                log.info(e.toString());
                return null;
            }
        } catch (Exception ex) {
            log.info(ex.toString());
            return null;
        }
    }

}
