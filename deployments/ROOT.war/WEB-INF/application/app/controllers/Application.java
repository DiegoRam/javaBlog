package controllers;

import java.util.List;

import play.*;
import play.mvc.*;
import play.mvc.results.NotFound;
import models.Post;


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

}