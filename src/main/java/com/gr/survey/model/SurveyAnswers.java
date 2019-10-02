package com.gr.survey.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "survey_answers")
public class SurveyAnswers {
    private int id;
    private int surveyMainId;
    private int questionId;
    private int answerId;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "surveyMainId")
    public int getSurveyMainId() {
        return surveyMainId;
    }

    public void setSurveyMainId(int surveyMainId) {
        this.surveyMainId = surveyMainId;
    }

    @Column(name = "questionId")
    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    @Column(name = "answerId")
    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }
}
