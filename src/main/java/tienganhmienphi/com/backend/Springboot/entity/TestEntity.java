package tienganhmienphi.com.backend.Springboot.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "test")
public class TestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String testName;
    @Column
    private String password;
    @OneToMany(mappedBy = "test", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<QuizzEntity> quizzs = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public String getTestName() {
        return testName;
    }

    public String getPassword() {
        return password;
    }

    public List<QuizzEntity> getQuizzs() {
        return quizzs;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setQuizzs(List<QuizzEntity> quizzs) {
        this.quizzs = quizzs;
    }
}
