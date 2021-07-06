package com.cyn.demo.pinyin;
import com.alibaba.fastjson.JSONObject;
import com.cyn.demo.bean.TemplateExtendBean;
import net.sourceforge.pinyin4j.PinyinHelper;
import org.junit.Test;

import java.util.List;

/**
 * @Description:
 * @Author: ynchen9
 * @CreateTime: 2021-07-05
 */
public class PinYinDemo {
    /**
     * 得到中文首字母（中国 -> ZG）
     * @return 大写首字母缩写的字符串
     */
    @Test
    public void getPinYinHeadChar() {
        String str = "需要转化的中文  字符ZG串  ";
        String jsonStr = "[{\"name\":\"地区\"},{\"name\":\"业务名称\"}]";
        StringBuilder convert = new StringBuilder();
        for (int j = 0; j < str.length(); j++) {
            char word = str.charAt(j);
            String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word);
            if (pinyinArray != null) {
                convert.append(pinyinArray[0].charAt(0));
            } else {
                convert.append(word);
            }
        }
        System.out.println(convert.toString());
        List<TemplateExtendBean> templateExtendBeans = JSONObject.parseArray(jsonStr, TemplateExtendBean.class);

    }
}
