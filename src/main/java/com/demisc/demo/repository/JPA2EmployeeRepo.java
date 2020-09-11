package com.demisc.demo.repository;

import com.demisc.demo.model.Employee;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface JPA2EmployeeRepo extends PagingAndSortingRepository<Employee, Integer> {
    List<Employee> findEmployeeByName(String name);
    @Transactional
    int deleteByName(String name);

    @Query("select e from Employee  e where e.name like :fname")
    List<Employee> getEmployeeLike(@Param("fname") String name);

    @Modifying
    @Query("update Employee set name= ?1 where id = ?2")
    @Transactional
    int updatename(String name , Integer id);


}
