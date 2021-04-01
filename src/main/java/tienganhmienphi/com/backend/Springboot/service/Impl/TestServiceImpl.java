package tienganhmienphi.com.backend.Springboot.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tienganhmienphi.com.backend.Springboot.converter.TestConverter;
import tienganhmienphi.com.backend.Springboot.dto.TestResponse;
import tienganhmienphi.com.backend.Springboot.entity.TestEntity;
import tienganhmienphi.com.backend.Springboot.repository.TestRepository;
import tienganhmienphi.com.backend.Springboot.service.TestService;
import tienganhmienphi.com.backend.Springboot.utils.Common;
import tienganhmienphi.com.backend.Springboot.utils.CountTheNumberOfDuplicateElements;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private TestRepository testRepository;
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
    public int CountNumberOfDuplicate(List<Long> list1,Long id) {
        TestEntity optional = testRepository.findById(id).get();
        List<Long> listAnswer = common.listAnswerisTrue(optional);
        return countTheNumberOfDuplicateElements.Count(listAnswer,list1);
    }

    @Override
    public float checkpoint(List<Long> list1, Long id) {
        return 0;
    }
}
