package tienganhmienphi.com.backend.Springboot.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tienganhmienphi.com.backend.Springboot.converter.TestConverter;
import tienganhmienphi.com.backend.Springboot.dto.TestResponse;
import tienganhmienphi.com.backend.Springboot.entity.AnswerEntity;
import tienganhmienphi.com.backend.Springboot.entity.QuizzEntity;
import tienganhmienphi.com.backend.Springboot.entity.TestEntity;
import tienganhmienphi.com.backend.Springboot.repository.AnswerRepository;
import tienganhmienphi.com.backend.Springboot.repository.QuizzRepository;
import tienganhmienphi.com.backend.Springboot.repository.TestRepository;
import tienganhmienphi.com.backend.Springboot.service.TestService;
import tienganhmienphi.com.backend.Springboot.utils.Common;
import tienganhmienphi.com.backend.Springboot.utils.CountTheNumberOfDuplicateElements;

import java.util.ArrayList;
import java.util.List;

@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private TestRepository testRepository;
    @Autowired
    private QuizzRepository quizzRepository;
    @Autowired
    private AnswerRepository answerRepository;
    @Autowired
    private TestConverter testConverter;
    @Autowired
    private CountTheNumberOfDuplicateElements countTheNumberOfDuplicateElements;
    @Autowired
    private Common common;
    @Override
    public TestResponse findById(long id) {
        TestEntity optional = testRepository.findById(id).get();
        TestResponse testResponse = testConverter.toDTO(optional);
        return testResponse;
    }

    @Override
    public List<TestResponse> findAll() {
        List<TestEntity> testEntities = testRepository.findAll();
        List<TestResponse> testResponses = new ArrayList<>();
        for(TestEntity entity: testEntities){
            TestResponse testResponse = new TestResponse();
            testResponse.setId(entity.getId());
            testResponse.setName(entity.getTestName());
            testResponse.setPassword(entity.getPassword());
            testResponses.add(testResponse);
        }
        return testResponses;
    }

    @Override
    public int CountNumberOfDuplicate(List<Long> list1,Long id) {
        TestEntity optional = testRepository.findById(id).get();
        List<Long> listAnswer = common.listAnswerisTrue(optional);
        return countTheNumberOfDuplicateElements.Count(listAnswer,list1);
    }

    @Override
    public float checkpoint(List<Long> list1, Long id) {
        return 0;
    }

    @Override
    public TestResponse insert(TestResponse testResponse) {
        TestEntity entity = testRepository.save(testConverter.toEntity(testResponse));
        for(int i = 0 ; i<testResponse.getQuizzs().size(); i++ ){
            QuizzEntity quizzEntity = new QuizzEntity();
            quizzEntity.setTest(entity);
            quizzEntity.setQuestion(testResponse.getQuizzs().get(i).getQuestion());
            quizzEntity = quizzRepository.save(quizzEntity);
            for(int j = 0 ; j<4; j++ ){
                AnswerEntity answerEntity = new AnswerEntity();
                answerEntity.setContent(testResponse.getQuizzs().get(i)
                        .getAnswers().get(j).getContent());
                answerEntity.setQuizz(quizzEntity);
                answerEntity.setTrue(testResponse.getQuizzs().get(i)
                        .getAnswers().get(j).isIstrue());
                answerRepository.save(answerEntity);
            }
        }

        return testConverter.toDTO(testRepository.getOne(entity.getId()));
    }

    @Override
    public TestResponse update(TestResponse testResponse,long id) {
        TestEntity oldentity = testRepository.getOne(id);
        TestEntity newentity = testConverter.toEntity(testResponse,oldentity);
        return testConverter.toDTO(testRepository.save(newentity));
    }

    @Override
    public void delete(long id) {
        testRepository.deleteById(id);
    }
}
