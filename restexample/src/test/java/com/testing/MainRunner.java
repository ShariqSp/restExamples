package com.testing;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MainRunner 
{
  public static void main(String[] args) throws StreamWriteException, DatabindException, IOException {
	
	  List<Role> ar= new ArrayList();
	  Role r = new Role();
	  ar.add(r);
	  Profile pf = new Profile();
	  Settings s = new Settings();
	  Map<String, Object> obc = new HashMap<String, Object>();
	  obc.put("additionalProperties", s);
	  J2pojo jp = new J2pojo(123, "123", pf, ar, s, obc);
	  ObjectMapper ob = new ObjectMapper();
	  ob.writeValue(new File("user.json"),jp);
	
}
}
