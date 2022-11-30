package com.ms.service;

import java.util.List;

import com.ms.model.Contact;

public interface ContactServiceI {

	public List<Contact> getContactsOfUser(Long userId);
	
}
