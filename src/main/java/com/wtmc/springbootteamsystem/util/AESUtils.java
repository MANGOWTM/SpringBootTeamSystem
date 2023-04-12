package com.wtmc.springbootteamsystem.util;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;

import java.security.SecureRandom;

public class AESUtils {

    private static final String ALGORITHM = "AES";
    private static final String CHARSET = "UTF-8";
    private static final int KEY_SIZE = 128;

    /**
     * 加密字符串
     * @param content 待加密的字符串
     * @param key 加密秘钥
     * @return 加密后的字符串
     * @throws Exception
     */
    public static String encrypt(String content, String key) throws Exception {
        byte[] contentBytes = content.getBytes(CHARSET);
        byte[] keyBytes = key.getBytes(CHARSET);
        SecretKeySpec keySpec = new SecretKeySpec(keyBytes, ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, keySpec);
        byte[] encryptedBytes = cipher.doFinal(contentBytes);
        return Base64.encodeBase64String(encryptedBytes);
    }

    /**
     * 解密字符串
     * @param content 待解密的字符串
     * @param key 解密秘钥
     * @return 解密后的字符串
     * @throws Exception
     */
    public static String decrypt(String content, String key) throws Exception {
        byte[] contentBytes = Base64.decodeBase64(content);
        byte[] keyBytes = key.getBytes(CHARSET);
        SecretKeySpec keySpec = new SecretKeySpec(keyBytes, ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, keySpec);
        byte[] decryptedBytes = cipher.doFinal(contentBytes);
        return new String(decryptedBytes, CHARSET);
    }

    /**
     * 生成随机的秘钥
     * @return 秘钥
     * @throws Exception
     */
    public static String generateKey() throws Exception {
        SecretKeySpec keySpec = new SecretKeySpec(getRandomBytes(KEY_SIZE / 8), ALGORITHM);
        return Base64.encodeBase64String(keySpec.getEncoded());
    }

    /**
     * 生成指定长度的随机字节数组
     * @param length 字节数组长度
     * @return 随机字节数组
     * @throws Exception
     */
    private static byte[] getRandomBytes(int length) throws Exception {
        byte[] bytes = new byte[length];
        SecureRandom random = SecureRandom.getInstanceStrong();
        random.nextBytes(bytes);
        return bytes;
    }
}
