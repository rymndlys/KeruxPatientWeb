package com.kerux.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.kerux.controllers.GuestControllerDB;
import com.opensymphony.xwork2.ActionSupport;

public class GuestQueue extends ActionSupport{
	private int departmentId;
	private int doctorid;
	private String firstname;
	private String lastname;
	private String contactno;
	

	public String execute(){
		return "success";
	}
	
	public void validate(){
		System.out.print(departmentId+"/"+doctorid+"/"+firstname+"/"+lastname+"/"+contactno);
		String result=GuestControllerDB.insert(departmentId, doctorid, firstname, lastname, contactno);
		if(result.equals("")){
			
			addActionError("Queue Error");
			
		}
		else{
			addActionMessage(result);
		}
		
		
	}

	

	

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public int getDoctorid() {
		return doctorid;
	}

	public void setDoctorid(int doctorid) {
		this.doctorid = doctorid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getContactno() {
		return contactno;
	}

	public void setContactno(String contactno) {
		this.contactno = contactno;
	}
	

	




}
