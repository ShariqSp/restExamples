import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

class student {
	
	int id;
	String name;
	String password;
	public student() {
	}
	String email;
	public student(int id, String name, String password, String email) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return " id=" + id + "\n name=" + name + "\n password=" + password + "\n email=" + email + "]";
	}
	
	
}

public class JsonSerial 
{
	
   public static void main(String[] args) throws StreamWriteException, DatabindException, IOException {
	
	   student std = new student(123, "shariq", "1234", "shariq@gmail.com");
	   ObjectMapper obj = new ObjectMapper();
	   obj.writeValue(new File("student.json"),std);
	   
	   student stdOut = obj.readValue(new File("student.json"),student.class);
	   System.out.println(stdOut);
}
}
