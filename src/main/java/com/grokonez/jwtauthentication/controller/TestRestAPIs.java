package com.grokonez.jwtauthentication.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRestAPIs {
	
	@GetMapping("/api/test/user")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public String userAccess() {
		return ">>> User Contents!";
	}

	@GetMapping("/api/test/pm")
	@PreAuthorize("hasRole('PM') or hasRole('ADMIN')")
	public String projectManagementAccess() {
		return ">>> Board Management Project";
	}
	
	@GetMapping("/api/test/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return ">>> Admin Contents";
	}
	
	@PostMapping("/aboutDeveloper")
	@PreAuthorize("hasRole('ADMIN')")
	public Map<String,String> getData() {
		Map<String,String> map=new HashMap<>();
		map.put("Name","Praveen Kumar");
		map.put("Companny","Bcits Pvt Ltd Bangalore");
		map.put("Address","Bhoopsandra RMV 2nd Stage");
		map.put("Mobile","97387169756");
		map.put("Email","praveen.kumar@bcits.in");
		
		return map;
	}
	
	
	@PostMapping("/jvvnl/validationService/SBI")
	@PreAuthorize("hasRole('ADMIN')")
	public String callSecureWeb(@RequestBody String request) {
		System.err.println(request);
		try{
			StringEntity input = new StringEntity(request);
			HttpClient client=new DefaultHttpClient();;
			HttpPost httpRequest = new HttpPost("http://www.jvvnlrms.com:8481/bsmartjvvnl/Jvvnl/ChalanValidation");
			httpRequest.setHeader("Content-Type","application/json");
			httpRequest.setEntity(input);
			HttpResponse response = client.execute(httpRequest);
			String resoponce = new BasicResponseHandler().handleResponse(response);
			System.out.println(resoponce);
			return resoponce;
		}
		catch(Exception e){
			e.printStackTrace();
			return e.getMessage();
		}
		
	}
	
}