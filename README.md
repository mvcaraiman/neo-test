neo-test
========

Simple example to show a bug in SDN  

My scenario is relatively simple : I have a model called MyModel annotated with org.springframework.data.neo4j.annotation.{GraphId,Indexed,NodeEntity} 
and I want to save it using a Neo4jTemplate. The  entity contains  a field of type String and  I need to save large amount of text in that field and 
the SDN behavior is strange, i.e. I get different error messages based on different string length :
		* 3853 : chunk header too long
		* 3910 : Read timed out
		* 3960 :  Error adding element 8040 text erhxjgwdnkwis ... to index MyModel  
		
Details about environment : 
	* Java version : "1.7.0_25"
	* Maven : apache-maven-3.0.5
	* Neo server : neo4j-community-1.9.2 (Server runs on port 7475 - modify your %server-path%/conf/neo4j-server.properties or, inside this project, the file neo4j-test-config.xml )
	* Spring version : 3.1.4.RELEASE
	* Springframework.data.neo4j version : 2.3.1.RELEASE
	* OS : Windows 7  
	
To reproduce the exception, just run "_mvn test_" with your Neo4j server started.