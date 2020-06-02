package com.weather.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Service;

import com.weather.pojo.City;




// this is the service class  
@Service
public class CityServices {
	
	
	public HashMap<Integer, String> cities =new HashMap<>();

	public CityServices() {
		this.cities.put(1, "chennai");
	}
	
	public HashMap<Integer, String> getAll()
	{
		return cities;
	}
	public String getOne(int id)
	{
		Iterator it =cities.entrySet().iterator();
		while (it.hasNext())
		{
			@SuppressWarnings("unchecked")
			Map.Entry<Integer,String> e =(Entry<Integer, String>) it.next();
//			System.out.println(e.getKey());
			if(e.getKey()==id)
			{
				
				return e.getValue();
			}
			
		
		}
		return null;
	}
	
	public void cityAdd(City city) 
	{
		cities.put(city.getId(), city.getCity());
		
	}
	
	public void cityUpdate(City city)
	{
		
		@SuppressWarnings("rawtypes")
		Iterator it =cities.entrySet().iterator();
		while (it.hasNext())
		{
		@SuppressWarnings("unchecked")
		Map.Entry<Integer,String> e =(Entry<Integer, String>) it.next();
		if(e.getKey()==city.getId())
		{
			cities.replace(e.getKey(), city.getCity());
		}
		}
		
	}
	public void cityDelete(int id)
	{
			cities.remove(id);	
	}

	
	

}
