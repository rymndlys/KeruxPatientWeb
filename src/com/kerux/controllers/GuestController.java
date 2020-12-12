package com.kerux.controllers;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.kerux.bean.Department;
import com.kerux.bean.Doctor;

public class GuestController {
	List<Doctor> doctors;
	List<Department> departments;
	String firstname;
	String lastname;
	String contactno;
	String clinicid;
	
	
	public String getClinicid() {
		return clinicid;
	}
	public void setClinicid(String clinicid) {
		this.clinicid = clinicid;
	}
	public List<Doctor> getDoctors() {
		return doctors;
	}
	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}
	public List<Department> getDepartments() {
		return departments;
	}
	public void setDepartments(List<Department> departments) {
		this.departments = departments;
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
	
	
	public String display() {
		HttpServletRequest request=ServletActionContext.getRequest();
				System.out.println(clinicid);
				departments=GuestControllerDB.getDepartments(clinicid);
				doctors=GuestControllerDB.getDoctors(clinicid);
				return "success";
	}
	
}
