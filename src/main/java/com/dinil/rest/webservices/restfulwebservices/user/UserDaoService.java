package com.dinil.rest.webservices.restfulwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<>();
	private static int  userCount = 4;
	static{
		users.add(new User(1,"Dinil",new Date()));
		users.add(new User(2,"Rakhi",new Date()));
		users.add(new User(3,"Vighnesh",new Date()));
		users.add(new User(4,"Vaiga",new Date()));
	}
	
	
	public List<User> findAllUser(){
		return users;
	}
	
	public User saveUser(User user){
		if(user.getId()==null){
			user.setId(++userCount);
			users.add(user);
		}
		return user;
	}
	
	public User findOne(int id){

     for (User user : users) {
		if(user.getId().equals(id)){
			return user;
		}
	 }
		return null;		
	}
	
 public User deleteById(int id){
		
		Iterator<User> userIterator = users.iterator();
		while(userIterator.hasNext()){
			User user = userIterator.next();
			if(user.getId()==id){
				userIterator.remove();
			}
		}
		
		return null;
	}
}
