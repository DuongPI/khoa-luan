package tienganhmienphi.com.backend.Springboot.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "quizz")
public class QuizzEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String question;

    @ManyToOne
    @JoinColumn(name = "test_id")
    private TestEntity test;

    @OneToMany(mappedBy = "quizz", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<AnswerEntity> answers = new ArrayList<>();

}
