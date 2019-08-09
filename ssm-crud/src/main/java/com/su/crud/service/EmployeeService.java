package com.su.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.su.crud.bean.Employee;
import com.su.crud.dao.EmployeeMapper;

@Service
public class EmployeeService {

	@Autowired
	EmployeeMapper employeeMapper;
	
	/**
	 * ��ѯ����Ա��
	 * @return
	 */
	public List<Employee> getAll() {
		return employeeMapper.selectByExampleWithDept(null);
	}
}
