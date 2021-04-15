package tienganhmienphi.com.backend.Springboot.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Setter
@Getter
public class QuizzDTO {
    private long id;
    private String question;
    private List<AnswerDTO> answers = new ArrayList<>();
}
