package com.personapi.apirest.controller;

import com.personapi.apirest.dto.MessageResponseDto;
import com.personapi.apirest.dto.request.PersonDTO;
import com.personapi.apirest.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

  @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDto create(@RequestBody @Valid PersonDTO personDto){
        return personService.save(personDto);
    }
}
