package controllers;

import play.mvc.With;
import models.Post;

@With(Secure.class)
@CRUD.For(Post.class)
public class PostAdmin extends CRUD {

}
