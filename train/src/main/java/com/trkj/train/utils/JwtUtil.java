package com.trkj.train.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;

/**
 * ConfigurationProperties注解：在 Spring Boot 项目中大量的参数配置，在 application.properties
 * 或 application.yml 文件中，通过 @ConfigurationProperties 注解，我们可以方便的获取
 * 这些参数值，application.yml 文件本身支持list类型所以在application.yml 文件中可以这样配置：
 *        jwt:
 *          config:
 *            key: 自定义私钥key值
 *            timeOut: 有效时间(毫秒单位)
 */
//@ConfigurationProperties("jwt.config")
public class JwtUtil {
   //有效期为
   public static final Long JWT_TTL=60*60*1000L;//60*60*1000 一个小时
//    设置秘匙明文
    public static final String JTW_KEY="syz";

    public static String getUUID(){
        String token= UUID.randomUUID().toString().replaceAll("-","");
        return token;
    }

    /**
     * 生成JWT
     * @param subject token中要存放的值（json格式）
     * @return
     */
    public static String createJWT(String subject){
        JwtBuilder builder=getJwtBuilder(subject,null,getUUID());//设置过期日期
        return  builder.compact();
    }

    /**
     * 生成JWT
     * @param subject token中要存放的值（json格式）
     * @param ttlMillis token超过时间
     * @return
     */
    public static String createJwt(String subject,Long ttlMillis){
        JwtBuilder builder=getJwtBuilder(subject,ttlMillis,getUUID());
        return builder.compact();
    }

    public static JwtBuilder getJwtBuilder(String subject,Long ttlMillis,String uuid){
        SignatureAlgorithm signatureAlgorithm=SignatureAlgorithm.HS256;
        SecretKey secretKey=generaIKey();
        long nowMillis=System.currentTimeMillis();
        Date now=new Date(nowMillis);
        if(ttlMillis==null){
            ttlMillis=JwtUtil.JWT_TTL;
        }
        long expMillis=nowMillis+ttlMillis;
        Date expDate=new Date(expMillis);
        return Jwts.builder()
                .setId(uuid) //唯一的ID
                .setSubject(subject) //主题 可以是JSON数据
                .setIssuer("syz")   // 签发者
                .setIssuedAt(now)   // 签发时间
                .signWith(signatureAlgorithm,secretKey) //使用HS256对称加密算法签名，第二个参数为秘匙
                .setExpiration(expDate);
    }

    /**
     * 创建token
     * @param id
     * @param subject
     * @param ttlMillis
     * @return
     */
    public static String createJwt(String id,String subject,Long ttlMillis){
        JwtBuilder builder=getJwtBuilder(subject,ttlMillis,id); //设置过期时间
        return builder.compact();
    }

    public static void main(String[] args) {
        String jwt=createJWT("123456");
        System.out.println(jwt);

    }

    /**
     * 生成加密后的秘匙 secreyKey
     * @return
     */
    public static SecretKey generaIKey(){
        byte[] encodeKey= Base64.getDecoder().decode(JwtUtil.JTW_KEY);
        SecretKey key=new SecretKeySpec(encodeKey,0,encodeKey.length,"AES");
        return key;
    }

    public static Claims parseJWT(String jwt) throws Exception{
        SecretKey secretKey=generaIKey();
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(jwt)
                .getBody();
    }
}