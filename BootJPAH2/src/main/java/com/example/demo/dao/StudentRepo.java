package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

//import java.util.List;

//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Student;

public interface StudentRepo extends JpaRepository<Student, Integer>
{

  /* List<Student> findByTech(String tech);
	
	List<Student> findByAidGreaterThan(int aid);
	
	@Query("from Student where tech=?1 order by aname")
	List<Student> findByTechSorted(String tech);  */
}
