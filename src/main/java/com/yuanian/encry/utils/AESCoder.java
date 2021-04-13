package com.yuanian.encry.utils;


import com.xneure.utils.cipher.SimpleEncode;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.SecureRandom;

/**
 * AES对称秘钥算法加密。
 * @author zhahongsheng
 */
public class AESCoder {

	public static final String KEY_ALGORITHM = "AES";
	public static String CIPER_ALGORITHM = "AES/ECB/PKCS5Padding";


	public static String encryptPassword(String password){
		String result = "";
		try {
			result = new String(AESCoder.encrept(password.getBytes(), "9f0c85ba784311e897548f93c08d7433"));
		}catch (Exception e){
			System.out.println(e.toString());;
		}
		return result;
	}

	public static String decryptPassword(String password){
		String result = "";
		try {
			result = new String(AESCoder.decrept(password.getBytes(), "9f0c85ba784311e897548f93c08d7433"));
		}catch (Exception e){
			System.out.println(e.toString());;
		}
		return result;
	}

	public static byte[] decrept(byte[] data, String key) throws Exception {
		Cipher cipher = Cipher.getInstance(CIPER_ALGORITHM);
		cipher.init(Cipher.DECRYPT_MODE, initKey(key));
		return cipher.doFinal(SimpleEncode.decodeBase64(new String(data)));
	}

	public static byte[] encrept(byte[] data, String key) throws Exception {
		Cipher cipher = Cipher.getInstance(CIPER_ALGORITHM);
		cipher.init(Cipher.ENCRYPT_MODE, initKey(key));
		return SimpleEncode.encodeBase64(cipher.doFinal(data)).getBytes();
	}

	private static Key initKey(String pwd) throws Exception {
		KeyGenerator kg = KeyGenerator.getInstance(KEY_ALGORITHM);
		if (null == pwd) {
			kg.init(128);
		} else {
			SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
			random.setSeed(pwd.getBytes());
			kg.init(128, random);
		}
		return new SecretKeySpec(kg.generateKey().getEncoded(), "AES");
	}

	public static void main(String[] args) {
		try {
			System.out.println("加密前：Caocao@123");
			String encrept = new String(AESCoder.encrept("Caocao@123".getBytes(), "9f0c85ba784311e897548f93c08d7433"));
			System.out.println("加密后：" + encrept);
			String decrept = new String(AESCoder.decrept(encrept.getBytes(), "9f0c85ba784311e897548f93c08d7433"));
			System.out.println("解密后：" + decrept);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
