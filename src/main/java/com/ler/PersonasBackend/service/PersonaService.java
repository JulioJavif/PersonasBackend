package com.ler.PersonasBackend.service;

import com.ler.PersonasBackend.model.Persona;
import com.ler.PersonasBackend.repository.IPersonaRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {

    @Autowired
    private IPersonaRespository iPersonaRespository;

    public Persona savePersona(Persona persona){
        if (persona.getName()==null
                || persona.getId()==null
                || persona.getBirthday()==null
                || iPersonaRespository.existsById(persona.getId())){
            return null;
        }
        return iPersonaRespository.save(persona);
    }

    public Page<Persona> getAllPersonas(Integer page, Integer size, Boolean enablePagination){
        return iPersonaRespository.findAll(enablePagination ? PageRequest.of(page, size): Pageable.unpaged());
    }

    public List<Persona> getListaPersonas(){
        return  iPersonaRespository.findAll();
    }

    public Optional<Persona> findById(Long id){
        return iPersonaRespository.findById(id);
    }

    public void deletePersona(long id){
        iPersonaRespository.deleteById(id);
    }

    public Persona updatePersona(Persona persona){
        if (
                (persona.getName()==null || persona.getId()==null || persona.getBirthday()==null)
                        && iPersonaRespository.existsById(persona.getId())
        ){
            return null;
        }
        return iPersonaRespository.save(persona);
    }

    public boolean existById(long id) {
        return iPersonaRespository.existsById(id);
    }
}
