package tienganhmienphi.com.backend.Springboot.service;

import tienganhmienphi.com.backend.Springboot.dto.TestResponse;
import tienganhmienphi.com.backend.Springboot.entity.TestEntity;

import java.util.List;

public interface TestService {
    TestResponse findById(long id);
}
