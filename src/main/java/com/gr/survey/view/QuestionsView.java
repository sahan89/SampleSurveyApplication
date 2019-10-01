package com.gr.survey.view;

import com.gr.survey.model.Answers;
import com.gr.survey.model.Questions;
import com.gr.survey.repository.AnswersRepository;
import com.gr.survey.repository.QuestionsRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import java.util.List;

@Named
@ViewScoped
public class QuestionsView {

    private static final long serialVersionUID = 1L;
    @Autowired
    private QuestionsRepository questionsRepository;
    private List<Questions> questionsList;

    @PostConstruct
    public void init() {
        questionsList = questionsRepository.findAllByStatusNot(0);
    }

    public List<Questions> getQuestionsList() {
        return questionsList;
    }
}
