package org.suganthan;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;



public interface ColleagueRepository extends MongoRepository<Colleague, String>{

	public List<Colleague> findByName(String name);
	
}
