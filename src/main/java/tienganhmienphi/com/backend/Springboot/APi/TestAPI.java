package tienganhmienphi.com.backend.Springboot.APi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tienganhmienphi.com.backend.Springboot.service.TestService;

import java.util.List;

@RestController
public class TestAPI {
    @Autowired
    private TestService testService;

    @PostMapping("/api/v1/test/{id}")
    public ResponseEntity<?> getPasswordOfTest(@PathVariable("id") Long id) {
        return ResponseEntity.ok(testService.findById(id).getPassword());
    }

    @PostMapping("/api/v1/test/point")
    public ResponseEntity<?> ApiUser(@RequestBody List<Long> list) {
        float a = (((float)testService.CountNumberOfDuplicate(list,1l))/(int)4 *1000)/100;
        return ResponseEntity.ok(a);
    }
}
