package com.personapi.apirest.service;


import com.personapi.apirest.dto.MessageResponseDto;
import com.personapi.apirest.dto.request.PersonDTO;
import com.personapi.apirest.exception.PersonNotFoundException;
import com.personapi.apirest.mapper.PersonMapper;
import com.personapi.apirest.model.Person;
import com.personapi.apirest.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


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
        return getMessageResponseDto(savePerson.getId(), "person create with id= ");
    }

    public List<PersonDTO> getAll() {
        List<Person> person = personRepository.findAll();
        return  person
                .stream()
                .map(personMapper::modelToDto)
                .collect(Collectors.toList());
    }

    public PersonDTO getById(Long id) throws PersonNotFoundException {
        Person person = verifyIfExists(id);
        return personMapper.modelToDto(person);
    }

    public void deleteById(Long id) throws PersonNotFoundException{
        Person person = verifyIfExists(id);
        personRepository.delete(person);
    }

    public MessageResponseDto update(Long id, PersonDTO personDto)
            throws PersonNotFoundException {
        verifyIfExists(id);
        Person person = personMapper.dtoToModel(personDto);
        Person updatePerson = personRepository.save(person);
        return getMessageResponseDto(updatePerson.getId(), "person update with id= ");
    }

    private MessageResponseDto getMessageResponseDto(Long id, String message) {
        return MessageResponseDto
                .builder()
                .message(message+ id)
                .build();
    }

    private Person verifyIfExists(Long id) throws PersonNotFoundException{
        return personRepository.findById(id)
                .orElseThrow(()-> new PersonNotFoundException(id));
    }

}
