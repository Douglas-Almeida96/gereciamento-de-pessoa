package com.personapi.apirest.controller;

import com.personapi.apirest.dto.MessageResponseDto;
import com.personapi.apirest.dto.request.PersonDTO;
import com.personapi.apirest.exception.PersonNotFoundException;
import com.personapi.apirest.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<PersonDTO>> getAll(){
         List<PersonDTO> personDTOS = personService.getAll();
         return ResponseEntity.ok().body(personDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDTO> getById(@PathVariable("id") Long id)
            throws PersonNotFoundException {
        PersonDTO personDTO = personService.getById(id);
        return ResponseEntity.ok().body(personDTO);
    }

    @PutMapping("/{id}")
    public MessageResponseDto update(@PathVariable("id") Long id ,@RequestBody @Valid PersonDTO personDto)
            throws PersonNotFoundException {
        return personService.update(id, personDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id)
            throws PersonNotFoundException {
        personService.deleteById(id);
    }
}
