package com.personapi.apirest.dto.request;

import com.personapi.apirest.model.Phone;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {

    @NotEmpty
    @Size(min = 3, max = 100)
    private String firstName;

    @NotEmpty
    @Size(min = 3, max = 100)
    private String lastName;

    @NotEmpty
    @CPF
    private String cpf;

    private String birthDate;

    @Valid
    @NotEmpty
    private List<Phone> phones;


}
