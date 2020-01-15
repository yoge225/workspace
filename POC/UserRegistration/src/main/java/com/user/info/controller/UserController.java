package com.user.info.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.info.exception.RecordNotFoundException;
import com.user.info.model.User;
import com.user.info.service.UserService;

@RestController
//@CrossOrigin(origins="http://localhost:4200")  
@RequestMapping(value="/users")  
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getAllUsers() throws Exception {
        List<User> list = userService.getAllUsers();
 
        return new ResponseEntity<List<User>>(list, new HttpHeaders(), HttpStatus.OK);
    }
 
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json") 
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id)
                                          throws RecordNotFoundException{
    	System.out.println("In User Controller");
    	User entity = userService.getUserById(id);
 
    	
        return new ResponseEntity<User>(entity, new HttpHeaders(), HttpStatus.OK);
    }
 
	
    @RequestMapping(value ="/add", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    
	public ResponseEntity<User> create(@RequestBody User user) {
		return new ResponseEntity<User>(userService.save(user), HttpStatus.OK);
	}
    
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT)
	public ResponseEntity<User> update(@PathVariable long id, @RequestBody User user) {
		
    	user.setUserId(id);
		
		return new ResponseEntity<User>(userService.save(user), HttpStatus.OK);
	}

 
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
		userService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	

}
