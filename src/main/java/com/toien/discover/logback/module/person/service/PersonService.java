package com.toien.discover.logback.module.person.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.toien.discover.logback.module.person.dao.PersonDao;

public class PersonService {
	
	private static final Logger logger = LoggerFactory.getLogger(PersonService.class);
	
	private PersonDao personDao = new PersonDao();
	
	public void save() {
		personDao.save();
	}
}
