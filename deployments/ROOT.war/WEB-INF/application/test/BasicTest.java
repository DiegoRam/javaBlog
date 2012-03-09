import org.junit.*;
import java.util.*;

import play.Logger;
import play.test.*;
import models.*;

public class BasicTest extends UnitTest {

    @Test
    public void htmlTest() {
    	
    	String str = " -p- Esta página aún está en contrucción pero mi intención es hacer una bajada de línea de aquellas cosas" +
    			" que son por demas útiles e interesantes pero en la vorágine de nuestro dia a dia se nos pasan por alto," +
    			" o simplemente la descartamos por creerlas demasiados arduas para encararlas.-/p-";
    	
    	String newStr = play.utils.HTML.htmlEscape(str).replace("-p-", "<p>").replace("-/p-", "</p>");
  
    	
    	Logger.info(newStr);
    }

}
