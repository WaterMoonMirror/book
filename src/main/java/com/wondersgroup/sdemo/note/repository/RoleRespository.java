package com.wondersgroup.sdemo.note.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wondersgroup.sdemo.note.bean.Role;
import com.wondersgroup.sdemo.note.bean.User;
@Repository
public interface RoleRespository extends JpaRepository<Role, Long> {

	
}
