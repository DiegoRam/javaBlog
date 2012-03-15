import static org.junit.Assert.*;

import java.sql.Date;
import java.util.List;

import models.Comment;
import models.Post;
import models.User;

import org.junit.Test;

import com.google.code.morphia.Key;

import play.test.UnitTest;


public class ModelTest extends UnitTest {

	@Test
	public void modelTest(){
		User user = new User("Diego","Ramirez","diego","1234");
		assertNotNull(user);
		user.save();
		
		//retrieve user data
		//User newUser = User.find("username = ?", "diego").first();
		User newUser = User.q().filter("username =","diego").first();
		assertNotNull(newUser);
		assertEquals("Diego", newUser.firstname);
		
		//Post
		Date createdAt = new Date(System.currentTimeMillis()/1000);
		Post post = new Post("Un post de prueba", "Lorem Ipsum", newUser, createdAt);
		assertNotNull(post);
		post.save();
		//Retrieve post data
		Key<User> usrKey = User.find("firstname","Diego").getKey();
		Post newPost = Post.find("author", usrKey).first();
		
		//Lo que tiene de poderosisimo es que puedo traer una lista de Keys author para trer toda la lista de posta con esos autores
		//como hacer un select in
		//String[] emails = {"greenlaw110@gmail.com", "greenlaw110@hotmail.com"};
		//List<Key<User>> usrKeys = User.find("email in",emails).asKeyList();
		//List<Post> newPosts = Post.q().filter("author in", usrKeys).asList();
		
		
		assertNotNull(newPost);
		assertEquals("Diego", newPost.author.firstname);
		
		//Comment
		
		
		Comment comment = new Comment(newUser,"Diego", "este blog no me cabe ni un poco", createdAt);
		assertNotNull(comment);
		comment.save();
		//retrieve comment data
		Comment newComment = Comment.q().filter("post = ?", newPost).first();
		assertNotNull(newComment);
		assertEquals("Diego", newComment.post.author.firstname);
		

	}

}
