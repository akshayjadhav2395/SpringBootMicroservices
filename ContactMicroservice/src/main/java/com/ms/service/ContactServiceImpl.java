package com.ms.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ms.model.Contact;

@Service
public class ContactServiceImpl implements ContactServiceI {

	List<Contact> list = List.of(
		       
			 new Contact(1L, "ram123@gmail.com", "Ram", 11L),
	         new Contact(2L, "sham@gmail.com", "Sham", 11L),
	         new Contact(3L, "pranit@gmail.com", "Pranit", 12L),
	         new Contact(4L, "Hemant@gmail.com", "Hemant", 14L)
	    );


	 @Override
	 public List<Contact> getContactsOfUser(Long userId) {
	    
		 return list.stream().filter(contact -> contact.getUserId().equals(userId)).collect(Collectors.toList());
	 }

}
