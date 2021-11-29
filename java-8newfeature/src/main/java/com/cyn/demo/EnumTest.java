package com.cyn.demo;

import com.cyn.demo.bean.QuestionsAndAnswer;
import org.junit.Test;

/**
 * @Description:
 * @Author: ynchen9
 * @CreateTime: 2021-11-29
 */
public class EnumTest {
    @Test
    public void getV(){
        String key = "MY";
        QuestionsAndAnswer questionsAndAnswer = QuestionsAndAnswer.valueOf(key);
    }
}
