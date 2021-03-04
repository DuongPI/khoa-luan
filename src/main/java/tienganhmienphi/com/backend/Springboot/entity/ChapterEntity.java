package tienganhmienphi.com.backend.Springboot.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "chapter")
public class ChapterEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;
	
	@Column
	private String chapterName;
	
	@ManyToOne
	@JoinColumn(name = "course_id")
    private CourseEntity course;
	
	@OneToMany(mappedBy = "chapter")
	private List<LectureEntity> lectures = new ArrayList<>();

	public String getChapterName() {
		return chapterName;
	}

	public void setChapterName(String chapterName) {
		this.chapterName = chapterName;
	}

	public CourseEntity getCourse() {
		return course;
	}

	public void setCourse(CourseEntity course) {
		this.course = course;
	}

	public List<LectureEntity> getLectures() {
		return lectures;
	}

	public void setLectures(List<LectureEntity> lectures) {
		this.lectures = lectures;
	}

	public Long getId() {
		return id;
	}
	
	
	
}
