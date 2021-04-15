package tienganhmienphi.com.backend.Springboot.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
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

}
