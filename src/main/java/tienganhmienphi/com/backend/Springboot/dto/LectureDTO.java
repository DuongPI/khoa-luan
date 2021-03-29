package tienganhmienphi.com.backend.Springboot.dto;

public class LectureDTO {
	private Long id;
	private String lectureName;
	private Long chapterID;
	private boolean istrue;

	public boolean isIstrue() {
		return istrue;
	}

	public void setIstrue(boolean istrue) {
		this.istrue = istrue;
	}

	private String lectureVideo;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLectureName() {
		return lectureName;
	}
	public void setLectureName(String lectureName) {
		this.lectureName = lectureName;
	}
	public Long getChapterID() {
		return chapterID;
	}
	public void setChapterID(Long chapterID) {
		this.chapterID = chapterID;
	}
	public String getLectureVideo() {
		return lectureVideo;
	}
	public void setLectureVideo(String lectureVideo) {
		this.lectureVideo = lectureVideo;
	}
	
}
