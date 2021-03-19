package tienganhmienphi.com.backend.Springboot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "post")
public class PostEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;
	
	@Column
	private String name;
	
	@Column
	private String content;
	
	@Column
	private String shortDecripsion;
	
	@Column
	private String image;
	
	@ManyToOne
	@JoinColumn(name = "postcategoryid")
    private PostCategoryEntity postcategory;

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

	public PostCategoryEntity getPostcategory() {
		return postcategory;
	}

	public void setPostcategory(PostCategoryEntity postcategory) {
		this.postcategory = postcategory;
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

	public String getShortDecripsion() {
		return shortDecripsion;
	}

	public void setShortDecripsion(String shortDecripsion) {
		this.shortDecripsion = shortDecripsion;
	}
	
	
}
