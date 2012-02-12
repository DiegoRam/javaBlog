package models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import play.db.jpa.Model;
@Entity
public class Post extends Model {
	
	public String title;
	@Lob
	public String text ;
	@ManyToOne
	public User author;
	@OneToMany(mappedBy = "post" , cascade = CascadeType.ALL)
	public List<Comment> comments ;
	public Date createdat;
	public Date published;
	public Boolean isPublic ;
	/**
	 * 
	 * @param title
	 * @param text
	 * @param author
	 * @param createdat
	 */
	public Post(String title, String text, User author, Date createdat) {
		super();
		this.title = title;
		this.text = text;
		this.author = author;
		this.createdat = createdat;
	}
}
