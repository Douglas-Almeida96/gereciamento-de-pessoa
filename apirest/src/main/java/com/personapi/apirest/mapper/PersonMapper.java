package com.personapi.apirest.mapper;

import com.personapi.apirest.dto.request.PersonDTO;
import com.personapi.apirest.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


@Mapper
public interface PersonMapper{


    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
    Person dtoToModel(PersonDTO personDTO);
    PersonDTO modelToDto(Person person);
}
