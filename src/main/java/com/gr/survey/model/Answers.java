package com.gr.survey.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "answers")
public class Answers implements Serializable {
    private int id;
    private int questionId;
    private String answer;
    private int status;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "question_id")
    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    @Column(name = "answer")
    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Column(name = "status")
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Answers() {
    }

    public Answers(int id, int questionId, String answer, int status) {
        this.id = id;
        this.questionId = questionId;
        this.answer = answer;
        this.status = status;
    }
}
