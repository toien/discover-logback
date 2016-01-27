package com.toien.discover.logback.person.service;

import org.junit.Before;
import org.junit.Test;

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
