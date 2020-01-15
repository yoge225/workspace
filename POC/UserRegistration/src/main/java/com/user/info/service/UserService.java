package com.user.info.service;

import java.util.List;

import com.info.exception.RecordNotFoundException;
import com.user.info.model.User;

public interface UserService {
	
	  public List<User> getAllUsers() throws Exception;
	  
	  public User getUserById(Long id) throws RecordNotFoundException;
	  
	  //public User createOrUpdateStudent(User user) throws RecordNotFoundException;
	  
	 // public void deleteUserById(Long id) throws RecordNotFoundException;
	  
	  User save(User user);
	  
	  void delete(long id);

}
