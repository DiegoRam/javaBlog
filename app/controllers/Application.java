package controllers;

import java.sql.Date;
import java.util.List;

import play.*;
import play.data.validation.Required;
import play.mvc.*;
import play.mvc.results.NotFound;
import models.Comment;
import models.Post;
import models.User;


public class Application extends Controller {

    public static void index() {
    	
    	List<Post> newestPosts = Post.find("order by id desc ").fetch(4);
    	  	
        render(newestPosts);
    }
    public static void about() {
        render("@index");
    }
    public static void contact() {
        render("@index");
    }
    
    public static void viewPost(long postid){
    	Post post = Post.findById(postid);
 
    	if (post == null){
    		notFound(); 
    	}else {
			render(post);
		}
	}
    
    public static void saveComment( Long postId, @Required String firstname, @Required String texto){
    	
    	Post post = Post.findById(postId);
    	
    	Comment comment = new Comment(post, null,firstname, texto, new Date(System.currentTimeMillis()));
    	if (validation.hasErrors()){
    		flash.error("Cuac!");
    		render("Application/viewPost.html",post);
    	}
    	comment.save();
    	flash.success("Gracia Amigo!");
    	viewPost(postId);
    }

}