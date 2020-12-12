package com.kerux.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.kerux.bean.Clinic;


public class ClinicController {
	List<Clinic> clinics;

	
	
	public List<Clinic> getClinics() {
		return clinics;
	}



	public void setClinics(List<Clinic> clinics) {
		this.clinics = clinics;
	}



	public String display() {
		HttpServletRequest request=ServletActionContext.getRequest();
				
				clinics=GuestControllerDB.getClinics();
				return "success";
	}
}
