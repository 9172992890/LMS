package com.springboot.libraryManagementSystem.repositories;

import com.springboot.libraryManagementSystem.entities.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface StudentRepository extends CrudRepository<Student,Integer> {
}
