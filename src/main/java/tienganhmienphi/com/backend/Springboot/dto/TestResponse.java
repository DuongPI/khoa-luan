package tienganhmienphi.com.backend.Springboot.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class TestResponse {
    private Long id;
    private String name;
    private List<QuizzDTO> quizzs = new ArrayList<>();
}
