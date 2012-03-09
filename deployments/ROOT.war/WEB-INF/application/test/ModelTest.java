import static org.junit.Assert.*;

import java.sql.Date;

import models.Comment;
import models.Post;
import models.User;

import org.junit.Test;

import play.test.UnitTest;


public class ModelTest extends UnitTest {

	@Test
	public void modelTest(){
		User user = new User("Diego","Ramirez","diego","1234");
		assertNotNull(user);
		user.save();
		
		//retrieve user data
		User newUser = User.find("username = ?", "diego").first();
		assertNotNull(newUser);
		assertEquals("Diego", newUser.firstname);
		
		//Post
		Date createdAt = new Date(System.currentTimeMillis()/1000);
		Post post = new Post("Un post de prueba", "Lorem Ipsum", newUser, createdAt);
		assertNotNull(post);
		post.save();
		//Retrieve post data
		Post newPost = Post.find("author = ? ", newUser).first();
		assertNotNull(newPost);
		assertEquals("Diego", newPost.author.firstname);
		
		//Comment
		Comment comment = new Comment(newPost, newUser, "este blog no me cabe ni un poco", createdAt);
		assertNotNull(comment);
		comment.save();
		//retrieve comment data
		Comment newComment = Comment.find("post = ?", newPost).first();
		assertNotNull(newComment);
		assertEquals("Diego", newComment.post.author.firstname);
		

	}

}
