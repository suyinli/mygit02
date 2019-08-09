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
 * ���� Ա����crud����
 * @author ER
 *
 */

@Controller
public class EmployeeController {
	
	/**
	 * ��ѯ����Ա�����ݡ���ҳ��ѯ
	 * @return
	 */
	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping("/emps")
	public String getEmps(@RequestParam(value="pn",defaultValue = "1")Integer pn ,Model model) {
		//�����洫��һ��pn��ѯ�ĵڼ�ҳ
		
		
		PageHelper.startPage(pn,5);//��ѯ��ҳ���Լ�ÿҳ�Ĵ�С
		
		List<Employee> emps=employeeService.getAll();
		//��ҳ,�����ݷ�ҳ֮��洢��pageinfo�н���ҳ��
		//��װ����ϸ��ҳ����Ϣ������
		PageInfo page =new PageInfo(emps,5);//5Ϊ������ʾ��ҳ�����½�
		model.addAttribute("pageInfo",page);//���鵽�����ݺͷ�ҳ��Ϣ���͸�ҳ��
		
		
		return "list";
	}


	
}
