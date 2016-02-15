package com.toien.discover.logback.person.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.toien.discover.logback.person.dao.PersonDao;

public class PersonService {
	
	private static final Logger logger = LoggerFactory.getLogger(PersonService.class);
	
	private PersonDao personDao = new PersonDao();
	
	public void save() {
		personDao.save();
	}
}
