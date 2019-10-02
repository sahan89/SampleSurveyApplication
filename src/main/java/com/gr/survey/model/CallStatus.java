package com.gr.survey.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "call_status")
public class CallStatus implements Serializable {
    private int id;
    private String callStatus;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "call_status")
    public String getCallStatus() {
        return callStatus;
    }

    public void setCallStatus(String callStatus) {
        this.callStatus = callStatus;
    }
}
