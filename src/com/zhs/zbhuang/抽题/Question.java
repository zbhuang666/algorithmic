package com.zhs.zbhuang.抽题;

public class Question {
    private Integer questionId; //题目ID
    private String questionKnowledge;
    private Integer questionType;  //题目类型 1单选题 2多选题 3判断题
    private Integer questionDifficulty; //1简单  2适中 3困难

    public Integer getQuestionId() {
        return questionId;
    }

    public Question(Integer questionId, String questionKnowledge, Integer questionType, Integer questionDifficulty) {
        this.questionId = questionId;
        this.questionKnowledge = questionKnowledge;
        this.questionType = questionType;
        this.questionDifficulty = questionDifficulty;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getQuestionKnowledge() {
        return questionKnowledge;
    }

    public void setQuestionKnowledge(String questionKnowledge) {
        this.questionKnowledge = questionKnowledge;
    }

    public Integer getQuestionType() {
        return questionType;
    }

    public void setQuestionType(Integer questionType) {
        this.questionType = questionType;
    }

    public Integer getQuestionDifficulty() {
        return questionDifficulty;
    }

    public void setQuestionDifficulty(Integer questionDifficulty) {
        this.questionDifficulty = questionDifficulty;
    }
}
