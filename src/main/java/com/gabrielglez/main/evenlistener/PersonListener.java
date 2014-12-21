package com.gabrielglez.main.evenlistener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.event.AbstractRepositoryEventListener;

import com.gabrielglez.main.Facade.PersonFacade;
import com.gabrielglez.main.model.Person;

public class PersonListener extends AbstractRepositoryEventListener<Person> {
	
	private static final Logger logger = LoggerFactory.getLogger(PersonListener.class);
	
	//HERE I CAN NOT INJECT THIS , WHY ????????????????????????????????????????????
	//It is a service in my project.
	@Autowired
	private PersonFacade personFacadeListener;
	
	@Override
	protected void onBeforeLinkDelete(Person parent, Object linked) {
		logger.info("ON BEFORE LINK DELETED PERSON " );
		super.onBeforeLinkDelete(parent, linked);
	}
	
	
	@Override
	protected void onAfterLinkDelete(Person parent, Object linked) {
		logger.info("ON AFTER LINK DELETED PERSON " );
		super.onAfterLinkDelete(parent, linked);
	}

	
	@Override
	protected void onBeforeDelete(Person entity) {
		//super.onBeforeDelete(entity);
		personFacadeListener.deleteSoft(entity.getId());
		logger.info("ON BEFORE DELETE PERSON " + entity.getName());
		
	}
	
	@Override
	protected void onAfterDelete(Person entity) {
		//super.onAfterDelete(entity);
		logger.info("ON AFTER DELETE PERSON " + entity.getName());
	
	}
	
	

}
