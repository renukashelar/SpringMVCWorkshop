package com.cybage.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.cybage.model.Book;
import com.cybage.model.User;

@Service
public class LoginService {
List<User> userList=new ArrayList<User>();
	
	public LoginService() {
		userList.add(new User("karishmakal@cybage.com","karishma"));
		userList.add(new User("kamlesh@cybage.com", "kamlesh"));
		userList.add(new User("rutuja@cybage.com", "rutuja"));
		
		
	}
	
	

	public User getUser(String username, String password) {
		User user1=userList.stream().filter(user->user.getEmail().equals(username) && user.getPassword().equals(password)).findFirst().get();
		return user1;
		
	}
	 


}
