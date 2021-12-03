package com.example.demospringbatch.processor;

import com.example.demospringbatch.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import java.util.Locale;


public class PersonItemProcessor implements ItemProcessor<Person, Person> {

    private static final Logger LOG = LoggerFactory.getLogger(PersonItemProcessor.class);

    @Override
    public Person process(Person item) throws Exception {
        Person processedPerson = new Person();
        processedPerson.setFirstName(item.getFirstName().toUpperCase());
        processedPerson.setSurname(item.getSurname().toUpperCase());
        processedPerson.setEmail(item.getEmail());
        processedPerson.setPhone(item.getPhone());
        processedPerson.setAge(item.getAge());
        return processedPerson;
    }
}
