package com.kerux.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.kerux.bean.Clinic;
import com.kerux.bean.Department;
import com.kerux.bean.Doctor;
import com.kerux.security.Security;
import com.kerux.utility.DBUtility;


public class GuestControllerDB implements DBUtility {
	 
	
	private static Connection getConnection(){
		Connection connection = null;
		
		try{
			Class.forName(Security.decrypt(jdbcDriverName)); //ensure that the library will be loaded to the memory
			//secure database connection string configuration
			connection = DriverManager.getConnection(Security.decrypt(jdbcUrl),
					Security.decrypt(dbUserName),Security.decrypt(dbPassword));
			
		}catch(ClassNotFoundException cfne){
			//should be displayed on a secure error page code
			System.err.println(cfne.getMessage());
		}catch(SQLException sqle){
			System.err.println(sqle.getMessage());
		}
		return connection;
	}
	
	public static List<Department> getDepartments(String clinicid) {
		List<Department> departmentList=new ArrayList<Department>();
		try{
			Connection connection = getConnection();
			PreparedStatement ps = connection.prepareStatement(SELECT_DEPARTMENT_LIST);
			ps.setString(1, clinicid);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Department dept=new Department();  
				dept.setDepartmentId(Integer.parseInt(rs.getString(1)));
				dept.setDepartmentName(rs.getString(2));
				departmentList.add(dept);  
			}
			
			System.out.println("test");
			
		}catch(Exception e){e.printStackTrace();}
		return departmentList;
	}
	
	public static List<Doctor> getDoctors(String clinicid) {
		List<Doctor> doctorList=new ArrayList<Doctor>();
		try{
			Connection connection = getConnection();
			PreparedStatement ps = connection.prepareStatement(SELECT_DOCTOR_LIST);
			ps.setString(1, clinicid);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Doctor doc=new Doctor(); 
				doc.setDoctorid(Integer.parseInt(rs.getString(1)));
				doc.setDoctorfirstname(rs.getString(6));
				doc.setDoctorlastname(rs.getString(7));
				doctorList.add(doc);  
			}
			
		}catch(Exception e){e.printStackTrace();}
		return doctorList;
	}
	
	public static List<Clinic> getClinics() {
		List<Clinic> clinicList=new ArrayList<Clinic>();
		try{
			Connection connection = getConnection();
			PreparedStatement ps = connection.prepareStatement(SELECT_CLINIC_LIST);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Clinic c=new Clinic(); 
				c.setClinicid(Integer.parseInt(rs.getString(1)));
				c.setClinicname(rs.getString(2));
				clinicList.add(c);  
			}
			
		}catch(Exception e){e.printStackTrace();}
		return clinicList;
	}
	/*
	 *   String SELECT_QUEUE="select queue.queue_id from queue " +
            "inner join department on department.department_id = queue.department_id " +
            "inner join doctor on doctor.doctor_id = queue.doctor_id " +
            "where department.name = ? and doctor.name = ? and queue.endtime is null";

    //updated queueing
    String QUEUE_PATIENT = "insert into instance (patient_id, queue_id, queuetype, status, priority) " +
            "values( ? , ? , ? , ?, ?)";
    String SELECT_NEW_INSTANCE = "Select MAX(instance_id) from instance";
    String SELECT_COUNT_QUEUELIST = "Select COUNT(queue_id) from queuelist where queue_id=? and status='Active'";
    String INSERT_QUEUE_LIST = "insert into queuelist (queue_id, instance_id, queuenumber, status) values(?, ?, ?, 'Active')";
    String UPDATE_QUEUE_NUMBER = "update instance set queuenumber = ? where instance_id= ?";


    //IN THE VIEW PAGE TICKET
    String SELECT_QUEUENUMBER="SELECT queuenumber from instance where instance_id=?";

	 */
	
	
	public static String insert(int departmentid,int doctorid,String firstname, String lastname,String contactno){
		boolean condition=false;
		String queuenum="";
		Connection con = getConnection();
		 String query=SELECT_QUEUE;
//		 if(firstname==null){
//			 firstname="";
//		 }
//		 if(lastname==null){
//			 lastname="";
//		 }
//		 if(contactno==null){
//			 contactno="";
//		 }
		 try{
			 PreparedStatement ps = con.prepareStatement(query);
	         ps.setInt(1, departmentid);
	         ps.setInt(2, doctorid);

	         ResultSet rs= ps.executeQuery();

	         while (rs.next()) {
	             String qID=rs.getString(1);
	             try{
	             String query5=INSERT_GUEST;
	             PreparedStatement ps5=con.prepareStatement(query5);
	             ps5.setString(1, firstname);
	             ps5.setString(2, lastname);
	             ps5.setString(3, contactno);
	             ps5.execute();
	             
	             String query6=SELECT_NEW_GUEST;
	             PreparedStatement ps6=con.prepareStatement(query6);
	             ResultSet rs6=ps6.executeQuery();
	             while (rs6.next()){
	            	 String guestid=rs6.getString(1);
	                 String query2=QUEUE_GUEST;
	                 
	                 try{
	                 PreparedStatement ps2 = con.prepareStatement(query2);
	                 ps2.setString(1, guestid);
	                 ps2.setString(2, qID);
	                 ps2.setString(3, "1");
	                 ps2.setString(4, "Active");
	                 ps2.setString(5, "No");

	                 ps2.execute();

	                 String query3=SELECT_NEW_INSTANCE; //GETS THE INSTANCE ID OF THE NEW INSTANCE CREATED
	                 PreparedStatement ps3 = con.prepareStatement(query3);
	                 ResultSet rs1 = ps3.executeQuery();
	                 while(rs1.next()){
	                     String instanceid=rs1.getString(1);//THIS IS THE INSTANCE ID
	                     try{
	                     String query4=SELECT_COUNT_QUEUELIST;//COUNTS THE NUMBER OF PEOPLE ON THE QUEUE SO WE CAN ASSIGN A QUEUE NUMBER
	                     PreparedStatement ps4=con.prepareStatement(query4);
	                     ps4.setString(1,qID);
	                     ResultSet rs2=ps4.executeQuery();
	                     while(rs2.next()){
	                         int count=rs2.getInt(1);
	                         int queuenumber=count+1; //THIS IS THE QUEUE NUMBER
	                         String query7=INSERT_QUEUE_LIST;
	                         PreparedStatement ps7=con.prepareStatement(query7);
	                         ps7.setString(1, qID);
	                         ps7.setString(2, instanceid);
	                         ps7.executeUpdate(); //WE INSERT DATA IN THE QUEUELIST

	                         String query8=UPDATE_QUEUE_NUMBER;
	                         PreparedStatement ps8=con.prepareStatement(query8);
	                         ps8.setInt(1, queuenumber);
	                         ps8.setString(2, instanceid);
	                         ps8.executeUpdate(); //UPDATE INSTANCE SO IT HAS QUEUENUMBER
	                         condition=true;
	                         
	                         queuenum=Integer.toString(queuenumber);
	                     }
	                     }
	                     catch(Exception exce){
	                    	 exce.printStackTrace();
	                    	 System.out.println("4th");
	                    	 queuenum+="4th "+exce.getMessage();
	                     }

	                 }
	                 }catch(Exception exc){
	                	 exc.printStackTrace();
	                	 System.out.println("3rd");
	                	 queuenum+="3rd "+exc.getMessage();
	                 }
	             }
	             }catch(Exception ex){
	            	 ex.printStackTrace();
	            	 System.out.println("2nd");
	            	 queuenum+="2nd "+ex.getMessage();
	             }
	         }
		 }catch(Exception e){
			 e.printStackTrace();
			 System.out.println("1st");
			 queuenum+="1st "+e.getMessage();
		 }
        

		return queuenum;
	}
}
