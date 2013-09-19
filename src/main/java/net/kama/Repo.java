package net.kama;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.support.Neo4jTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class Repo {
	@Autowired
	private Neo4jTemplate template;
	
	@Transactional(propagation=Propagation.REQUIRED)
	public MyModel save(MyModel model){
		return template.save(model);
	}
}
