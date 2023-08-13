package in.blogapplication.bindings;


import lombok.Data;

@Data
public class PostForm {
	
	private Integer postId;
	private String title;
	private String dscrp;
	private String content;

}
