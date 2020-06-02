package com.weather.controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.service.CityServices;

@RestController
@RequestMapping ("/api/Tamilnadu")
public class WeatherController {
	
	@Autowired
	CityServices service;
	
	@GetMapping(value = "/city/{id}", produces = "application/json" )
	public String getOne(@PathVariable("id") int id)
	{
		
		String weatherUrl="http://api.weatherstack.com/current?access_key=69d4078055bbd7cd01440f7d5cd97ee0&query="+service.getOne(id);
		try {
			URL obj = new URL(weatherUrl);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			int responseCode = con.getResponseCode();
//			checking the connection response code is equal to httpurl connection code
			if (responseCode == HttpURLConnection.HTTP_OK) { // success
				BufferedReader in = new BufferedReader(new InputStreamReader(
						con.getInputStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();

				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				in.close();

				// print result
				return response.toString();
			} else {
				System.out.println("GET request not worked");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "ok";

	
	}
}

