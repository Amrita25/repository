package com.springmvc.formvalidation.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
 
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Student implements Serializable {
 
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="STUDENT_ID")
	private long studentId;

	@Size(min=3, max=30)
    @NotEmpty
    private String firstName;
 
    @Size(min=3, max=30)
    private String lastName;
 
    @NotEmpty
    private String gender;
 
    @DateTimeFormat(pattern="MM/dd/yyyy")
    @Past @NotNull
    private Date dob;
 
    @Email @NotEmpty
    private String email;
 

    private String section;
 

    private String country;
 
 
    @NotEmpty
    @Transient
    private List<String> subjects = new ArrayList<String>();
    
    public Student(long studentId,String firstName,String lastName,String gender,Date dob,String email){
    	this.studentId=studentId;
    	this.firstName=firstName;
    	this.lastName=lastName;
    	this.gender=gender;
    	this.email=email;
    	this.dob=dob;
    }
    public Student(){
    	
    }
 
    public String getFirstName() {
        return firstName;
    }
 
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
 
    public String getLastName() {
        return lastName;
    }
 
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
 
    
 
    public Date getDob() {
        return dob;
    }
 
    public void setDob(Date dob) {
        this.dob = dob;
    }
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
    public String getSection() {
        return section;
    }
 
    public void setSection(String section) {
        this.section = section;
    }
 
    public String getCountry() {
        return country;
    }
 
    public void setCountry(String country) {
        this.country = country;
    }
 
    
 
    public List<String> getSubjects() {
        return subjects;
    }
 
    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }
 
    public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
    public String toString() {
        return "abc";
    }
 
}
