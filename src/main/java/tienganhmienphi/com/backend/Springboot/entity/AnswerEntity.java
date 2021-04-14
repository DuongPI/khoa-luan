package tienganhmienphi.com.backend.Springboot.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

//@Getter
//@Setter
@Entity
@Table(name = "answer")
public class AnswerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String content;

    @Column
    private boolean isTrue;

    @ManyToOne
    @JoinColumn(name = "quizz_id")
    private QuizzEntity quizz;

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public boolean isTrue() {
        return isTrue;
    }

    public QuizzEntity getQuizz() {
        return quizz;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTrue(boolean aTrue) {
        isTrue = aTrue;
    }

    public void setQuizz(QuizzEntity quizz) {
        this.quizz = quizz;
    }
}
