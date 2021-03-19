package tienganhmienphi.com.backend.Springboot.dto;

public class CourseDTO {
	private Long id;
	private String courseName;
	private String shortDescription;
	private String description;
	private String imageName;
	private String imagetobase64;
	private String urlName;
    private long category;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	
	public long getCategory() {
		return category;
	}
	public void setCategory(long category) {
		this.category = category;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public String getImagetobase64() {
		return imagetobase64;
	}
	public void setImagetobase64(String imagetobase64) {
		this.imagetobase64 = imagetobase64;
	}
	public String getUrlName() {
		return urlName;
	}
	public void setUrlName(String urlName) {
		this.urlName = urlName;
	}
    
}
