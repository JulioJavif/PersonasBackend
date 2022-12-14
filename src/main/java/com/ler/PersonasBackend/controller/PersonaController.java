package com.ler.PersonasBackend.controller;

import com.ler.PersonasBackend.Handler.ResponseHandler;
import com.ler.PersonasBackend.model.Persona;
import com.ler.PersonasBackend.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/persona")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @RequestMapping()
    public ResponseEntity<Persona> savePersona(@RequestBody Persona persona){
        //System.out.println(persona.getBirthday());
        return ResponseEntity.status(HttpStatus.CREATED).body(personaService.savePersona(persona));
    }

    @GetMapping
    public ResponseEntity<Object> getAllPersonas(
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "50") Integer size,
            @RequestParam(required = false, defaultValue = "false") Boolean enablePagination){
        return ResponseHandler.generateResponse("Lista de usuarios", HttpStatus.OK, personaService.getListaPersonas());
        // Page<Persona>
        //return ResponseEntity.ok(personaService.getAllPersonas(page, size, enablePagination));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Persona>> findById(@PathVariable ("id") Long id){
        personaService.findById(id);
        return ResponseEntity.ok(personaService.findById(id));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deletePersona(@PathVariable ("id") long id){
        if (personaService.existById(id)){
            personaService.deletePersona(id);
            return ResponseEntity.ok(!personaService.existById(id));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
    }

    @PutMapping
    public ResponseEntity<Persona> updatePersona(@RequestBody Persona persona){
        //System.out.println(persona.getBirthday());
        return ResponseEntity.status(HttpStatus.CREATED).body(personaService.updatePersona(persona));
    }

}
