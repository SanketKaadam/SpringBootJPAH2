package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.StudentRepo;
import com.example.demo.model.Student;

//@Controller
@RestController
public class StudentController 
{
	@Autowired
	StudentRepo repo;
	
	@RequestMapping("/")
	public String home()
	{
		return "home.jsp";
	}
	
	@PostMapping(path="/Student", consumes = {"application/json"})
	public Student addStudent(@RequestBody Student Student)
	{
		repo.save(Student);
		return Student;
	}
	
	/*	 @RequestMapping("/getStudent")
	public ModelAndView getStudent(@RequestParam int aid)
	{
		ModelAndView mv = new ModelAndView("showStudent.jsp");
		Student Student = repo.findById(aid).orElse(new Student());
		
		System.out.println(repo.findByTech("Java"));
		System.out.println(repo.findByAidGreaterThan(102));
		System.out.println(repo.findByTechSorted("Java")); 
		mv.addObject(Student);
		return mv; 
	}  
	
	@RequestMapping("/updateStudent")
	public ModelAndView updateStudent(Student Student)
	{
		ModelAndView mv = new ModelAndView("updatedStudents.jsp");
		Student updatedA = repo.save(Student);
		mv.addObject(updatedA);
		return mv;
	} */
	
	@GetMapping(path="/Students" /*,produces = {"application/xml"} */)
	public List<Student> getStudents()
	{
		return repo.findAll();
	}  
	
	@RequestMapping("/Student/{aid}")
	public Optional<Student> getStudent(@PathVariable("aid") int aid)
	{
		return repo.findById(aid);
	}
	
	@SuppressWarnings("deprecation")
	@DeleteMapping(path="/Student/{aid}")
	public String deleteStudent(@PathVariable int aid)
	{
		Student a = repo.getOne(aid);
		repo.delete(a);
		return "deleted";
	}
	
	@PutMapping(path="/Student", consumes = {"application/json"})
	public Student saveOrUpdateStudent(@RequestBody Student Student)
	{
		repo.save(Student);
		return Student;
	}
	
	

}
