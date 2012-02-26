package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

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
    
    public static void viewPost(long postId){
    	render();
    }

}