package tienganhmienphi.com.backend.Springboot.service;

import tienganhmienphi.com.backend.Springboot.dto.TestResponse;

import java.util.List;

public interface TestService {
    TestResponse findById(long id);
    List<TestResponse> findAll();
    int CountNumberOfDuplicate(List<Long> list1,Long id);
    float checkpoint(List<Long> list1,Long id);
    TestResponse insert(TestResponse testResponse);
    TestResponse update(TestResponse testResponse,long id);
    void delete(long id);
}
