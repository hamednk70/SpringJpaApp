package com.demisc.demo.repository;

import com.demisc.demo.model.Student;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface StudentRepo extends PagingAndSortingRepository<Student, Integer> {
}
