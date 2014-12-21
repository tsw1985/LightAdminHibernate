package com.gabrielglez.main;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;





import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gabrielglez.main.command.PersonCommand;
import com.gabrielglez.main.Facade.PersonFacade;
import com.gabrielglez.main.model.Person;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
		private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
		
		@Inject
		private PersonFacade personFacade;
		
		@RequestMapping(value = "/", method = RequestMethod.GET)
		public ModelAndView home(Locale locale, Model model) {
			logger.info("Welcome home! The client locale is {}.", locale);
			Date date = new Date();
			DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
			String formattedDate = dateFormat.format(date);
			model.addAttribute("serverTime", formattedDate );
			
			return new ModelAndView("home", "command", new Person());
		}
		
		//A este metodo lo llamamos cuando añadimos una persona
		@RequestMapping(value = "/addPerson", method = RequestMethod.POST)
		public ModelAndView addPerson(@ModelAttribute PersonCommand personCommand, Model model) {
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.addObject("result", personFacade.createPerson(personCommand));
			modelAndView.setViewName("home");
			modelAndView.addObject("command", new Person());
			return modelAndView;
		}
		
		@RequestMapping(value = "/getperson/{id}", method = RequestMethod.POST)
		@ResponseBody public Person getPerson(@PathVariable Long id) {
			return personFacade.getPerson(id);
		}

		public PersonFacade getPersonFacade() {
			return personFacade;
		}

		public void setPersonFacade(PersonFacade personFacade) {
			this.personFacade = personFacade;
		}
	
		
		
		
		
}
