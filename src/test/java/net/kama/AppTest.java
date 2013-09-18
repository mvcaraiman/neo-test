package net.kama;

import net.kama.model.MyModel;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {
  "classpath:/spring/neo4j-test-config.xml"
})


@RunWith(SpringJUnit4ClassRunner.class)
public class AppTest {
	@Autowired Repo repo ; 

	@Test 
	public void simpleTest() {
		MyModel model = new MyModel();
		model.setText(makeString(4000));
		repo.save(model);
	}
	
	private String makeString(int len){
		final StringBuilder sb = new StringBuilder();
		for (int i = 0 ; i < len ; i++){
			sb.append('*');
		}
		return sb.toString();
	}
}
