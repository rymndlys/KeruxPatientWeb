package com.kerux.utility;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface DBUtility {

	//db configuration
	
	String jdbcDriverName = "QW3ELt19wnX4IncON0pytPYjJQ7R7KdcfgTP7pypuKI";
//	String jdbcUrl ="M0E51/D2unw4mOhSexTFX5FvE+LXhXhYKNoMKX5C8MU=";
//	String dbUserName = "werHkYZovpqBYC9AAVuTVw==";
//	String dbPassword = "aliv/jZ2ur6kYXLP+CeJFQ==";
	String jdbcUrl ="zp/kWu5b+tDu/jLr/ghDf2veMxqv/JQmMwuTl0iQsMSemYdqNwSEu1ta4QN1N/8M";
	String dbUserName = "Ehjf9dlWTbKya8EjojsH1A==";
	String dbPassword = "c67l0Ac10jF3rdfZru2uhe9fW0wb6YVnsEYgogo9w/w=";
	
	
	//SQL Statements
    String SELECT_DEPARTMENT_LIST="SELECT Department_ID, Name from department WHERE Status='Active' and clinic_id=? ";
    String SELECT_DOCTOR_LIST="SELECT * from doctor WHERE Status='Active' and clinic_id=? ";
    String SELECT_CLINIC_LIST="SELECT Clinic_ID, clinicName from clinic WHERE Status='Active'";
	  //queueing
    String SELECT_QUEUE="select queue.queue_id from queue " +
            "inner join department on department.department_id = queue.department_id " +
            "inner join doctor on doctor.doctor_id = queue.doctor_id " +
            "where department.department_id = ? and doctor.doctor_id = ? and queue.status != 'Served'";

    

    //updated queueing
    String SELECT_NEW_GUEST="Select MAX(guest_id) from guest";
    String INSERT_GUEST="insert into guest ( firstname, lastname, contactno) " +
            "values( ? , ? , ? )";
    String QUEUE_GUEST = "insert into instance (guest_id, queue_id, queuetype_id, status, priority) " +
            "values( ? , ? , ? , ?, ?)";
    String SELECT_NEW_INSTANCE = "Select MAX(instance_id) from instance";
    String SELECT_COUNT_QUEUELIST = "Select COUNT(queue_id) from queuelist where queue_id=? and status='Active'";
    String INSERT_QUEUE_LIST = "insert into queuelist (queue_id, instance_id, status) values(?, ?, 'Active')";
    String UPDATE_QUEUE_NUMBER = "update instance set queuenumber = ? where instance_id= ?";


    //IN THE VIEW PAGE TICKET
    String SELECT_QUEUENUMBER="SELECT queuenumber from instance where instance_id=?";
}
