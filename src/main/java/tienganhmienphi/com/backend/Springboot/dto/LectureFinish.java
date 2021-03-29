package tienganhmienphi.com.backend.Springboot.dto;

import javax.persistence.Column;

public class LectureFinish {
    private Long id;
    private Long lectureID;
    private Long courseID;
    private String username;

    public Long getLectureID() {
        return lectureID;
    }

    public Long getCourseID() {
        return courseID;
    }

    public String getUsername() {
        return username;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setLectureID(Long lectureID) {
        this.lectureID = lectureID;
    }

    public void setCourseID(Long courseID) {
        this.courseID = courseID;
    }


}
