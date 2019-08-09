package com.su.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.su.crud.bean.Employee;
import com.su.crud.service.EmployeeService;

/**
 * 处理 员工的crud请求
 * @author ER
 *
 */

@Controller
public class EmployeeController {
	
	/**
	 * 查询所有员工数据。分页查询
	 * @return
	 */
	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping("/emps")
	public String getEmps(@RequestParam(value="pn",defaultValue = "1")Integer pn ,Model model) {
		//从外面传入一个pn查询的第几页
		
		
		PageHelper.startPage(pn,5);//查询的页码以及每页的大小
		
		List<Employee> emps=employeeService.getAll();
		//分页,将数据分页之后存储在pageinfo中交给页面
		//封装了详细的页面信息和数据
		PageInfo page =new PageInfo(emps,5);//5为连续显示的页数右下角
		model.addAttribute("pageInfo",page);//将查到的数据和分页信息发送给页面
		
		
		return "list";
	}


	
}
