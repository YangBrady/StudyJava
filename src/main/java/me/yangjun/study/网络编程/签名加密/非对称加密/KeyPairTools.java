package me.yangjun.study.网络编程.签名加密.非对称加密;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import java.nio.charset.StandardCharsets;
import java.security.*;

@Slf4j
public class KeyPairTools {

    private static final String RSA_ALGORITHM = "RSA";

    public static void main(String[] args) throws Exception {
        KeyPair keyPair = buildKeyPair();

        byte[] encryptData = encrypt(keyPair.getPublic(), "不学无术");
        log.info(String.format("加密后的数据：%s", Base64.encodeBase64String(encryptData)));
        log.info(String.format("解密后的数据：%s", new String(decrypt(keyPair.getPrivate(), encryptData), StandardCharsets.UTF_8)));

        String context = "加签的字符串";
        String sign = signWithRSA(context, keyPair.getPrivate());
        log.info(String.format("生成的签名：%s", sign));
        boolean checkSignWithRSA = checkSignWithRSA(context, keyPair.getPublic(), sign);
        log.info(String.format("校验的结果：%s", Boolean.toString(checkSignWithRSA)));
    }


    /**
     * 生成密钥对
     */
    public static KeyPair buildKeyPair() throws NoSuchAlgorithmException {
        final int keySize = 2048;
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(RSA_ALGORITHM);
        keyPairGenerator.initialize(keySize);
        return keyPairGenerator.genKeyPair();
    }

    /**
     * 加密
     */
    public static byte[] encrypt(PublicKey publicKey, String message) throws Exception {
        Cipher cipher = Cipher.getInstance(RSA_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return cipher.doFinal(message.getBytes(StandardCharsets.UTF_8));
    }


    /**
     * 解密
     */
    public static byte[] decrypt(PrivateKey privateKey, byte[] encrypted) throws Exception {
        Cipher cipher = Cipher.getInstance(RSA_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, privateKey);

        return cipher.doFinal(encrypted);
    }

    /**
     * 签名
     */
    private static String signWithRSA(String content, PrivateKey privateKey) throws Exception {
        Signature signature = Signature.getInstance("SHA1WithRSA"); // 用SHA算法进行签名，用RSA算法进行加密
        signature.initSign(privateKey);
        signature.update(content.getBytes(StandardCharsets.UTF_8));
        byte[] signed = signature.sign();
        return Base64.encodeBase64String(signed);
    }

    /**
     * 验签
     */
    private static boolean checkSignWithRSA(String content, PublicKey publicKey, String sign) throws Exception {
        Signature signature = Signature.getInstance("SHA1WithRSA");
        signature.initVerify(publicKey);
        signature.update(content.getBytes(StandardCharsets.UTF_8));
        return signature.verify(Base64.decodeBase64(sign));
    }

}
