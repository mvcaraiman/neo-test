package net.kama;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {
  "classpath:/spring/neo4j-test-config.xml"
})

@RunWith(SpringJUnit4ClassRunner.class)
public class BugTest {
	@Autowired Repo repo ; 

	@Test 
	public void simpleTest() {
		MyModel model = new MyModel();
		// MVCaraiman : Different error messages based on different string length :
		// 	3853 : chunk header too long
		// 	3910 : Read timed out
		// 	3960 :  Error adding element 8040 text erhxjgwdnkwis ... to index MyModel
		model.setText(makeString(3960)); 
		repo.save(model);
		
	}
	
	private String makeString(int len){
		final StringBuilder sb = new StringBuilder();
		char a = 'a' ; 
		char z = 'z' ;
		for (int i = 0 ; i < len ; i++){
			char x = (char) (a + (int)(Math.random() * (z-a)));
			sb.append('*');
		}
		return sb.toString();
	}
}
