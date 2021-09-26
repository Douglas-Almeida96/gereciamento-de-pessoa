package com.personapi.apirest.dto;

import com.personapi.apirest.model.Phone;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class PersonDto {


    private String firstName;
    private String lastName;
    private String cpf;
    private LocalDateTime birthday;
    private List<Phone> phones;


}
