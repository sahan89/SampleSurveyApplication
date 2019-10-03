package com.gr.survey.view;

import com.gr.survey.model.*;
import com.gr.survey.repository.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
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
    @Autowired
    private ResponseStatusRepository responseStatusRepository;
    @Autowired
    private ResearchNumberRepository researchNumberRepository;
    @Autowired
    private UserRepository userRepository;

    private List<Questions> questionsList;
    private List<District> districtList;
    private int selectedCallStatus;
    private int selectedResponseStatus;
    private String selectedDistrict;
    private int selectedMobileNoId;
    private List<CallStatus> callStatusList;
    private List<ResponseStatus> responseStatusList;
    private List<ResearchNumber> loadMobileNumberList;
    private List<String> selectedAnswers;
    private String comment;
    private String logUsername;

    HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);

    @PostConstruct
    public void init() {
        questionsList = questionsRepository.findAllByStatusNot(0);
        districtList = districtRepository.findAll();
        callStatusList = callStatusRepository.findAll();
        responseStatusList = responseStatusRepository.findAll();
        logUsername = (String) httpSession.getAttribute("username");
        System.out.println("Log Users =====>>> " + logUsername);
    }


    public void loadMobileNumbers() {
        FacesContext message = FacesContext.getCurrentInstance();
        if (selectedDistrict != null && selectedCallStatus != 0) {
            loadMobileNumberList = researchNumberRepository.findAllByDistrictAndCallStatusAndChecked(selectedDistrict, selectedCallStatus, 0);
            message.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Refreshed", "Number list refreshed"));
        } else {
            message.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Refreshing Error", "Number list not refreshed"));
        }
    }

    public void onMobileNoChange() {
        System.out.println("selectedMobileNo ----- " + selectedMobileNoId);
    }

    public void saveQuestionsAnswers() {
        FacesContext messages = FacesContext.getCurrentInstance();
        System.out.println("Comment ----> " + comment);
        System.out.println("Response ----> " + selectedResponseStatus);
        System.out.println("selectedMobileNo ----> " + selectedMobileNoId);
        System.out.println("Log Users =====>>> " + logUsername);
        Users logUser = userRepository.findUsersByUsernameAndStatusNot(logUsername, 0);
        if (logUser != null && logUser.getUsername() != null){
            if (selectedMobileNoId != 0) {
                if (selectedResponseStatus != 0) {
                    System.out.println("################################");
                } else {
                    messages.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Response Status Cannot be NULL", "Response Status Cannot be null"));
                }
            } else {
                messages.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Mobile Number Cannot be NULL", "Mobile Number Cannot be NULL"));
            }
        }else {
            messages.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "User Session Out.! Please re login to your account.!", ""));
        }

      /*  System.out.println("-----> " + selectedAnswers.size());
        for (String selectedAnswer : selectedAnswers) {
            System.out.println("A----> " + selectedAnswer);
        }
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Welcome " + selectedAnswers.toString()));*/
    }

    public List<Questions> getQuestionsList() {
        return questionsList;
    }

    public List<String> getSelectedAnswers() {
        return selectedAnswers;
    }

    public void setSelectedAnswers(List<String> selectedAnswers) {
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

    public List<ResearchNumber> getLoadMobileNumberList() {
        return loadMobileNumberList;
    }

    public void setLoadMobileNumberList(List<ResearchNumber> loadMobileNumberList) {
        this.loadMobileNumberList = loadMobileNumberList;
    }

    public int getSelectedResponseStatus() {
        return selectedResponseStatus;
    }

    public void setSelectedResponseStatus(int selectedResponseStatus) {
        this.selectedResponseStatus = selectedResponseStatus;
    }

    public List<ResponseStatus> getResponseStatusList() {
        return responseStatusList;
    }

    public void setResponseStatusList(List<ResponseStatus> responseStatusList) {
        this.responseStatusList = responseStatusList;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getSelectedMobileNoId() {
        return selectedMobileNoId;
    }

    public void setSelectedMobileNoId(int selectedMobileNoId) {
        this.selectedMobileNoId = selectedMobileNoId;
    }

    public String getLogUsername() {
        return logUsername;
    }

    public void setLogUsername(String logUsername) {
        this.logUsername = logUsername;
    }

    public HttpSession getHttpSession() {
        return httpSession;
    }

    public void setHttpSession(HttpSession httpSession) {
        this.httpSession = httpSession;
    }
}
