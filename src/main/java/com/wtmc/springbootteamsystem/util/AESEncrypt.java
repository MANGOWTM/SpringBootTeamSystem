package com.wtmc.springbootteamsystem.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class AESEncrypt {
    public static String encrypt(String data, String key) {
        int subLength=16-key.length();
        if(subLength>=0){
            key = StringUtils.join(key, StringUtils.substring(key, 0, subLength));
        }
        //偏移量
//        String ivString = "0102030405060708";
        String ivString = key;
        byte[] iv = ivString.getBytes();
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            int blockSize = cipher.getBlockSize();
            byte[] dataBytes = data.getBytes();
            int length = dataBytes.length;
            //计算需填充长度
            if (length % blockSize != 0) {
                length = length + (blockSize - (length % blockSize));
            }
            byte[] plaintext = new byte[length];
            //填充
            System.arraycopy(dataBytes, 0, plaintext, 0, dataBytes.length);
            SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "AES");
            //设置偏移量参数
            IvParameterSpec ivSpec = new IvParameterSpec(iv);
            cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);
            byte[] encryped = cipher.doFinal(plaintext);
            return Base64.getEncoder().encodeToString(encryped);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String desEncrypt(String data, String key) {
        int subLength=16-key.length();
        if(subLength>=0){
            key = StringUtils.join(key, StringUtils.substring(key, 0, subLength));
        }
//        String ivString = "0102030405060708";
        String ivString = key;
        byte[] iv = ivString.getBytes();
        try {
            byte[] encryp = Base64.getDecoder().decode(data);
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "AES");
            IvParameterSpec ivSpec = new IvParameterSpec(iv);
            cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);
            byte[] original = cipher.doFinal(encryp);
            return new String(original);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public static void main(String[] args) {
        String key="l8fNqTfssnVFl8N1";
        System.out.println(key.length());
        int subLength=16-key.length();
        System.out.println(subLength);
        if(subLength>=0){
            String join = StringUtils.join(key, StringUtils.substring(key, 0, subLength));
            System.out.println(join.length());
        }
        String str="{\"sys_code\":\"21\",\"type\":\"evaluation\",\"content\":[{\"companyid\":\"5cc2c708202d4defaf72d4bcac362a55\",\"staffid\":\"9517\",\"source\":\"10\",\"admin_name\":\"\",\"is_robot\":\"1\",\"remark\":\"意向用户可跟\",\"tag\":\"答非所问,问题不能回答\",\"score\":\"2\",\"visitorid\":\"97b31cba87e04dcdafe0ebb60248ecf4\",\"date_time\":\"1468340203266\",\"cid\":\"9ae05bc279544b68895cd86b12e418e0\",\"comment_type\":\"1\",\"solved\":\"1\"},{\"companyid\":\"5cc2c708202d4defaf72d4bcac362a55\",\"staffid\":\"9517\",\"source\":\"10\",\"admin_name\":\"\",\"is_robot\":\"1\",\"remark\":\"意向用户可跟\",\"tag\":\"答非所问,问题不能回答\",\"score\":\"2\",\"visitorid\":\"97b31cba87e04dcdafe0ebb60248ecf4\",\"date_time\":\"1468340203266\",\"cid\":\"9ae05bc279544b68895cd86b12e418e0\",\"comment_type\":\"1\",\"solved\":\"1\"},{\"companyid\":\"5cc2c708202d4defaf72d4bcac362a55\",\"staffid\":\"9517\",\"source\":\"10\",\"admin_name\":\"\",\"is_robot\":\"1\",\"remark\":\"意向用户可跟\",\"tag\":\"答非所问,问题不能回答\",\"score\":\"2\",\"visitorid\":\"97b31cba87e04dcdafe0ebb60248ecf4\",\"date_time\":\"1468340203266\",\"cid\":\"9ae05bc279544b68895cd86b12e418e0\",\"comment_type\":\"1\",\"solved\":\"1\"},{\"companyid\":\"5cc2c708202d4defaf72d4bcac362a55\",\"staffid\":\"9517\",\"source\":\"10\",\"admin_name\":\"\",\"is_robot\":\"1\",\"remark\":\"意向用户可跟\",\"tag\":\"答非所问,问题不能回答\",\"score\":\"2\",\"visitorid\":\"97b31cba87e04dcdafe0ebb60248ecf4\",\"date_time\":\"1468340203266\",\"cid\":\"9ae05bc279544b68895cd86b12e418e0\",\"comment_type\":\"1\",\"solved\":\"1\"},{\"companyid\":\"5cc2c708202d4defaf72d4bcac362a55\",\"staffid\":\"9517\",\"source\":\"10\",\"admin_name\":\"\",\"is_robot\":\"1\",\"remark\":\"意向用户可跟\",\"tag\":\"答非所问,问题不能回答\",\"score\":\"2\",\"visitorid\":\"97b31cba87e04dcdafe0ebb60248ecf4\",\"date_time\":\"1468340203266\",\"cid\":\"9ae05bc279544b68895cd86b12e418e0\",\"comment_type\":\"1\",\"solved\":\"1\"},{\"companyid\":\"5cc2c708202d4defaf72d4bcac362a55\",\"staffid\":\"9517\",\"source\":\"10\",\"admin_name\":\"\",\"is_robot\":\"1\",\"remark\":\"意向用户可跟\",\"tag\":\"答非所问,问题不能回答\",\"score\":\"2\",\"visitorid\":\"97b31cba87e04dcdafe0ebb60248ecf4\",\"date_time\":\"1468340203266\",\"cid\":\"9ae05bc279544b68895cd86b12e418e0\",\"comment_type\":\"1\",\"solved\":\"1\"},{\"companyid\":\"5cc2c708202d4defaf72d4bcac362a55\",\"staffid\":\"9517\",\"source\":\"10\",\"admin_name\":\"\",\"is_robot\":\"1\",\"remark\":\"意向用户可跟\",\"tag\":\"答非所问,问题不能回答\",\"score\":\"2\",\"visitorid\":\"97b31cba87e04dcdafe0ebb60248ecf4\",\"date_time\":\"1468340203266\",\"cid\":\"9ae05bc279544b68895cd86b12e418e0\",\"comment_type\":\"1\",\"solved\":\"1\"},{\"companyid\":\"5cc2c708202d4defaf72d4bcac362a55\",\"staffid\":\"9517\",\"source\":\"10\",\"admin_name\":\"\",\"is_robot\":\"1\",\"remark\":\"意向用户可跟\",\"tag\":\"答非所问,问题不能回答\",\"score\":\"2\",\"visitorid\":\"97b31cba87e04dcdafe0ebb60248ecf4\",\"date_time\":\"1468340203266\",\"cid\":\"9ae05bc279544b68895cd86b12e418e0\",\"comment_type\":\"1\",\"solved\":\"1\"},{\"companyid\":\"5cc2c708202d4defaf72d4bcac362a55\",\"staffid\":\"9517\",\"source\":\"10\",\"admin_name\":\"\",\"is_robot\":\"1\",\"remark\":\"意向用户可跟\",\"tag\":\"答非所问,问题不能回答\",\"score\":\"2\",\"visitorid\":\"97b31cba87e04dcdafe0ebb60248ecf4\",\"date_time\":\"1468340203266\",\"cid\":\"9ae05bc279544b68895cd86b12e418e0\",\"comment_type\":\"1\",\"solved\":\"1\"},{\"companyid\":\"5cc2c708202d4defaf72d4bcac362a55\",\"staffid\":\"9517\",\"source\":\"10\",\"admin_name\":\"\",\"is_robot\":\"1\",\"remark\":\"意向用户可跟\",\"tag\":\"答非所问,问题不能回答\",\"score\":\"2\",\"visitorid\":\"97b31cba87e04dcdafe0ebb60248ecf4\",\"date_time\":\"1468340203266\",\"cid\":\"9ae05bc279544b68895cd86b12e418e0\",\"comment_type\":\"1\",\"solved\":\"1\"},{\"companyid\":\"5cc2c708202d4defaf72d4bcac362a55\",\"staffid\":\"9517\",\"source\":\"10\",\"admin_name\":\"\",\"is_robot\":\"1\",\"remark\":\"意向用户可跟\",\"tag\":\"答非所问,问题不能回答\",\"score\":\"2\",\"visitorid\":\"97b31cba87e04dcdafe0ebb60248ecf4\",\"date_time\":\"1468340203266\",\"cid\":\"9ae05bc279544b68895cd86b12e418e0\",\"comment_type\":\"1\",\"solved\":\"1\"},{\"companyid\":\"5cc2c708202d4defaf72d4bcac362a55\",\"staffid\":\"9517\",\"source\":\"10\",\"admin_name\":\"\",\"is_robot\":\"1\",\"remark\":\"意向用户可跟\",\"tag\":\"答非所问,问题不能回答\",\"score\":\"2\",\"visitorid\":\"97b31cba87e04dcdafe0ebb60248ecf4\",\"date_time\":\"1468340203266\",\"cid\":\"9ae05bc279544b68895cd86b12e418e0\",\"comment_type\":\"1\",\"solved\":\"1\"},{\"companyid\":\"5cc2c708202d4defaf72d4bcac362a55\",\"staffid\":\"9517\",\"source\":\"10\",\"admin_name\":\"\",\"is_robot\":\"1\",\"remark\":\"意向用户可跟\",\"tag\":\"答非所问,问题不能回答\",\"score\":\"2\",\"visitorid\":\"97b31cba87e04dcdafe0ebb60248ecf4\",\"date_time\":\"1468340203266\",\"cid\":\"9ae05bc279544b68895cd86b12e418e0\",\"comment_type\":\"1\",\"solved\":\"1\"},{\"companyid\":\"5cc2c708202d4defaf72d4bcac362a55\",\"staffid\":\"9517\",\"source\":\"10\",\"admin_name\":\"\",\"is_robot\":\"1\",\"remark\":\"意向用户可跟\",\"tag\":\"答非所问,问题不能回答\",\"score\":\"2\",\"visitorid\":\"97b31cba87e04dcdafe0ebb60248ecf4\",\"date_time\":\"1468340203266\",\"cid\":\"9ae05bc279544b68895cd86b12e418e0\",\"comment_type\":\"1\",\"solved\":\"1\"},{\"companyid\":\"5cc2c708202d4defaf72d4bcac362a55\",\"staffid\":\"9517\",\"source\":\"10\",\"admin_name\":\"\",\"is_robot\":\"1\",\"remark\":\"意向用户可跟\",\"tag\":\"答非所问,问题不能回答\",\"score\":\"2\",\"visitorid\":\"97b31cba87e04dcdafe0ebb60248ecf4\",\"date_time\":\"1468340203266\",\"cid\":\"9ae05bc279544b68895cd86b12e418e0\",\"comment_type\":\"1\",\"solved\":\"1\"},{\"companyid\":\"5cc2c708202d4defaf72d4bcac362a55\",\"staffid\":\"9517\",\"source\":\"10\",\"admin_name\":\"\",\"is_robot\":\"1\",\"remark\":\"意向用户可跟\",\"tag\":\"答非所问,问题不能回答\",\"score\":\"2\",\"visitorid\":\"97b31cba87e04dcdafe0ebb60248ecf4\",\"date_time\":\"1468340203266\",\"cid\":\"9ae05bc279544b68895cd86b12e418e0\",\"comment_type\":\"1\",\"solved\":\"1\"},{\"companyid\":\"5cc2c708202d4defaf72d4bcac362a55\",\"staffid\":\"9517\",\"source\":\"10\",\"admin_name\":\"\",\"is_robot\":\"1\",\"remark\":\"意向用户可跟\",\"tag\":\"答非所问,问题不能回答\",\"score\":\"2\",\"visitorid\":\"97b31cba87e04dcdafe0ebb60248ecf4\",\"date_time\":\"1468340203266\",\"cid\":\"9ae05bc279544b68895cd86b12e418e0\",\"comment_type\":\"1\",\"solved\":\"1\"},{\"companyid\":\"5cc2c708202d4defaf72d4bcac362a55\",\"staffid\":\"9517\",\"source\":\"10\",\"admin_name\":\"\",\"is_robot\":\"1\",\"remark\":\"意向用户可跟\",\"tag\":\"答非所问,问题不能回答\",\"score\":\"2\",\"visitorid\":\"97b31cba87e04dcdafe0ebb60248ecf4\",\"date_time\":\"1468340203266\",\"cid\":\"9ae05bc279544b68895cd86b12e418e0\",\"comment_type\":\"1\",\"solved\":\"1\"},{\"companyid\":\"5cc2c708202d4defaf72d4bcac362a55\",\"staffid\":\"9517\",\"source\":\"10\",\"admin_name\":\"\",\"is_robot\":\"1\",\"remark\":\"意向用户可跟\",\"tag\":\"答非所问,问题不能回答\",\"score\":\"2\",\"visitorid\":\"97b31cba87e04dcdafe0ebb60248ecf4\",\"date_time\":\"1468340203266\",\"cid\":\"9ae05bc279544b68895cd86b12e418e0\",\"comment_type\":\"1\",\"solved\":\"1\"},{\"companyid\":\"5cc2c708202d4defaf72d4bcac362a55\",\"staffid\":\"9517\",\"source\":\"10\",\"admin_name\":\"\",\"is_robot\":\"1\",\"remark\":\"意向用户可跟\",\"tag\":\"答非所问,问题不能回答\",\"score\":\"2\",\"visitorid\":\"97b31cba87e04dcdafe0ebb60248ecf4\",\"date_time\":\"1468340203266\",\"cid\":\"9ae05bc279544b68895cd86b12e418e0\",\"comment_type\":\"1\",\"solved\":\"1\"},{\"companyid\":\"5cc2c708202d4defaf72d4bcac362a55\",\"staffid\":\"9517\",\"source\":\"10\",\"admin_name\":\"\",\"is_robot\":\"1\",\"remark\":\"意向用户可跟\",\"tag\":\"答非所问,问题不能回答\",\"score\":\"2\",\"visitorid\":\"97b31cba87e04dcdafe0ebb60248ecf4\",\"date_time\":\"1468340203266\",\"cid\":\"9ae05bc279544b68895cd86b12e418e0\",\"comment_type\":\"1\",\"solved\":\"1\"},{\"companyid\":\"5cc2c708202d4defaf72d4bcac362a55\",\"staffid\":\"9517\",\"source\":\"10\",\"admin_name\":\"\",\"is_robot\":\"1\",\"remark\":\"意向用户可跟\",\"tag\":\"答非所问,问题不能回答\",\"score\":\"2\",\"visitorid\":\"97b31cba87e04dcdafe0ebb60248ecf4\",\"date_time\":\"1468340203266\",\"cid\":\"9ae05bc279544b68895cd86b12e418e0\",\"comment_type\":\"1\",\"solved\":\"1\"},{\"companyid\":\"5cc2c708202d4defaf72d4bcac362a55\",\"staffid\":\"9517\",\"source\":\"10\",\"admin_name\":\"\",\"is_robot\":\"1\",\"remark\":\"意向用户可跟\",\"tag\":\"答非所问,问题不能回答\",\"score\":\"2\",\"visitorid\":\"97b31cba87e04dcdafe0ebb60248ecf4\",\"date_time\":\"1468340203266\",\"cid\":\"9ae05bc279544b68895cd86b12e418e0\",\"comment_type\":\"1\",\"solved\":\"1\"},{\"companyid\":\"5cc2c708202d4defaf72d4bcac362a55\",\"staffid\":\"9517\",\"source\":\"10\",\"admin_name\":\"\",\"is_robot\":\"1\",\"remark\":\"意向用户可跟\",\"tag\":\"答非所问,问题不能回答\",\"score\":\"2\",\"visitorid\":\"97b31cba87e04dcdafe0ebb60248ecf4\",\"date_time\":\"1468340203266\",\"cid\":\"9ae05bc279544b68895cd86b12e418e0\",\"comment_type\":\"1\",\"solved\":\"1\"},{\"companyid\":\"5cc2c708202d4defaf72d4bcac362a55\",\"staffid\":\"9517\",\"source\":\"10\",\"admin_name\":\"\",\"is_robot\":\"1\",\"remark\":\"意向用户可跟\",\"tag\":\"答非所问,问题不能回答\",\"score\":\"2\",\"visitorid\":\"97b31cba87e04dcdafe0ebb60248ecf4\",\"date_time\":\"1468340203266\",\"cid\":\"9ae05bc279544b68895cd86b12e418e0\",\"comment_type\":\"1\",\"solved\":\"1\"},{\"companyid\":\"5cc2c708202d4defaf72d4bcac362a55\",\"staffid\":\"9517\",\"source\":\"10\",\"admin_name\":\"\",\"is_robot\":\"1\",\"remark\":\"意向用户可跟\",\"tag\":\"答非所问,问题不能回答\",\"score\":\"2\",\"visitorid\":\"97b31cba87e04dcdafe0ebb60248ecf4\",\"date_time\":\"1468340203266\",\"cid\":\"9ae05bc279544b68895cd86b12e418e0\",\"comment_type\":\"1\",\"solved\":\"1\"},{\"companyid\":\"5cc2c708202d4defaf72d4bcac362a55\",\"staffid\":\"9517\",\"source\":\"10\",\"admin_name\":\"\",\"is_robot\":\"1\",\"remark\":\"意向用户可跟\",\"tag\":\"答非所问,问题不能回答\",\"score\":\"2\",\"visitorid\":\"97b31cba87e04dcdafe0ebb60248ecf4\",\"date_time\":\"1468340203266\",\"cid\":\"9ae05bc279544b68895cd86b12e418e0\",\"comment_type\":\"1\",\"solved\":\"1\"},{\"companyid\":\"5cc2c708202d4defaf72d4bcac362a55\",\"staffid\":\"9517\",\"source\":\"10\",\"admin_name\":\"\",\"is_robot\":\"1\",\"remark\":\"意向用户可跟\",\"tag\":\"答非所问,问题不能回答\",\"score\":\"2\",\"visitorid\":\"97b31cba87e04dcdafe0ebb60248ecf4\",\"date_time\":\"1468340203266\",\"cid\":\"9ae05bc279544b68895cd86b12e418e0\",\"comment_type\":\"1\",\"solved\":\"1\"},{\"companyid\":\"5cc2c708202d4defaf72d4bcac362a55\",\"staffid\":\"9517\",\"source\":\"10\",\"admin_name\":\"\",\"is_robot\":\"1\",\"remark\":\"意向用户可跟\",\"tag\":\"答非所问,问题不能回答\",\"score\":\"2\",\"visitorid\":\"97b31cba87e04dcdafe0ebb60248ecf4\",\"date_time\":\"1468340203266\",\"cid\":\"9ae05bc279544b68895cd86b12e418e0\",\"comment_type\":\"1\",\"solved\":\"1\"},{\"companyid\":\"5cc2c708202d4defaf72d4bcac362a55\",\"staffid\":\"9517\",\"source\":\"10\",\"admin_name\":\"\",\"is_robot\":\"1\",\"remark\":\"意向用户可跟\",\"tag\":\"答非所问,问题不能回答\",\"score\":\"2\",\"visitorid\":\"97b31cba87e04dcdafe0ebb60248ecf4\",\"date_time\":\"1468340203266\",\"cid\":\"9ae05bc279544b68895cd86b12e418e0\",\"comment_type\":\"1\",\"solved\":\"1\"},{\"companyid\":\"5cc2c708202d4defaf72d4bcac362a55\",\"staffid\":\"9517\",\"source\":\"10\",\"admin_name\":\"\",\"is_robot\":\"1\",\"remark\":\"意向用户可跟\",\"tag\":\"答非所问,问题不能回答\",\"score\":\"2\",\"visitorid\":\"97b31cba87e04dcdafe0ebb60248ecf4\",\"date_time\":\"1468340203266\",\"cid\":\"9ae05bc279544b68895cd86b12e418e0\",\"comment_type\":\"1\",\"solved\":\"1\"},{\"companyid\":\"5cc2c708202d4defaf72d4bcac362a55\",\"staffid\":\"9517\",\"source\":\"10\",\"admin_name\":\"\",\"is_robot\":\"1\",\"remark\":\"意向用户可跟\",\"tag\":\"答非所问,问题不能回答\",\"score\":\"2\",\"visitorid\":\"97b31cba87e04dcdafe0ebb60248ecf4\",\"date_time\":\"1468340203266\",\"cid\":\"9ae05bc279544b68895cd86b12e418e0\",\"comment_type\":\"1\",\"solved\":\"1\"},{\"companyid\":\"5cc2c708202d4defaf72d4bcac362a55\",\"staffid\":\"9517\",\"source\":\"10\",\"admin_name\":\"\",\"is_robot\":\"1\",\"remark\":\"意向用户可跟\",\"tag\":\"答非所问,问题不能回答\",\"score\":\"2\",\"visitorid\":\"97b31cba87e04dcdafe0ebb60248ecf4\",\"date_time\":\"1468340203266\",\"cid\":\"9ae05bc279544b68895cd86b12e418e0\",\"comment_type\":\"1\",\"solved\":\"1\"},{\"companyid\":\"5cc2c708202d4defaf72d4bcac362a55\",\"staffid\":\"9517\",\"source\":\"10\",\"admin_name\":\"\",\"is_robot\":\"1\",\"remark\":\"意向用户可跟\",\"tag\":\"答非所问,问题不能回答\",\"score\":\"2\",\"visitorid\":\"97b31cba87e04dcdafe0ebb60248ecf4\",\"date_time\":\"1468340203266\",\"cid\":\"9ae05bc279544b68895cd86b12e418e0\",\"comment_type\":\"1\",\"solved\":\"1\"},{\"companyid\":\"5cc2c708202d4defaf72d4bcac362a55\",\"staffid\":\"9517\",\"source\":\"10\",\"admin_name\":\"\",\"is_robot\":\"1\",\"remark\":\"意向用户可跟\",\"tag\":\"答非所问,问题不能回答\",\"score\":\"2\",\"visitorid\":\"97b31cba87e04dcdafe0ebb60248ecf4\",\"date_time\":\"1468340203266\",\"cid\":\"9ae05bc279544b68895cd86b12e418e0\",\"comment_type\":\"1\",\"solved\":\"1\"},{\"companyid\":\"5cc2c708202d4defaf72d4bcac362a55\",\"staffid\":\"9517\",\"source\":\"10\",\"admin_name\":\"\",\"is_robot\":\"1\",\"remark\":\"意向用户可跟\",\"tag\":\"答非所问,问题不能回答\",\"score\":\"2\",\"visitorid\":\"97b31cba87e04dcdafe0ebb60248ecf4\",\"date_time\":\"1468340203266\",\"cid\":\"9ae05bc279544b68895cd86b12e418e0\",\"comment_type\":\"1\",\"solved\":\"1\"},{\"companyid\":\"5cc2c708202d4defaf72d4bcac362a55\",\"staffid\":\"9517\",\"source\":\"10\",\"admin_name\":\"\",\"is_robot\":\"1\",\"remark\":\"意向用户可跟\",\"tag\":\"答非所问,问题不能回答\",\"score\":\"2\",\"visitorid\":\"97b31cba87e04dcdafe0ebb60248ecf4\",\"date_time\":\"1468340203266\",\"cid\":\"9ae05bc279544b68895cd86b12e418e0\",\"comment_type\":\"1\",\"solved\":\"1\"}]}";
        System.out.println("byteLen = " + str.getBytes().length);
        JSONObject jsonObject = JSON.parseObject(str);
        JSONArray content = jsonObject.getJSONArray("content");
        System.out.println("加密前：" + content);
        System.out.println();
        String aesKey = "sbclHUkN3kQ2Clcq";
        //开始加密
        String encrypt = encrypt(content.toString(), aesKey);
        System.out.println("加密后：" + encrypt);
        System.out.println();
        //开始解密：
        String desEncrypt = desEncrypt(encrypt, aesKey);
        System.out.println("解密后：" + desEncrypt);
    }
}