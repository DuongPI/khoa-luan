package tienganhmienphi.com.backend.Springboot.APi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tienganhmienphi.com.backend.Springboot.dto.TestResponse;
import tienganhmienphi.com.backend.Springboot.service.TestService;

import java.util.List;

@RestController
public class TestAPI {
    @Autowired
    private TestService testService;

    @GetMapping ("/api/v1/test/{id}")
    public ResponseEntity<?> getPasswordOfTest(@PathVariable("id") Long id) {
        return ResponseEntity.ok(testService.findById(id).getPassword());
    }

    @PostMapping("/api/v1/test/{id}")
    public ResponseEntity<?> getTest(@PathVariable("id") Long id) {
        return ResponseEntity.ok(testService.findById(id));
    }

    @PostMapping("/api/v1/test/{id}/point")
    public ResponseEntity<?> point(@RequestBody List<Long> list,@PathVariable("id") Long id) {
        System.out.println(list.toString());
        float a = (((float)testService.CountNumberOfDuplicate(list,id))/(int)10 *1000)/100;
        return ResponseEntity.ok(a);
    }

    @PostMapping("/api/v1/test")
    public ResponseEntity<?> insert(@RequestBody TestResponse testResponse) {
        return ResponseEntity.ok(testService.insert(testResponse));
    }
    @PutMapping("/api/v1/test/{id}")
    public ResponseEntity<?> update(@RequestBody TestResponse testResponse,@PathVariable("id") Long id) {
        return ResponseEntity.ok(testService.update(testResponse,id));
    }
    @DeleteMapping("/api/v1/test/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        testService.delete(id);
        return ResponseEntity.ok("ok");
    }
}
