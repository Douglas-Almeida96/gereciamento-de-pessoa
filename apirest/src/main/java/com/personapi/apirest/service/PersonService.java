package com.personapi.apirest.service;


import com.personapi.apirest.dto.MessageResponseDto;
import com.personapi.apirest.model.Person;
import com.personapi.apirest.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Transactional
    public MessageResponseDto save(Person person) {
        Person savePerson = personRepository.save(person);
        return MessageResponseDto
                .builder()
                .message("person create with id= "+savePerson.getId())
                .build();
    }
}
