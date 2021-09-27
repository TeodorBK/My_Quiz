package com.example.myquiz;

public class QuizModal {
    private String question;
    private String optinon1;
    private String optinon2;
    private String optinon3;
    private String optinon4;
    private String answer;

    public QuizModal(String question, String optinon1, String optinon2, String optinon3, String optinon4, String answer) {
        this.question = question;
        this.optinon1 = optinon1;
        this.optinon2 = optinon2;
        this.optinon3 = optinon3;
        this.optinon4 = optinon4;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOptinon1() {
        return optinon1;
    }

    public void setOptinon1(String optinon1) {
        this.optinon1 = optinon1;
    }

    public String getOptinon2() {
        return optinon2;
    }

    public void setOptinon2(String optinon2) {
        this.optinon2 = optinon2;
    }

    public String getOptinon3() {
        return optinon3;
    }

    public void setOptinon3(String optinon3) {
        this.optinon3 = optinon3;
    }

    public String getOptinon4() {
        return optinon4;
    }

    public void setOptinon4(String optinon4) {
        this.optinon4 = optinon4;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
