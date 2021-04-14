package tienganhmienphi.com.backend.Springboot.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

//@Setter
//@Getter
public class TestResponse {
    private Long id;
    private String name;
    private String password;
    private List<QuizzDTO> quizzs = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public List<QuizzDTO> getQuizzs() {
        return quizzs;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setQuizzs(List<QuizzDTO> quizzs) {
        this.quizzs = quizzs;
    }
}
