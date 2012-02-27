package controllers;

import play.*;
import play.mvc.*;
import play.mvc.results.NotFound;
import models.Post;


public class Application extends Controller {

    public static void index() {
        render();
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