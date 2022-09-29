package com.ler.PersonasBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ler.PersonasBackend.model.Persona;

public interface IPersonaRespository extends JpaRepository<Persona, Long> {

}
