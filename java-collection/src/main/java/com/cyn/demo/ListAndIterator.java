package com.cyn.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.text.Collator;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @author chenyanan
 * @date 2021/1/29
 * Created by chenyanan on 2021/1/29
 * List和iterator区别
 * 1.list可以add元素，iterator不能新增
 * 2.list没有判断空的方法，iterator有判断空的方法
 * 3.list可以修改，iterator只用于迭代循环，不能修改
 */
public class ListAndIterator {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);

        Map<String, Integer> mapDemo = new HashMap<String, Integer>();
        mapDemo.put("a", 1);
        mapDemo.put("b", 2);
        Iterator<String> iterator = mapDemo.keySet().iterator();
        while (iterator.hasNext()) {
            System.out.println("===" + mapDemo.get(iterator.next()));
        }
    }

    @Test
    public void test() {
        List<String> stringList = Arrays.asList("a李四", "b阿毛", "老王", "小李", "小董");
        stringList.sort((x, y) -> {
            Collator instance = Collator.getInstance(Locale.CHINA);
            return instance.compare(x, y);
        });
        System.out.println("------------------------------------");
        stringList.forEach(System.out::println);

    }

    @Test
    public void test2() {
        String t1 = "{\"eventType\":\"register\",\"userName\":\"3999\",\"data\":{\"registered\":true}}";
        JSONObject webrtc2sipMsg = JSON.parseObject(t1);
        String eventType = (String) webrtc2sipMsg.get("eventType");
        JSONObject msgData = (JSONObject) webrtc2sipMsg.get("data");
        boolean registered = (boolean) msgData.get("registered");
        System.out.println("" + eventType + "" + registered);
    }

    @Test
    public void DataCompare() throws ParseException {
        String dateString1 = "2022-01-07 16:42:29"; //lock
        String dateString2 = "2022-01-07 16:43:42"; //lock nowtime
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dateParse1 = dateFormat.parse(dateString1);
        Date dateParse2 = dateFormat.parse(dateString2);

        // 计算时间差值（毫秒数）
        long diffInMillis = dateParse1.getTime() - dateParse2.getTime();

        // 将毫秒数转换为小时、分钟和秒
        System.out.println(((int) TimeUnit.MILLISECONDS.toSeconds(diffInMillis) % 60) > 0);

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long lockTime = formatter.parse(dateString1).getTime();
        long nowTime = formatter.parse(dateString2).getTime();
        System.out.println((nowTime - lockTime) / 1000);
    }

    @Test
    public void JsonParse() {
        String json = "{\"eventType\":\"initialize\",\"userName\":\"1100\",\"data\":{\"calling\":false}}\n";
        JSONObject webrtc2sipMsg = JSON.parseObject(json);
        String jsonString = JSON.toJSONString(webrtc2sipMsg);
        System.out.println(json);
        System.out.println(jsonString);
    }

    @Test
    public void byteT() throws UnsupportedEncodingException {


        // 193
        byte[] message01 = new byte[]{-84, 85, 95, 96, -108, -76, -127, -99, 106, 25, -47, 31, 118, 48, 31, 78, 63, 33, 61, 36, -118, 72, -55, -52, -31, -125, -63, -44, -128, -78, -56, 78};


        byte[] message02 = new byte[]{-52, 65, -80, -75, 36, 78, -75, -117, 116, 65};

        // 192
        byte[] message11 = new byte[]{-84, 85, 95, 96, -108, -76, -127, -99, 106, 25, -47, 31, 118, 48, 31, 78, 63, 33, 61, 36, -118, 72, -55, -52, -31, -125, -63, -44, -128, -78, -56, 78};

        byte[] message12 = new byte[]{48, 74, 115, 73, 115, 55, 110, 57, 85, 121, 55, 70, 78, 90, 78, 57, 116, 65};

        String s = new String(message02, "UTF-8");
        System.out.println(s);
    }

    @Test
    public void JsonParse1() {
        String json = "{\"method\":\"checkOut\",\"seatCall\":\"{\\\"callCheckOut\\\":true,\\\"id\\\":\\\"76031d502fd44e9589a2c69646b94263\\\",\\\"updateTime\\\":1690023336145}\"}";
        SeatCallQueueMsg seatCallQueueMsg = JSONObject.parseObject(json, SeatCallQueueMsg.class);

        System.out.println(seatCallQueueMsg);
    }
}

class SeatCallQueueMsg implements Serializable {
    private static final long serialVersionUID = 1L;

    String method;
    String seatCall;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getSeatCall() {
        return seatCall;
    }

    public void setSeatCall(String seatCall) {
        this.seatCall = seatCall;
    }

    public SeatCallQueueMsg(String method, String seatCall) {
        this.method = method;
        this.seatCall = seatCall;
    }

    @Override
    public String toString() {
        return "SeatCallQueueMsg{" +
                "method='" + method + '\'' +
                ", seatCall=" + seatCall +
                '}';
    }
}