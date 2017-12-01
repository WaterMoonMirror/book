package com.wondersgroup.sdemo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wondersgroup.sdemo.note.bean.Department;
import com.wondersgroup.sdemo.note.bean.Role;
import com.wondersgroup.sdemo.note.bean.User;
import com.wondersgroup.sdemo.note.repository.DepartmentRespository;
import com.wondersgroup.sdemo.note.repository.RoleRespository;
import com.wondersgroup.sdemo.note.repository.UserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SdemoApplicationTests {

	private static Logger logger=LoggerFactory.getLogger(SdemoApplicationTests.class);
	
	@Autowired
	UserRepository userRepository;
	@Autowired
	RoleRespository roleReository;
	@Autowired
	DepartmentRespository departmentRespository;
//	@Before
//	public void initData(){
//		departmentRespository.deleteAll();
//		userRepository.deleteAll();
//		roleReository.deleteAll();
//		Department department =new Department();
//		department.setName("开发部");
//		departmentRespository.save(department);
//		Assert.assertNotNull(department.getId());
//		
//		Role role =new Role();
//		role.setName("admin");
//		roleReository.save(role);
//		Assert.assertNotNull(role.getId());
//		
//		User user =new User();
//		user.setName("user");
//		user.setDepartment(department);
//		user.setCreatedate(new Date());
//		List<Role> roles =roleReository.findAll();
//		Assert.assertNotNull(roles);
//		user.setRoles(roles);
//		userRepository.save(user);
//		Assert.assertNotNull(user.getId());
//		
//	}
	@Before
	public void initData(){
		userRepository.deleteAll();
		roleReository.deleteAll();
		departmentRespository.deleteAll();
		Department department =new Department();
		department.setName("开发部");
		departmentRespository.save(department);
		Assert.assertNotNull(department.getId());
		
		Role role =new Role();
		role.setName("admin");
		roleReository.save(role);
		Assert.assertNotNull(role.getId());
		logger.info(new Date().toString());
		List<User> users=new ArrayList<>();
		for (int i = 0; i < 1000; i++) {
			User user =new User();
			user.setName("user_"+i);
			user.setDepartment(department);
			user.setCreatedate(new Date());
			List<Role> roles =roleReository.findAll();
			Assert.assertNotNull(roles);
			user.setRoles(roles);
			users.add(user);
//			userRepository.save(user);
//			Assert.assertNotNull(user.getId());
		}
		userRepository.save(users);
		logger.info(new Date().toString());
	}
	@Test
	public void contextLoads() {
		
		Pageable pageable=new PageRequest(0,10,new Sort(Sort.Direction.DESC,"id"));
		 Page<User> users = userRepository.findAll(pageable);
		 Assert.assertNotNull(users);
		 for (User user : users.getContent()) {
			logger.info(user.toString());
		}
		
		
	}

}
