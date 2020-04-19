package com.ryan.springbootvue.mathUtil;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author Ryan
 * @Date 2020/3/27 18:31
 * version 1.0
 */
public class RSA implements DiceConsts{
    private static  RSA rsa;

    public static RSA getInstance(){
        if (rsa==null){
            synchronized (RSA.class){
                if (rsa==null){
                    rsa=new RSA();
                }
            }
        }
        return rsa;
    }


    private static Map<Integer, String> rsaMap = new HashMap<Integer, String>();//封装公钥和私钥
    /**
     * 随机生成密钥对
     */
    public static void generateKey(String str) throws NoSuchAlgorithmException {
        //基于RSA算法对象
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        //初始化密钥生成器，密钥位96-1024位
        keyPairGenerator.initialize(1024,new SecureRandom());
        //拿到密钥对
        KeyPair keyPair= keyPairGenerator.generateKeyPair();
        RSAPrivateKey privateKey=(RSAPrivateKey) keyPair.getPrivate();//拿到私钥
        RSAPrivateKey publicKey=(RSAPrivateKey) keyPair.getPublic();//拿到公钥
        //获取密钥字符串
        String publicKeyString=new String(Base64.encodeBase64(publicKey.getEncoded()));
        String privetKeyString=new String(Base64.encodeBase64(privateKey.getEncoded()));
        rsaMap.put(0,publicKeyString);
        rsaMap.put(1,privetKeyString);
    }
    /**
     * RSA
     * @param publicKey 公钥
     *
     * @param str 加密字符串
     *
     * @return 密钥
     *
     */
    public static String encrypt(String str,String publicKey) throws Exception {
        byte[] decode=Base64.decodeBase64(publicKey);
        RSAPublicKey pubKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(decode));
        //RSA加密
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, pubKey);
        String outStr = Base64.encodeBase64String(cipher.doFinal(str.getBytes("UTF-8")));
        return outStr;
    }


    /**
     * RSA
     * @param privateKey 私钥
     *
     * @param str 加密字符串
     *
     * @return 铭文
     * @throws Exception 解密异常
     */
    public static String decrypt(String str, String privateKey) throws Exception{
        //64位解码加密后的字符串
        byte[] inputByte = Base64.decodeBase64(str.getBytes("UTF-8"));
        //base64编码的私钥
        byte[] decoded = Base64.decodeBase64(privateKey);
        RSAPrivateKey priKey = (RSAPrivateKey) KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(decoded));
        //RSA解密
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, priKey);
        String outStr = new String(cipher.doFinal(inputByte));
        return outStr;
    }
}
