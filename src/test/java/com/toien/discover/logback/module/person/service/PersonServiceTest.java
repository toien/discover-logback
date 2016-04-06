package com.toien.discover.logback.module.person.service;

import org.junit.Before;
import org.junit.Test;

import com.toien.discover.logback.module.person.service.PersonService;

public class PersonServiceTest {
	
	private PersonService personService;
	
	@Before
	public void setUp() {
		personService = new PersonService();
	}
	
	@Test
	public void testSave() {
		personService.save();
	}

}
