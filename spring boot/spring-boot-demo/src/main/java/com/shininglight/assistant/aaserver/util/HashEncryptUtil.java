package com.shininglight.assistant.aaserver.util;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;

/**
 * SHA机密, 不可逆加密, 用于加密密码.
 *
 * @author: Shane Liu
 * @date: Created in 10:06 12/10/18
 */
@Slf4j
public class HashEncryptUtil {

    /**
     * description: 传入文本内容，返回 SHA-256 串
     * param: [password]
     * return: java.lang.String
     * date: 2018/6/13
     * time: 15:22
     */
    public static String SHA256(final String password) {
        return SHA(password, "SHA-256", "");
    }

    /**
     * description: 传入文本内容，返回 SHA-512 串
     * param: [password]
     * return: java.lang.String
     * date: 2018/6/13
     * time: 15:22
     */
    public static String SHA512(final String password) {
        return SHA(password, "SHA-512", "");
    }

    /**
     * Description: SHA512加盐加密
     * Param: [password, salt]
     * return: java.lang.String
     * Author: CHEN ZUOLI
     * Date: 2018/3/12
     * Time: 16:00
     */
    public static String SHA512(final String password, final String salt) {
        return SHA(password, "SHA-512", salt);
    }

    /**
     * description: 字符串 SHA 加密
     * param: [password, strType, salt]
     * return: java.lang.String
     * date: 2018/6/13
     * time: 15:22
     */
    private static String SHA(String password, final String strType, final String salt) {
        // 返回值
        String strResult = null;

        password = salt + password;
        // 是否是有效字符串
        if (password != null && password.length() > 0) {
            try {
                // SHA 加密开始
                // 创建加密对象 并傳入加密類型
                MessageDigest messageDigest = MessageDigest.getInstance(strType);
                // 传入要加密的字符串
                messageDigest.update(password.getBytes());
                // 得到 byte 類型结果
                byte byteBuffer[] = messageDigest.digest();

                // 將 byte 转换为 string
                StringBuffer strHexString = new StringBuffer();
                // 遍歷 byte buffer
                for (int i = 0; i < byteBuffer.length; i++) {
                    String hex = Integer.toHexString(0xff & byteBuffer[i]);
                    if (hex.length() == 1) {
                        strHexString.append('0');
                    }
                    strHexString.append(hex);
                }
                // 得到返回結果
                strResult = strHexString.toString();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        return strResult;
    }

}
