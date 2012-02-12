package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import play.db.jpa.Model;
@Entity
public class Comment extends Model {
	
	public Date postedat;
	@Lob
	public String text ;
	@ManyToOne
	public Post post;
	@ManyToOne
	public User author;
	/**
	 * 
	 * @param post
	 * @param author
	 * @param text
	 * @param postedat
	 */
	public Comment(Post post, User author, String text, Date postedat) {
		super();
		this.post = post;
		this.author = author;
		this.text = text;
		this.postedat = postedat;
	}
	
	
	

}
