package com.cyn;

/**
 * @author chenyanan
 * Created by chenyanan on 2020/12/15
 */
public class Demo {
    public static void main(String[] args) {
        // 1 方法可变参数
/*        String[] testArr = new String[2];
        testArr[0] = "a";
        testArr[1] = "b";
        arrayTest(testArr);
*/
        // String 的不可变性
        String s1 = "a";
        String s2 = s1;
        System.out.println(System.identityHashCode(s1));
        System.out.println(s1);
        s2 = s1 + "ef";
        s2 = s1.concat("aaa");
        System.out.println(System.identityHashCode(s2));
        System.out.println(s2);
        System.out.println(s2 == s1);
        System.out.println();

        // 3 StringBuffer or StringBuilder
        StringBuffer stringBuilder = new StringBuffer();
        stringBuilder.append("test");
        System.out.println(System.identityHashCode(stringBuilder));
        System.out.println(stringBuilder);
        stringBuilder.append(" test2");
        System.out.println(System.identityHashCode(stringBuilder));
        System.out.println(stringBuilder);
        System.out.println();
    }

    public static void arrayTest(String... ages) {
        for (String age :
                ages) {
            System.out.println(age);
        }
    }
}
