package com.cyn.demo.bean;

import java.io.Serializable;
import java.util.Date;


public class CallTemplateQuestion implements Serializable {
    /**
     * 主键ID
     */
    private String id;

    /**
     * 模板ID
     */
    private String templateId;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新人
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 问题名称
     */
    private String questionValue;

    /**
     * 问题编码
     */
    private String questionKey;

    /**
     * 答案类型
     */
    private String answerType;

    /**
     * 答案内容
     */
    private String answerJson;

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    public String getId() {
        return id;
    }

    /**
     * 主键ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 模板ID
     */
    public String getTemplateId() {
        return templateId;
    }

    /**
     * 模板ID
     */
    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    /**
     * 创建人
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 创建人
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /**
     * 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 更新人
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * 更新人
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 问题名称
     */
    public String getQuestionValue() {
        return questionValue;
    }

    /**
     * 问题名称
     */
    public void setQuestionValue(String questionValue) {
        this.questionValue = questionValue;
    }

    /**
     * 问题编码
     */
    public String getQuestionKey() {
        return questionKey;
    }

    /**
     * 问题编码
     */
    public void setQuestionKey(String questionKey) {
        this.questionKey = questionKey;
    }

    /**
     * 答案类型
     */
    public String getAnswerType() {
        return answerType;
    }

    /**
     * 答案类型
     */
    public void setAnswerType(String answerType) {
        this.answerType = answerType;
    }

    /**
     * 答案内容
     */
    public String getAnswerJson() {
        return answerJson;
    }

    /**
     * 答案内容
     */
    public void setAnswerJson(String answerJson) {
        this.answerJson = answerJson;
    }
}