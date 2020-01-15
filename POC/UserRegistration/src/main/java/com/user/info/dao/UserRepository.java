 package com.user.info.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.info.model.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User,Long> {
	

}
