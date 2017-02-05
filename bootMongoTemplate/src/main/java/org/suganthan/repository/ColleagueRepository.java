package org.suganthan.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.suganthan.model.Colleague;



public interface ColleagueRepository extends MongoRepository<Colleague, String>{

	public List<Colleague> findByName(String name);
	
}
