package com.cyn.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.*;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * 文件描述
 *
 * @ProjectName: java-autoupdate-server
 * @Package: com.cyn
 * @Date 2020/5/15 13:53
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description: note
 **/
public class HttpDataUtil {
    static Encrypt encrypt = new Encrypt();
    static String JSESSIONID;

    /**
     * 普通的GET请求
     */
    public static String DoGET(String url) throws Exception {
        String res = "";
        // 创建Httpclient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();
        // 创建http GET请求
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = null;
        try {
            // 执行请求
            response = httpclient.execute(httpGet);
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                //请求体内容
                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
                //System.out.println("内容长度：" + content.length() + ",内容：" + content);
                res = content;
            }
        } finally {
            if (response != null) {
                response.close();
            }
            //相当于关闭浏览器
            httpclient.close();
        }
        return res;
    }

    /**
     * 发送HttpPost请求，参数为map
     *
     * @param url
     * @param map
     * @return
     */
    public static String sendPost(String url, Map<String, String> map) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        List<NameValuePair> formparams = new ArrayList<NameValuePair>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            //给参数赋值
            formparams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
        HttpPost httppost = new HttpPost(url);
        httppost.setEntity(entity);
        CloseableHttpResponse response = null;
        try {
            response = httpclient.execute(httppost);
            //System.out.println(headers);
        } catch (IOException e) {
            e.printStackTrace();
        }
        HttpEntity entity1 = response.getEntity();
        String result = null;
        try {
            result = EntityUtils.toString(entity1);
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 获取登陆凭证
     *
     * @param seeLoginUrl
     * @param uname
     * @param upwd
     * @return
     * @throws Exception
     */
    public static JSONObject getTicket(String seeLoginUrl, String uname, String upwd) throws Exception {
        String ticketUrl = seeLoginUrl + "?get-lt=true&n=" + new Date().getTime() + "&callback=?";
        String ticketRes = DoGET(ticketUrl);
        String[] ticketArr = ticketRes.split("\\?");
        JSONObject jsonObject = JSON.parseObject(ticketArr[1].replaceAll("\\(", "").replaceAll("\\)", "").trim());
        System.out.println(jsonObject);

        return jsonObject;
    }

    /**
     * 登陆see
     *
     * @param seeLoginUrl
     * @param uname
     * @param upwd
     * @return
     */
    public static String loginSee(String seeLoginUrl, String uname, String upwd) {
        try {
            JSONObject jsonObject = getTicket(seeLoginUrl, "chenyn22577", "1");
            Map<String, String> loginMap = new HashMap<>();
            loginMap.put("username", uname);
            String encodePwd = encrypt.SHA512(upwd) + "," + encrypt.encryptionMd5(upwd);
            loginMap.put("password", encodePwd);
            loginMap.put("submit", "LOGIN");
            loginMap.put("_eventId", "submit");
            loginMap.put("execution", jsonObject.getString("execution"));
            loginMap.put("lt", jsonObject.getString("lt"));
            String res = sendPost(seeLoginUrl, loginMap);
            System.out.println(res);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }


    /**
     * 发布物上传
     *
     * @param mulUploads
     */
    public void uploadPackage(String mulUploads, File file) {
//        file[0]:(binary),
//                isForcedCover:true
    }


    @Test
    public void login() throws Exception {
        getTicket(SeeUrl.loginUrl, "chenyn22577", "1");
    }

    @Test
    public void login1() throws Exception {
        loginSee(SeeUrl.loginUrl, "chenyn22577", "1");
    }
}
