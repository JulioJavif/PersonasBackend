package com.ler.PersonasBackend.model;


import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "personas")
public class Persona {

    private String name;
    @Id
    private Long id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;
    private String phone;
    private String email;

}
