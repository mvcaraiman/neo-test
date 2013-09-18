package net.kama.model;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;

@NodeEntity
public class MyModel {

	@GraphId
	private Long id;

	@Indexed
	private String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;

	}
}
