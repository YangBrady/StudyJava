package me.yangjun.modules.security;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;

import org.junit.Test;

public class SignatureDemo {

	// 获取私钥
	@Test
	public void getKey() {
		try {
			// 实例化KeyPairGenerator对象
			// KeyPairGenerator keyPairGeneratorRSA = KeyPairGenerator.getInstance("RSA");
			KeyPairGenerator keyPairGeneratorDSA = KeyPairGenerator.getInstance("DSA");
			// 初始化KeyPairGenerator对象
			keyPairGeneratorDSA.initialize(1024);
			// 生成KeyPair对象
			KeyPair keyPair = keyPairGeneratorDSA.genKeyPair();
			// 获得私钥密钥字节数组
			byte[] keyBytes = keyPair.getPrivate().getEncoded();
			// 由私钥密钥字节数组获取密钥规范
			PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(keyBytes);
			// 实例化密钥工厂
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			// 生成私钥
			Key privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			e.printStackTrace();
		}
	}

	// 签名
	@Test
	public void doSignature() {
		// 私钥签名
		byte[] data = "Data Signature".getBytes();
		KeyPairGenerator keyPairGen;
		try {
			keyPairGen = KeyPairGenerator.getInstance("DSA");
			keyPairGen.initialize(1024);
			KeyPair keyPair = keyPairGen.genKeyPair();
			// 实例化Signature
			Signature signature = Signature.getInstance(keyPairGen.getAlgorithm());
			// 初始化用于签名操作的Signature对象
			signature.initSign(keyPair.getPrivate());// 用私钥签名
			// 更新
			signature.update(data);
			// 获取签名
			byte[] sign = signature.sign();
			System.out.println(sign.toString());
		} catch (NoSuchAlgorithmException | InvalidKeyException | SignatureException e) {
			e.printStackTrace();
		}
	}
}
