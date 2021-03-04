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
@Table(name = "lecture")
public class LectureEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;
	
	@Column
	private String lectureName;
	
	@Column 
	private String lectureVideo;
	
	@ManyToOne
	@JoinColumn(name = "chapter_id")
    private ChapterEntity chapter;
	
	@OneToMany(mappedBy = "lecture")
	private List<CommentEntity> comments = new ArrayList<>();

	public String getLectureName() {
		return lectureName;
	}

	public void setLectureName(String lectureName) {
		this.lectureName = lectureName;
	}

	public String getLectureVideo() {
		return lectureVideo;
	}

	public void setLectureVideo(String lectureVideo) {
		this.lectureVideo = lectureVideo;
	}

	public ChapterEntity getChapter() {
		return chapter;
	}

	public void setChapter(ChapterEntity chapter) {
		this.chapter = chapter;
	}

	public List<CommentEntity> getComments() {
		return comments;
	}

	public void setComments(List<CommentEntity> comments) {
		this.comments = comments;
	}

	public Long getId() {
		return id;
	}
	
	
	
	
}
