package models;

import java.util.Date;

import com.google.code.morphia.annotations.Embedded;
import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Reference;
import play.data.validation.Required;
import play.modules.morphia.Model;

@Embedded
public class Comment extends Model {
	
	public Date postedat;
	@Required
	public String text ;
	@Reference
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
	public Comment(User author, String author_name, String text, Date postedat) {
		super();
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
