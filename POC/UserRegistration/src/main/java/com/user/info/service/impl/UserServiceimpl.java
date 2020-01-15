package com.user.info.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.info.exception.RecordNotFoundException;
import com.user.info.dao.UserRepository;
import com.user.info.model.User;
import com.user.info.service.UserService;

@Service
public class UserServiceimpl implements UserService {
	
	
	@Autowired(required = true)
    private UserRepository userRepository;

	@Override
	public List<User> getAllUsers() throws Exception {
		
		List<User> userList = userRepository.findAll();
		
		if(userList.size()>0) {
			
			return userList;
		}
		else {
			return new ArrayList<User>();
		}
		
	}

	@Override
	public User getUserById(Long id) throws RecordNotFoundException {
		
		Optional<User> user =userRepository.findById(id);
		
		if(user.isPresent()) {
            return user.get();
        }
		
		else {
            throw new RecordNotFoundException("No student record exist for given id",id);
        }
	}

	/*
	 * @Override public User createOrUpdateStudent(User user) throws
	 * RecordNotFoundException {
	 * 
	 * if(user.getId()!=null) { Optional<User> userData =
	 * userRepository.findById(user.getId());
	 * 
	 * if(userData.isPresent()) { User newEntity = userData.get();
	 * newEntity.setEmailId(user.getEmailId());
	 * newEntity.setFirstName(user.getFirstName());
	 * newEntity.setLastName(user.getLastName());
	 * newEntity.setEmailId(user.getEmailId());
	 * 
	 * newEntity = userRepository.save(newEntity);
	 * 
	 * return newEntity; }
	 * 
	 * else { user = userRepository.save(user);
	 * 
	 * return user; } }
	 * 
	 * else { user = userRepository.save(user); return user; } }
	 */
	
	@Override
	public User save(User user) {
		
		if(user.getUserId()!=null) {
			Optional<User> userData =userRepository.findById(user.getUserId());
			if(userData.isPresent()) {
				
				User newEntity = userData.get();
				newEntity.setUserId(user.getUserId());
				newEntity.setFirstName(user.getFirstName());
				newEntity.setLastName(user.getLastName());
				newEntity.setEmailId(user.getEmailId());
				
				newEntity = userRepository.save(newEntity);
				
				 return newEntity;
			}
			
			else { 
			     	
				user = userRepository.save(user);
			 
				return user;
			}//else
		}
		else { 
			
			
			
			user = userRepository.save(user); 
		
		return user; 
		} //esle
	}//save

	/*
	 * @Override public void deleteUserById(Long id) throws RecordNotFoundException
	 * { Optional<User> user = userRepository.findById(id);
	 * 
	 * if(user.isPresent()) { userRepository.deleteById(id); }
	 * 
	 * else { throw new
	 * RecordNotFoundException("No student record exist for given id",id); } }
	 */
	
	@Override
	public void delete(long id) {
		userRepository.deleteById(id);
	}

}
