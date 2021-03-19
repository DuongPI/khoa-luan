package tienganhmienphi.com.backend.Springboot.dto;

public class PostDTO {
	private long id;
	private String name;
	private String content;
	private String urlname;
	private String image;
	private String imagetobase64;
	private long category;
	private String shortDecripsion;
	public long getCategory() {
		return category;
	}
	public void setCategory(long category) {
		this.category = category;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUrlname() {
		return urlname;
	}
	public void setUrlname(String urlname) {
		this.urlname = urlname;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getImagetobase64() {
		return imagetobase64;
	}
	public void setImagetobase64(String imagetobase64) {
		this.imagetobase64 = imagetobase64;
	}
	public String getShortDecripsion() {
		return shortDecripsion;
	}
	public void setShortDecripsion(String shortDecripsion) {
		this.shortDecripsion = shortDecripsion;
	}
	
	
}
