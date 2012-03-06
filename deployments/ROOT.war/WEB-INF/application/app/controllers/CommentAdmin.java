package controllers;

import play.mvc.With;
import models.Comment;

@With(Secure.class)
@CRUD.For(Comment.class)
public class CommentAdmin extends CRUD {

}
