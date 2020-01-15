package com.user.info.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.Data;

@Entity
@Table(name = "USER_DETAILS")
@Data
public class User implements Serializable {
	
	private static final long serialVersionUID = 6447416794596398975L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id",length =10,nullable =false,unique = false)
	private Long userId;
	
	@Column(name = "first_name",length =15,nullable = false)
	@Type(type="string")
	private String firstName;
	
	@Column(name = "last_name",length =10,nullable = false)
	@Type(type="string")
	private String lastName;
	
	@Column(name = "email_id",length =20,nullable = false)
	@Type(type="string")
	private String emailId;

	

}
