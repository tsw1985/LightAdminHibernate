package com.gabrielglez.main.config;

import org.lightadmin.api.config.AdministrationConfiguration;
import org.lightadmin.api.config.builder.EntityMetadataConfigurationUnitBuilder;
import org.lightadmin.api.config.builder.FieldSetConfigurationUnitBuilder;
import org.lightadmin.api.config.builder.ScopesConfigurationUnitBuilder;
import org.lightadmin.api.config.builder.ScreenContextConfigurationUnitBuilder;
import org.lightadmin.api.config.unit.EntityMetadataConfigurationUnit;
import org.lightadmin.api.config.unit.FieldSetConfigurationUnit;
import org.lightadmin.api.config.unit.ScopesConfigurationUnit;
import org.lightadmin.api.config.unit.ScreenContextConfigurationUnit;

import com.gabrielglez.main.evenlistener.PersonListener;
import com.gabrielglez.main.model.Person;

//@Administration(Person.class)
public class PersonAdministration extends AdministrationConfiguration<Person> {
	
	public EntityMetadataConfigurationUnit configuration( EntityMetadataConfigurationUnitBuilder configurationBuilder ) {
		 return configurationBuilder
				 .nameField( "name" )
				 .nameField("deleted")
				 .repositoryEventListener(PersonListener.class)
				 .build();
		 }
		 
		public ScreenContextConfigurationUnit screenContext( ScreenContextConfigurationUnitBuilder screenContextBuilder ) {
		 return screenContextBuilder
		 .screenName( "Users Administration" ).build();
		 }
		 
		public FieldSetConfigurationUnit listView( final FieldSetConfigurationUnitBuilder fragmentBuilder ) {
		 return fragmentBuilder
		 .field( "name" ).caption( "First Name" )
		 .field( "deleted" ).caption( "DELETED" )
		 .build();
		 }
		
		//---------------------
		
		@Override
		public ScopesConfigurationUnit scopes(ScopesConfigurationUnitBuilder scopeBuilder) {
			// TODO Auto-generated method stub
			return super.scopes(scopeBuilder);
		}
		
		
}