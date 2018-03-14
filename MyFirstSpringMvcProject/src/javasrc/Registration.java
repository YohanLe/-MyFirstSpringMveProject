package javasrc;

import java.util.ArrayList;

public class Registration {
	
	private  String firstname;
	private String lastname;
	private int ssn;
	private ArrayList<String> title;
	private String phone;
	private String year;
	private String month;
	private String day;
	private String licensetype;
	private String licenceperiod;
	private String occupation;
	private String street;
	private String city;
	private String country;
	private String post_code;
	private String email;
	private String password;
	private String c_password;
	

	// create constructors
	
	public Registration() {
		//Default 
	}
	
	public Registration(String firstname, String lastname,int ssn) {
		this.firstname= firstname;
		this.lastname=lastname;
		this.ssn=ssn;
	}
	
	// Getters and Setters 

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

	public int getSsn() {
		return ssn;
	}

	public void setSsn(int ssn) {
		this.ssn = ssn;
	}

	public ArrayList<String> getTitle() {
		return title;
	}

	public void setTitle(ArrayList<String> title) {
		this.title = title;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getLicensetype() {
		return licensetype;
	}

	public void setLicensetype(String licensetype) {
		this.licensetype = licensetype;
	}

	public String getLicenceperiod() {
		return licenceperiod;
	}

	public void setLicenceperiod(String licenceperiod) {
		this.licenceperiod = licenceperiod;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPost_code() {
		return post_code;
	}

	public void setPost_code(String post_code) {
		this.post_code = post_code;
	}

	public String getEmail() {
		if(email == (getFirstname() + "@gmail.com")) {
			return email;
		}else {
			System.out.println("Please provide email in a correct format");
		}return email;
		
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getC_password() {
		return c_password;
	}

	public void setC_password(String c_password) {
		this.c_password = c_password;
	}
	// Methods to verify email addrees format
	

	
	

}
