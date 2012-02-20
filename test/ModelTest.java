import static org.junit.Assert.*;

import models.User;

import org.junit.Test;

import play.test.UnitTest;


public class ModelTest extends UnitTest {

	@Test
	public void userTest(){
		User user = new User("Diego","Ramirez","diego","1234");
		assertNotNull(user);
		user.save();
		
		//retrieve user data
		User newUser = User.find("username = ?", "diego").first();
		assertNotNull(newUser);
		assertEquals("Diego", newUser.firstname);
	}
	@Test
	public void commentTest() {
		fail("Not implemented");
	}

}
