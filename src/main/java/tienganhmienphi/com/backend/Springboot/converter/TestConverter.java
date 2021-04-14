package tienganhmienphi.com.backend.Springboot.converter;

import org.springframework.stereotype.Component;
import tienganhmienphi.com.backend.Springboot.dto.AnswerDTO;
import tienganhmienphi.com.backend.Springboot.dto.QuizzDTO;
import tienganhmienphi.com.backend.Springboot.dto.TestResponse;
import tienganhmienphi.com.backend.Springboot.entity.AnswerEntity;
import tienganhmienphi.com.backend.Springboot.entity.QuizzEntity;
import tienganhmienphi.com.backend.Springboot.entity.TestEntity;

import java.util.ArrayList;
import java.util.List;

@Component
public class TestConverter {
    public TestResponse toDTO(TestEntity optional){
        TestResponse testResponse = new TestResponse();
        testResponse.setId(optional.getId());
        testResponse.setName(optional.getTestName());
        testResponse.setPassword(optional.getPassword());
        List<QuizzDTO> quizzDTOS = new ArrayList<>();
        for(QuizzEntity quizzEntity:optional.getQuizzs()){
            QuizzDTO quizzDTO = new QuizzDTO();
            quizzDTO.setQuestion(quizzEntity.getQuestion());
            quizzDTO.setId(quizzEntity.getId());
            List<AnswerDTO> answerDTOS = new ArrayList<>();
            for(AnswerEntity answerEntity: quizzEntity.getAnswers()){
                AnswerDTO answerDTO = new AnswerDTO();
                answerDTO.setId(answerEntity.getId());
                answerDTO.setContent(answerEntity.getContent());
                answerDTO.setIstrue(answerEntity.isTrue());
                answerDTOS.add(answerDTO);
            }
            quizzDTO.setAnswers(answerDTOS);
            quizzDTOS.add(quizzDTO);

        }
        testResponse.setQuizzs(quizzDTOS);
        return testResponse;
    }
}
