package controllers;

public class Security extends Secure.Security {
	
	static boolean authenticate(String username, String password){
		if (username.equals("darkipunchi") && password.equals("samael")){
			return true ;
		} else {
			return false ;
		}
	}

}
