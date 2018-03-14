package javasrc;

import java.util.ArrayList;
import java.util.Date;

import org.hibernate.validator.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Student {
	
	
	@JsonProperty("student_name")
	private String studentname;
	private String studenthobby;
	
	@Size(min =5, max =20, message ="please provide a {min}  and {max} ")
	private long studentMobile;
	private Date studentDOB;
	private ArrayList<String> studentSkills;
	
	private Address studentAddress;
	// Getters and Setters
	public Address getStudentAddress() {
		return studentAddress;
	}
	public void setStudentAddress(Address studentAddress) {
		this.studentAddress = studentAddress;
	}
	public long getStudentMobile() {
		return studentMobile;
	}
	public void setStudentMobile(long studentMobile) {
		this.studentMobile = studentMobile;
	}
	public Date getStudentDOB() {
		return studentDOB;
	}
	public void setStudentDOB(Date studentDOB) {
		this.studentDOB = studentDOB;
	}
	public ArrayList<String> getStudentSkills() {
		return studentSkills;
	}
	public void setStudentSkills(ArrayList<String> studentSkills) {
		this.studentSkills = studentSkills;
	}
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	public String getStudenthobby() {
		return studenthobby;
	}
	public void setStudenthobby(String studenthobby) {
		this.studenthobby = studenthobby;
	}
	
	

}
