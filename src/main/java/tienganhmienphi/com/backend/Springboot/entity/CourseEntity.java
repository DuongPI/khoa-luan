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
@Table(name = "course")
public class CourseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String courseName;

	@Column
	private String shortDescription;

	@Column
	private String description;
	
	@Column  
	private String image;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
    private CourseCategoryEntity category;
	
	@OneToMany(mappedBy = "course")
	private List<ChapterEntity> chapters = new ArrayList<>();
	
	public List<ChapterEntity> getChapters() {
		return chapters;
	}

	public void setChapters(List<ChapterEntity> chapters) {
		this.chapters = chapters;
	}


	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public CourseCategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CourseCategoryEntity category) {
		this.category = category;
	}

	public Long getId() {
		return id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
//	@OneToMany(mappedBy = "course")
//	private List<ChapterEntity> chapters = new ArrayList<>();
	
	
}
