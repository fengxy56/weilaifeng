package com.demo.entity;

public class Msg {

	private int id;
	private String name;
	private String email;
	private String subject;
	private String message;
	
	
	@Override
	public String toString() {
		return "Msg [email=" + email + ", id=" + id + ", message=" + message
				+ ", name=" + name + ", subject=" + subject + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
