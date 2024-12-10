package example;

import java.util.Random;

public class userData 
{
	private String username="testingggg";
	private String email="shariq@gmail.com";
	private long mobile=98765432343l;
	private String password="1234";
	private long id;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		Random rn = new Random();
		this.id = rn.nextLong(5);
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
