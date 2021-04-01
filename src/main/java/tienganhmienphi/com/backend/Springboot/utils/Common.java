package tienganhmienphi.com.backend.Springboot.utils;

import org.springframework.stereotype.Component;
import tienganhmienphi.com.backend.Springboot.entity.AnswerEntity;
import tienganhmienphi.com.backend.Springboot.entity.QuizzEntity;
import tienganhmienphi.com.backend.Springboot.entity.TestEntity;

import java.util.ArrayList;
import java.util.List;

@Component
public class Common {
    public List<Long> listAnswerisTrue(TestEntity entity){
        List<Long> list = new ArrayList<>();
        for(QuizzEntity quizzEntity: entity.getQuizzs()){
            for(AnswerEntity answerEntity:quizzEntity.getAnswers()){
                if (answerEntity.isTrue())
                    list.add(answerEntity.getId());
            }
        }
        return list;
    }
}
