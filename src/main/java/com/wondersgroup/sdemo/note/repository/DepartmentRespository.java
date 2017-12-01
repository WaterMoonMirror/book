package com.wondersgroup.sdemo.note.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wondersgroup.sdemo.note.bean.Department;
@Repository
public interface DepartmentRespository extends JpaRepository<Department, Long> {

	
}
