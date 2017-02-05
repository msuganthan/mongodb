package org.suganthan;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecognitionController {

	@Autowired
	private ColleagueRepository colleagueRepository;
	
	@RequestMapping("/colleagues/{name}")
	public List<Colleague> getRecognition(@PathVariable("name") String name) {
		return colleagueRepository.findByName(name);
	}
	
	@RequestMapping("/colleagues")
	public List<Colleague> getColleagues() {
		return colleagueRepository.findAll();
	}
	
	@PostMapping("/colleagues")
	public ResponseEntity<String> addColleague(@RequestBody Colleague colleague) {
		colleagueRepository.save(colleague);
		System.out.println(colleague+"Saved successfully");
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@DeleteMapping("/colleagues/{name}")
	public ResponseEntity<String> deleteColleague(@PathVariable("name") String name) {
		List<Colleague> colleagues = colleagueRepository.findByName(name);
		if(colleagues.size() == 1) {
            Colleague colleague = colleagues.get(0);
            colleagueRepository.delete(colleague);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
}
