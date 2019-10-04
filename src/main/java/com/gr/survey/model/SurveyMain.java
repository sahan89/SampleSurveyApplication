package com.gr.survey.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "survey_main")
public class SurveyMain implements Serializable {
    private int id;
    private String comment;
    private int userId;
    private int researchNoId;
    private Date createdDate;
    private SurveyAnswers surveyAnswers;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "comment")
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Column(name = "created_date")
    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Column(name = "research_no_id")
    public int getResearchNoId() {
        return researchNoId;
    }

    public void setResearchNoId(int researchNoId) {
        this.researchNoId = researchNoId;
    }
}
