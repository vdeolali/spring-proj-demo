package org.play.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}

class CoolContainers{
	private final String id;
	private String name;

	public CoolContainers(String id, String name){
		this.id = id;
		this.name = name;
	}
	public CoolContainers(String name) {
		this.name = name;
		this.id = UUID.randomUUID().toString();
	}
	public String getID() {
		return id;
	}
	public String getName(){
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

@RestController
class RestAPIonContainers {
	private List<CoolContainers> containersList = new ArrayList<CoolContainers>();
	public RestAPIonContainers(){
		containersList.add(new CoolContainers("Red"));
		containersList.add(new CoolContainers("Pink Lady"));
		containersList.add(new CoolContainers("Fuji"));
		containersList.add(new CoolContainers("Gala"));



		System.out.println(containersList);
		//containersList.addAll(List.of(new CoolContainers("Pink Lady")), new CoolContainers("Fuji"), new CoolContainers("Gala"));
	}
	@RequestMapping(value = "/apples", method = RequestMethod.GET)
	Iterable<CoolContainers> getContainers(){
		return containersList;
	}
}