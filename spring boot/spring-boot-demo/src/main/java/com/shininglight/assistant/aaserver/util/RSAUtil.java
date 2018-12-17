package com.shininglight.assistant.aaserver.util;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * RSA加密，可逆加密，用于前后端数据传输.
 *
 * @author: Shane Liu
 * @date: Created in 10:57 12/10/18
 */
@Slf4j
public class RSAUtil {
    //客户端不需要该变量
    private static final String PRIVATE_KEY_BASE_64 = "";

    private static final String PUBLIC_KEY_BASE_64 = "";




    public static String encryptByRSA(String text) throws Exception {
        //获取公钥对象
        PublicKey publicKey = RSAUtil.string2PublicKey(PUBLIC_KEY_BASE_64);
        //加密
        byte[] publicEncrypt = RSAUtil.publicEncrypt(text.getBytes(), publicKey);
        //加密后的内容Base64编码
        String byte2Base64 = RSAUtil.byte2Base64(publicEncrypt);
        return byte2Base64;
    }

    public static String decryptByRSA(String cipherText) throws Exception {
        //获取私钥对象
        PrivateKey privateKey = RSAUtil.string2PrivateKey(PRIVATE_KEY_BASE_64);
        //将加密后的内容Base64解码
        byte[] base642Byte = RSAUtil.base642Byte(cipherText);
        //用私钥解密
        byte[] privateDecrypt = RSAUtil.privateDecrypt(base642Byte, privateKey);
        return new String(privateDecrypt);
    }



    //将Base64编码后的公钥字符串转换成PublicKey对象
    private static PublicKey string2PublicKey(String pubStr) throws Exception {
        byte[] keyBytes = base642Byte(pubStr);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicKey = keyFactory.generatePublic(keySpec);
        return publicKey;
    }

    //将Base64编码后的私钥转换成PrivateKey对象
    private static PrivateKey string2PrivateKey(String priStr) throws Exception {
        byte[] keyBytes = base642Byte(priStr);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
        return privateKey;
    }

    //公钥加密
    private static byte[] publicEncrypt(byte[] content, PublicKey publicKey) throws Exception{
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] bytes = cipher.doFinal(content);
        return bytes;
    }

    //私钥解密
    private static byte[] privateDecrypt(byte[] content, PrivateKey privateKey) throws Exception{
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] bytes = cipher.doFinal(content);
        return bytes;
    }

    //字节数组转Base64编码
    private static String byte2Base64(byte[] bytes){
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(bytes);
    }

    //Base64编码转字节数组
    private static byte[] base642Byte(String base64Key) throws IOException {
        BASE64Decoder decoder = new BASE64Decoder();
        return decoder.decodeBuffer(base64Key);
    }

    //生成秘钥对,用于项目之初,客户端不需要该方法
    private static KeyPair getKeyPair() throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        return keyPair;
    }

    //获取公钥(Base64编码),用于项目之初,客户端不需要该方法
    private static String getPublicKey(KeyPair keyPair){
        PublicKey publicKey = keyPair.getPublic();
        byte[] bytes = publicKey.getEncoded();
        return byte2Base64(bytes);
    }

    //获取私钥(Base64编码),用于项目之初,客户端不需要该方法
    private static String getPrivateKey(KeyPair keyPair){
        PrivateKey privateKey = keyPair.getPrivate();
        byte[] bytes = privateKey.getEncoded();
        return byte2Base64(bytes);
    }

    //生成公钥和私钥,用于项目之初,客户端不需要该方法
    @Test
    public void generateKey() throws Exception {
        KeyPair keyPair = RSAUtil.getKeyPair();
        String publicKeyStr = RSAUtil.getPublicKey(keyPair);
        String privateKeyStr = RSAUtil.getPrivateKey(keyPair);
        log.info("RSA公钥Base64编码:" + publicKeyStr);
        log.info("RSA私钥Base64编码:" + privateKeyStr);
    }

    //测试解密加密是否成功,用于项目之初,客户端不需要该方法
    @Test
    public void testDecryptEncrypt() throws Exception {
        String text = "hello world";
        String text2 = encryptByRSA(text);
        String text3 = decryptByRSA(text2);
        log.info(text3);
    }
}
