package com.gabrielglez.main.Facade.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gabrielglez.main.DAO.PersonDAO;
import com.gabrielglez.main.command.PersonCommand;
import com.gabrielglez.main.Facade.PersonFacade;
import com.gabrielglez.main.model.Person;

//Con @Service definimos nuestra capa de negocio
//Con @Transactional definimos que todos estos metodos se ejecutaran
//como una transaccion
@Service
@Transactional
public class PersonFacadeImpl implements PersonFacade{
	
	private static final Logger logger = LoggerFactory.getLogger(PersonFacadeImpl.class);
	
	//Inyectamos la capa de persistencia, el objeto DAO
	@Autowired
	private PersonDAO personDAOdef;

	@Override
	public Person getPerson(Long id) {
		return personDAOdef.getPerson(id);
	}

	@Override
	public boolean createPerson(PersonCommand personCommand) {
		logger.info("CREANDO PERSONA");
		
		Person persona = personCommandToPerson(personCommand);
		
		return personDAOdef.createPerson(persona);
	}


	private Person personCommandToPerson(PersonCommand personCommand){
		Person person = new Person();
		person.setName(personCommand.getName());
		return person;
	}

	@Override
	public boolean deleteSoft(Long id) {
		logger.info("EN DELETE SOFTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT ******************************");
		return personDAOdef.deleteSoft(id);
	}

	public PersonDAO getPersonDAOdef() {
		return personDAOdef;
	}

	public void setPersonDAOdef(PersonDAO personDAOdef) {
		this.personDAOdef = personDAOdef;
	}

	
	
	
	
}