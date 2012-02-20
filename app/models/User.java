package models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import play.db.jpa.Model;

/**
 * @author diego
 *
 */
@Entity
public class User extends Model {

	public static enum Role{ADMIN, USER}
	public String firstname;
	public String lastname;
	public String email;
	public String username ;
	public String password ;
	public String fbuser;
	public String token;
	public Role role;
	/**
	 * 
	 * @param firstname
	 * @param lastname
	 * @param username
	 * @param pass
	 */
	public User(String firstname, String lastname, String username, String pass){
		super();
		this.firstname =  firstname ;
		this.lastname = lastname ;
		this.username =  username ;
		this.password = pass ;
		
	}
}
