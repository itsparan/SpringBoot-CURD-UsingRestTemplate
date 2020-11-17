package com.rest.rstmp.controller;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import com.rest.rstmp.entity.Student;
@RequestMapping("/rest")
@RestController
public class UserRestTemplateController {

	@Autowired
	private RestTemplate restTemplate;

	// expose "/" that return "Hello World"
	// for testing purpose on url

	@GetMapping("/hello")
	public String sayHello() {
		return "Hello World! Time on server is " + LocalDateTime.now();
	}

	@GetMapping("/studentsapi")
	public List<Object> getAll() {
		
		System.out.println("getmapping through rest templete Controler is working");
		String url = "http://localhost:8080/user/students";
		Object objects = restTemplate.getForObject(url, Object.class);
		return Arrays.asList(objects);

	}
	
	// save method by rest template 
	@PostMapping("/addstudent")
	public Student addstudent(@RequestBody Student newStudent)throws Exception {
		String url = "http://localhost:8080/user/addStudents";
		  RestTemplate restTemplate = new RestTemplate();
			System.out.println("postmaping of rest template"+newStudent);
		/*
		 * Student std=new Student(); std.setStudent_id(0);
		 * std.setStudent_name(newStudent.getStudent_name());
		 * std.setSex(newStudent.getSex()); std.setAge(newStudent.getAge());
		 * std.setBirth_date(newStudent.getBirth_date());
		 * std.setEntry_date(newStudent.getEntry_date());
		 * System.out.println("set value---"+std);
		 * 
		 */
		return restTemplate.postForObject(url, newStudent, Student.class);
	
	}
	
	//delete student details by id
	@DeleteMapping("/dltbyid/{student_id}")
	public String deleteEmployee(@PathVariable("student_id") int student_id) {
		System.out.println("stdid \n"+student_id);
		String deleturl="http://localhost:8080/user/deletbyid/{student_id}";
		 RestTemplate restTemplate = new RestTemplate();
		
		    Map<String, Integer> params = new HashMap<String, Integer>();
		   // params.put("student_id", "{student_id}");
		    params.put("student_id",student_id );
		     
		  restTemplate.delete ( deleturl,  params );
		
		
		return "the given id deleted succesfull--->>>"+params;
	}
	
	//restTemplate for  find student details by student id
@GetMapping("/studentbyid/{student_id}")
	
	public List<Student> getStudent(@PathVariable int student_id) {
	System.out.println("path id is ...---"+student_id);
	String url = "http://localhost:8080/user/students/{student_id}";
	RestTemplate restTemplate = new RestTemplate();
	Map<String, Integer> params = new HashMap<String, Integer>();
	   params.put("student_id",student_id);
	   System.out.println(params.put("student_id",student_id));
	   
	   Student studentResult = restTemplate.getForObject(url, Student.class, params);
	   System.out.println(studentResult.getStudent_name());
	
	System.out.println("student by id --->"+studentResult);
	
	return Arrays.asList(studentResult);
	
}
	
	//  update student details by student id 
	
	
	/*
	 * @PostMapping("/addstudent") public ResponseEntity<String> addStudent(Student
	 * newStudent) { System.out.println("postmaping of rest template");
	 * newStudent.setStudent_id(newStudent.getStudent_id());
	 * newStudent.setStudent_name(newStudent.getStudent_name());
	 * newStudent.setSex(newStudent.getSex());
	 * newStudent.setAge(newStudent.getAge());
	 * newStudent.setBirth_date(newStudent.getBirth_date());
	 * newStudent.setEntry_date(newStudent.getEntry_date());
	 * System.out.println("from controller"+newStudent); URI location =
	 * ServletUriComponentsBuilder.fromCurrentRequest() .path("/{Student_id}")
	 * .buildAndExpand(newStudent.getStudent_id()) .toUri();
	 * 
	 * 
	 * 
	 * 
	 * 
	 */	
	

}
