package com.su.crud.test;

import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.su.crud.bean.Employee;
import com.su.crud.dao.DepartmentMapper;
import com.su.crud.dao.EmployeeMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class MapperTest {
	@Autowired
	DepartmentMapper department;
	
	@Autowired
	SqlSession	 sqlSession;
	
	@Test
	public void testCRUD() {
//		System.out.println(department);
		
	//	department.insertSelective(new Department(null,"测试部"));
//		department.insertSelective(new Department(null,"开发部"));
		
		EmployeeMapper mapper =sqlSession.getMapper(EmployeeMapper.class);
		for(int i=0;i<1000;i++) {
			String uid=UUID.randomUUID().toString().substring(0, 5)+""+i;
			mapper.insertSelective(new Employee(null,uid,"M",uid+"@qq.com",1));	
		}
	}
}
