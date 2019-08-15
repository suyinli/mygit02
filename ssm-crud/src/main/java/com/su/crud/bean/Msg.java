package com.su.crud.bean;

import java.util.HashMap;
import java.util.Map;

import com.github.pagehelper.PageInfo;

/**
 * ͨ�õķ�����
 * @author ER
 *
 */
public class Msg {
	//״̬�룬�Զ��壬200�������������ɹ�
	// 500�������������ʧ��
	private  int code ;
	
	//��ʾ��Ϣ
	private	 String msg;
	
	//�û�Ҫ���ظ������������
	private Map<String , Object> extend = new HashMap<String ,Object>();

	public static Msg success() {
		Msg result = new Msg();
		result.setCode(200);
		result.setMsg("����ɹ���");
		return result ;
	}
	
	public static Msg fail() {
		Msg result = new Msg();
		result.setCode(400);
		result.setMsg("����ʧ�ܣ�");
		return result ;
	}
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Map<String, Object> getExtend() {
		return extend;
	}

	public void setExtend(Map<String, Object> extend) {
		this.extend = extend;
	}

	public Msg add(String key, Object value) {
		// TODO Auto-generated method stub
		this.getExtend().put(key,value);
		return this ;
	}
	
}
