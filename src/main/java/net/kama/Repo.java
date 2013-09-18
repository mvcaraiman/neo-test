package net.kama;

import net.kama.model.MyModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.support.Neo4jTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class Repo {
	@Autowired
	private Neo4jTemplate template;
	
	public MyModel save(MyModel model){
		return template.save(model);
	}
}
