package com.gr.survey.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "response_status")
public class ResponseStatus implements Serializable {
    private int id;
    private String responseStatus;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "response_status")
    public String getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(String responseStatus) {
        this.responseStatus = responseStatus;
    }
}
