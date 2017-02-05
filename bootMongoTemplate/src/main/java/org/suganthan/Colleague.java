package org.suganthan;

import java.util.List;

import org.springframework.data.annotation.Id;


public class Colleague {

	public Colleague() {}
	
	@Id
	private String id;
	private String name;
	private List<Recognition> recognitions;

	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<Recognition> getRecognitions() {
		return recognitions;
	}


	public void setRecognitions(List<Recognition> recognitions) {
		this.recognitions = recognitions;
	}


	@Override
	public String toString() {
		return "Colleague [id=" + id + ", name=" + name + ", recognitions="
				+ recognitions + "]";
	}
	
	
	
}
