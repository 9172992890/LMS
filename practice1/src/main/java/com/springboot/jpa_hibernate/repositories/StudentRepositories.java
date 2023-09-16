package com.springboot.jpa_hibernate.repositories;

import com.springboot.jpa_hibernate.entities.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
@Transactional
public interface StudentRepositories extends CrudRepository<Student,Integer>{
}
