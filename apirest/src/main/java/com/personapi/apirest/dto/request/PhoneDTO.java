package com.personapi.apirest.dto.request;

import com.personapi.apirest.enums.TypePhone;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhoneDTO {

    @Enumerated(EnumType.STRING)
    private TypePhone typePhone;

    @NotEmpty
    @Size(min = 13, max = 14)
    private String number;
}
