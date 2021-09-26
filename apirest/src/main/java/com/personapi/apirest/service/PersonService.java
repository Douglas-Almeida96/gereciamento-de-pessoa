package com.personapi.apirest.service;


import com.personapi.apirest.dto.MessageResponseDto;
import com.personapi.apirest.dto.request.PersonDTO;
import com.personapi.apirest.mapper.PersonMapper;
import com.personapi.apirest.model.Person;
import com.personapi.apirest.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PersonService {

    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    public MessageResponseDto save(PersonDTO personDTO) {
        Person person= personMapper.dtoToModel(personDTO);
       Person savePerson = personRepository.save(person);
        return MessageResponseDto
                .builder()
                .message("person create with id= "+savePerson.getId())
                .build();
    }
}
