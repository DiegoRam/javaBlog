package controllers;

import models.User;
import play.mvc.With;

@With(Secure.class)
@CRUD.For(User.class)
public class UserAdmin extends CRUD {

}
