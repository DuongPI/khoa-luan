package tienganhmienphi.com.backend.Springboot.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user_learn")
public class LearnCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @Column
    private Long lectureID;

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public void setLectureID(Long lectureID) {
        this.lectureID = lectureID;
    }

    public void setCourseID(Long courseID) {
        this.courseID = courseID;
    }

    @Column
    private Long courseID;

    public UserEntity getUser() {
        return user;
    }

    public Long getLectureID() {
        return lectureID;
    }

    public Long getCourseID() {
        return courseID;
    }
}
