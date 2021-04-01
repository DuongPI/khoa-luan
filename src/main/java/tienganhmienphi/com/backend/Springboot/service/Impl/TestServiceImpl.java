package tienganhmienphi.com.backend.Springboot.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tienganhmienphi.com.backend.Springboot.converter.TestConverter;
import tienganhmienphi.com.backend.Springboot.dto.TestResponse;
import tienganhmienphi.com.backend.Springboot.entity.TestEntity;
import tienganhmienphi.com.backend.Springboot.repository.TestRepository;
import tienganhmienphi.com.backend.Springboot.service.TestService;

@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private TestRepository testRepository;
    @Autowired
    private TestConverter testConverter;

    @Override
    public TestResponse findById(long id) {
        TestEntity optional = testRepository.findById(id).get();
        TestResponse testResponse = testConverter.toDTO(optional);
        return testResponse;
    }
}
