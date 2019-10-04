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
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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
    @Autowired
    private SurveyMainRepository surveyMainRepository;
    @Autowired
    private SurveyAnswersRepository surveyAnswersRepository;

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
    HashMap<Integer, Integer> selectedQuestionsAndAnswers = new HashMap<>();

    HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);

    @PostConstruct
    public void init() {
        questionsList = questionsRepository.findAllByStatusNot(0);
        districtList = districtRepository.findAll();
        callStatusList = callStatusRepository.findAll();
        responseStatusList = responseStatusRepository.findAll();
        logUsername = (String) httpSession.getAttribute("username");
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
    }

    public void selectingAnswersEvent(int questionId, String a) {
        selectedQuestionsAndAnswers.values().removeIf(val -> val.equals(questionId));
        for (String answerId : selectedAnswers) {
            selectedQuestionsAndAnswers.put(Integer.parseInt(answerId), questionId);
        }
    }

    public void saveQuestionsAnswers() {
        FacesContext messages = FacesContext.getCurrentInstance();

        Users logUser = userRepository.findUsersByUsernameAndStatusNot(logUsername, 0);
        if (logUser != null && logUser.getUsername() != null) {
            SurveyMain savedSurvey = null;
            if (selectedMobileNoId != 0) {
                if (selectedResponseStatus != 0) {
                    ResearchNumber researchNumber = researchNumberRepository.findOne(selectedMobileNoId);
                    researchNumber.setResponseId(selectedResponseStatus);
                    researchNumber.setChecked(1);
                    researchNumber.setCallStatus(selectedCallStatus);
                    ResearchNumber savedResearchNumber = researchNumberRepository.save(researchNumber);
                    if (savedResearchNumber != null && savedResearchNumber.getId() != 0) {
                        SurveyMain surveyMain = new SurveyMain();
                        surveyMain.setComment(comment);
                        surveyMain.setCreatedDate(new Date());
                        surveyMain.setUserId(logUser.getId());
                        surveyMain.setResearchNoId(savedResearchNumber.getId());
                        savedSurvey = surveyMainRepository.save(surveyMain);
                    } else {
                        messages.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Data Saving Error!", "Data Saving Error!"));
                    }
                    if (savedSurvey != null && savedSurvey.getId() != 0) {
                        List<SurveyAnswers> surveyAnswersList = new ArrayList<>();
                        for (int i : selectedQuestionsAndAnswers.keySet()) {
                        SurveyAnswers surveyAnswers = new SurveyAnswers();
                            surveyAnswers.setQuestionId(selectedQuestionsAndAnswers.get(i));
                            surveyAnswers.setAnswerId(i);
                            surveyAnswers.setSurveyMainId(savedSurvey.getId());
                            surveyAnswersList.add(surveyAnswers);
                            System.out.println("key: " + i + " value: " + selectedQuestionsAndAnswers.get(i));
                        }
                        surveyAnswersRepository.save(surveyAnswersList);
                    } else {
                        messages.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Data Saving Error", "Data Saving Error"));
                    }
                    messages.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Successfully Saved!", "Successfully Saved!"));
                } else {
                    messages.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Response Status Cannot be NULL", "Response Status Cannot be null"));
                }
            } else {
                messages.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Mobile Number Cannot be NULL", "Mobile Number Cannot be NULL"));
            }
        } else {
            messages.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "User Session Out.! Please re login to your account.!", ""));
        }
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
