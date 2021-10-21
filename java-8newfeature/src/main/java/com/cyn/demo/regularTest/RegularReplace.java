package com.cyn.demo.regularTest;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description: /
 * . - 除换行符以外的所有字符。
 * ^ - 字符串开头。
 * $ - 字符串结尾。
 * \d,\w,\s - 匹配数字、字符、空格。
 * \D,\W,\S - 匹配非数字、非字符、非空格。
 * [abc] - 匹配 a、b 或 c 中的一个字母。
 * [a-z] - 匹配 a 到 z 中的一个字母。
 * [^abc] - 匹配除了 a、b 或 c 中的其他字母。
 * aa|bb - 匹配 aa 或 bb。
 * ? - 0 次或 1 次匹配。
 * * - 匹配 0 次或多次。
 * + - 匹配 1 次或多次。
 * {n} - 匹配 n次。
 * {n,} - 匹配 n次以上。
 * {m,n} - 最少 m 次，最多 n 次匹配。
 * (expr) - 捕获 expr 子模式,以 \1 使用它。
 * (?:expr) - 忽略捕获的子模式。
 * (?=expr) - 正向预查模式 expr。
 * (?!expr) - 负向预查模式 expr。
 * 注意:特殊符号注意转义
 * @Author: ynchen9
 * @CreateTime: 2021-10-21
 */
public class RegularReplace {

    @Test
    public void testRegularReplace() {
        String regex = "\\$\\{.*?\\}";
        Pattern pattern = Pattern.compile(regex);
        int matchCount = 0;
        Matcher matcher = pattern.matcher("123${qwqwqweqweqweqweeqwee}12${77}3");
        while (matcher.find()) {
            matchCount++;
            String group = matcher.group(0);
            System.out.println(group);
        }
        String c = matcher.replaceFirst("c");
        String s = matcher.replaceAll("cyn");
    }
}
