package com.gr.survey.view;

import com.gr.survey.model.*;
import com.gr.survey.repository.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.util.Arrays;
import java.util.List;

@Named
@ViewScoped
public class QuestionsView {

    private static final long serialVersionUID = 1L;
    @Autowired
    private QuestionsRepository questionsRepository;
    @Autowired
    private DistrictRepository districtRepository;
    @Autowired
    private CallStatusRepository callStatusRepository;

    private List<Questions> questionsList;
    private List<District> districtList;
    private int selectedCallStatus;
    private List<CallStatus> callStatusList;
    private String[] selectedAnswers;
    private String selectedDistrict;

    @PostConstruct
    public void init() {
        questionsList = questionsRepository.findAllByStatusNot(0);
        districtList = districtRepository.findAll();
        callStatusList = callStatusRepository.findAll();
        System.out.println("districtList ---> " + districtList.size());
    }

    public void saveQuestionsAnswers() {
        System.out.println("-----> " + Arrays.toString(selectedAnswers));
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Welcome " + selectedAnswers.toString()));
    }

    public List<Questions> getQuestionsList() {
        return questionsList;
    }

    public String[] getSelectedAnswers() {
        return selectedAnswers;
    }

    public void setSelectedAnswers(String[] selectedAnswers) {
        this.selectedAnswers = selectedAnswers;
    }

    public List<District> getDistrictList() {
        return districtList;
    }

    public void setDistrictList(List<District> districtList) {
        this.districtList = districtList;
    }

    public String getSelectedDistrict() {
        return selectedDistrict;
    }

    public void setSelectedDistrict(String selectedDistrict) {
        this.selectedDistrict = selectedDistrict;
    }

    public int getSelectedCallStatus() {
        return selectedCallStatus;
    }

    public void setSelectedCallStatus(int selectedCallStatus) {
        this.selectedCallStatus = selectedCallStatus;
    }

    public List<CallStatus> getCallStatusList() {
        return callStatusList;
    }

    public void setCallStatusList(List<CallStatus> callStatusList) {
        this.callStatusList = callStatusList;
    }
}
