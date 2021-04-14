package tienganhmienphi.com.backend.Springboot.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class QuizzDTO {
    private long id;
    private String question;
    private List<AnswerDTO> answers = new ArrayList<>();

    public void setId(long id) {
        this.id = id;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswers(List<AnswerDTO> answers) {
        this.answers = answers;
    }

    public long getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public List<AnswerDTO> getAnswers() {
        return answers;
    }
}
