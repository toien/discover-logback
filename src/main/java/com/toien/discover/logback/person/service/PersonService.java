package com.toien.discover.logback.person.service;

import com.toien.discover.logback.person.dao.PersonDao;

public class PersonService {
	private PersonDao personDao = new PersonDao();
	
	
	public void save() {
		personDao.save();
	}
}
