package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import play.data.validation.Required;
import play.db.jpa.Model;
@Entity
public class Comment extends Model {
	
	public Date postedat;
	@Lob
	@Required
	public String text ;
	@ManyToOne
	public Post post;
	@ManyToOne
	public User author;
	@Required
	public String author_firstname;
	
	/**
	 * 
	 * @param post
	 * @param author
	 * @param text
	 * @param postedat
	 */
	public Comment(Post post, User author, String author_name, String text, Date postedat) {
		super();
		this.post = post;
		this.author = author;
		this.text = text;
		this.postedat = postedat;
		this.author_firstname = author_name ;
	}
	@Override
	public String toString(){
		if (this.author != null){
		return author.firstname + ": " + text ;
		} else {
			return this.author_firstname + ": " + text;
		}
	}
	
	
	

}
