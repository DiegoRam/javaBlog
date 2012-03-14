package models;

import java.util.Date;
import java.util.List;


import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Reference;

import play.data.validation.MaxSize;
import play.modules.morphia.Model;

@Entity
public class Post extends Model {
	
	public String title;
	@MaxSize(16000)
	public String text ;
	@Reference
	public User author;
	@Reference
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
	@Override
	public String toString(){
		return this.getId().toString() +"-"+ author.firstname + ": " + title ;
	}
}
