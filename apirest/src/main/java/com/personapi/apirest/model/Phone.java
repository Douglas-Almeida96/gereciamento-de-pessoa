package com.personapi.apirest.model;

import com.personapi.apirest.enums.TypePhone;
import lombok.*;

import javax.persistence.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = true)
    private TypePhone typePhone;

    @Column(nullable = true)
    private String number;


}
