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
//		byte[] data = "Data Signature".getBytes();
		String temp = "Data Signaturesssssssssssssssssssssssssssssssssssssssssssss返回一个指定方法的 Cipher 对象\n" + "\n"
				+ "参数 :transformation 方法名 ( 可用 DES,DESede,Blowfish)\n" + "\n"
				+ "public final void init(int opmode, java.security.Key key) \n"
				+ "throws java.security.InvalidKeyException\n" + "\n" + "用指定的密钥和模式初始化 Cipher 对象\n" + "\n"
				+ "参数 :opmode 方式 (ENCRYPT_MODE, DECRYPT_MODE, WRAP_MODE,UNWRAP_MODE)\n" + "\n" + "key 密钥\n" + "\n"
				+ "public final byte[] doFinal(byte[] input) \n"
				+ "                     throws java.lang.IllegalStateException, \n"
				+ "                            IllegalBlockSizeException, \n"
				+ "                            BadPaddingException\n"
				+ "对 input 内的串 , 进行编码处理 , 返回处理后二进制串 , 是返回解密文还是加解文由 init 时的 opmode 决定\n" + "\n"
				+ "注意 : 本方法的执行前如果有 update, 是对 updat 和本次 input 全部处理 , 否则是本 inout 的内容\n" + "\n" + "/* \n"
				+ "安全程序 DESede/DES 测试\n" + " */ \n" + " import java.security.*; \n" + " import javax.crypto.*; \n"
				+ " public class testdes { \n" + " public static void main(String[] args){ \n"
				+ "    testdes my=new testdes(); \n" + "    my.run(); \n" + "  } \n" + " public  void run() { \n"
				+ " // 添加新安全算法 , 如果用 JCE 就要把它添加进去\n" + " Security.addProvider(new com.sun.crypto.provider.SunJCE()); \n"
				+ " String Algorithm=\"DES\"; // 定义 加密算法 , 可用 DES,DESede,Blowfish \n" + " String myinfo=\"要加密的信息\"; \n"
				+ "   try { \n" + "   // 生成密钥\n" + "   KeyGenerator keygen = KeyGenerator.getInstance(Algorithm); \n"
				+ "   SecretKey deskey = keygen.generateKey(); \n" + "   // 加密\n"
				+ "   System.out.println(\"加密前的二进串 :\"+byte2hex(myinfo.getBytes())); \n"
				+ "   System.out.println(\"加密前的信息 :\"+myinfo); \n" + "   Cipher c1 = Cipher.getInstance(Algorithm); \n"
				+ "   c1.init(Cipher.ENCRYPT_MODE,deskey); \n"
				+ "   byte[] cipherByte=c1.doFinal(myinfo.getBytes()); \n"
				+ "    System.out.println(\"加密后的二进串 :\"+byte2hex(cipherByte)); \n" + "   // 解密\n"
				+ "   c1 = Cipher.getInstance(Algorithm); \n" + "   c1.init(Cipher.DECRYPT_MODE,deskey); \n"
				+ "   byte[] clearByte=c1.doFinal(cipherByte); \n"
				+ "   System.out.println(\"解密后的二进串 :\"+byte2hex(clearByte)); \n"
				+ "   System.out.println(\"解密后的信息 :\"+(new String(clearByte))); \n" + "  } \n"
				+ "   catch (java.security.NoSuchAlgorithmException e1) {e1.printStackTrace();} \n"
				+ "   catch (javax.crypto.NoSuchPaddingException e2) {e2.printStackTrace();} \n"
				+ "   catch (java.lang.Exception e3) {e3.printStackTrace();} \n" + "  } \n"
				+ " public String byte2hex(byte[] b) // 二行制转字符串\n" + "    { \n" + "     String hs=\"\"; \n"
				+ "     String stmp=\"\"; \n" + "     for (int n=0;n<b.length;n++) \n" + "      { \n"
				+ "       stmp=(java.lang.Integer.toHexString(b[n] & 0XFF)); \n"
				+ "       if (stmp.length()==1) hs=hs+\"0\"+stmp; \n" + "       else hs=hs+stmp; \n"
				+ "       if (n<b.length-1)  hs=hs+\":\"; \n" + "      } \n" + "     return hs.toUpperCase(); \n"
				+ "    } \n" + " }\n" + "2.5. Diffie-Hellman 密钥一致协议\n"
				+ "公开密钥密码体制的奠基人 Diffie 和 Hellman 所提出的 \"指数密钥一致协议\"(Exponential Key Agreement Protocol), 该协议不要求别的安全性 先决条件 , 允许两名用户在公开媒体上交换信息以生成\"一致\"的 , 可以共享的密钥。在 JCE 的中实现用户 alice 生成 DH 类型的密钥对 , 如果长度用 1024 生成的时间请 , 推荐第一次生成后保存 DHParameterSpec, 以便下次使用直接初始化 . 使其速度加快\n"
				+ "\n" + "System.out.println(\"ALICE: 产生 DH 对 ...\"); \n"
				+ " KeyPairGenerator aliceKpairGen = KeyPairGenerator.getInstance(\"DH\"); \n"
				+ " aliceKpairGen.initialize(512); \n" + " KeyPair aliceKpair = aliceKpairGen.generateKeyPair();\n"
				+ "alice 生成公钥发送组 bob\n" + "\n" + "byte[] alicePubKeyEnc = aliceKpair.getPublic().getEncoded();\n"
				+ "bob 从 alice 发送来的公钥中读出 DH 密钥对的初始参数生成 bob 的 DH 密钥对\n" + "\n" + "注意这一步一定要做 , 要保证每个用户用相同的初始参数生成的\n"
				+ "\n" + "  DHParameterSpec dhParamSpec = ((DHPublicKey)alicePubKey).getParams(); \n"
				+ "    KeyPairGenerator bobKpairGen = KeyPairGenerator.getInstance(\"DH\"); \n"
				+ "    bobKpairGen.initialize(dhParamSpec); \n"
				+ "    KeyPair bobKpair = bobKpairGen.generateKeyPair();\n" + "bob 根据 alice 的公钥生成本地的 DES 密钥\n" + "\n"
				+ "  KeyAgreement bobKeyAgree = KeyAgreement.getInstance(\"DH\"); \n"
				+ "    bobKeyAgree.init(bobKpair.getPrivate()); \n" + "    bobKeyAgree.doPhase(alicePubKey, true); \n"
				+ "    SecretKey bobDesKey = bobKeyAgree.generateSecret(\"DES\");\n"
				+ "bob 已经生成了他的 DES 密钥 , 他现把他的公钥发给 alice,\n" + "\n"
				+ "     byte[] bobPubKeyEnc = bobKpair.getPublic().getEncoded();\n" + "alice 根据 bob 的公钥生成本地的 DES 密钥\n"
				+ "\n" + "      ,,,,,, 解码\n" + "    KeyAgreement aliceKeyAgree = KeyAgreement.getInstance(\"DH\"); \n"
				+ "    aliceKeyAgree.init(aliceKpair.getPrivate()); \n"
				+ "    aliceKeyAgree.doPhase(bobPubKey, true); \n"
				+ "    SecretKey aliceDesKey = aliceKeyAgree.generateSecret(\"DES\");\n"
				+ "bob 和 alice 能过这个过程就生成了相同的 DES 密钥 , 在这种基础就可进行安全能信\n" + "\n" + "常用 API\n" + "\n"
				+ "java.security.KeyPairGenerator 密钥生成器类 \n"
				+ "public static KeyPairGenerator getInstance(String algorithm) \n"
				+ "throws NoSuchAlgorithmException \n" + "以指定的算法返回一个 KeyPairGenerator 对象 \n"
				+ "参数 : algorithm 算法名 . 如 : 原来是 DSA, 现在添加了 DiffieHellman(DH)\n" + "\n"
				+ "public void initialize(int keysize) \n" + "以指定的长度初始化 KeyPairGenerator 对象 , 如果没有初始化系统以 1024 长度默认设置 \n"
				+ "参数 :keysize 算法位长 . 其范围必须在 512 到 1024 之间，且必须为 64 的倍数 \n"
				+ "注意 : 如果用 1024 生长的时间很长 , 最好生成一次后就保存 , 下次就不用生成了\n" + "\n"
				+ "public void initialize(AlgorithmParameterSpec params) \n"
				+ "throws InvalidAlgorithmParameterException \n" + "以指定参数初始化\n" + "\n"
				+ "javax.crypto.interfaces.DHPublicKey \n" + "public DHParameterSpec getParams() \n" + "返回 \n"
				+ "java.security.KeyFactory\n" + "\n" + "public static KeyFactory getInstance(String algorithm) \n"
				+ "throws NoSuchAlgorithmException \n" + "以指定的算法返回一个 KeyFactory ";
		byte[] data = temp.getBytes();
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
