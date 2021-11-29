package com.cyn.demo.bean;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author ynchen9
 */

public enum QuestionsAndAnswer {
    /**
     * 满意度
     */
    MYD("myd", "满意度"),
    MY("my", "满意"),
    BMY("bmy", "不满意");
    private String key;
    private String value;

    QuestionsAndAnswer(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getValueByKey(String key) {
        AtomicReference<String> value = new AtomicReference<>();
        QuestionsAndAnswer[] questionsAndAnswers = QuestionsAndAnswer.values();
        Arrays.stream(questionsAndAnswers).forEach(questionsAndAnswer -> {
            if (questionsAndAnswer.key.equals(key)) {
                value.set(questionsAndAnswer.value);
            }
        });
        return value.get();
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}