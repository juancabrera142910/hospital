package com.hospital.controller;

import com.hospital.controller.request.PersonaRequest;
import com.hospital.controller.response.PersonaResponse;
import com.hospital.entitys.Persona;
import com.hospital.services.service.PersonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("person/v1")
@RequiredArgsConstructor
public class PersonaRestController {

    private final PersonaService personaService;

    @GetMapping("/list")
    public ResponseEntity<List<Persona>>  listPersonsApi(){
        List<Persona> personaList = personaService.getListPersons();
        return  new ResponseEntity<>(personaList, HttpStatus.ACCEPTED);
    }

    @GetMapping("/delete")
    public ResponseEntity<String>  deletePersonsApi(@RequestParam(name = "id") Long id){
        personaService.deletePerson(id);
        return ResponseEntity.accepted().body("La accion solicitada se realizo");
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<PersonaResponse>  searchPersonsApi(@PathVariable Long id){
        PersonaResponse personaResponse =  personaService.searchPerson(id);
        return ResponseEntity.accepted().body(personaResponse);
    }

    @PostMapping("/save")
    public ResponseEntity<String> savePersonsApi(@RequestBody PersonaRequest personaRequest){
        personaService.savePerson(personaRequest);
        return ResponseEntity.accepted().body("La accion solicitada se realizo");
    }

    @PostMapping("/update")
    public ResponseEntity<String> updatePersonsApi(@RequestBody PersonaRequest personaRequest){
        personaService.updatePerson(personaRequest);
        return ResponseEntity.accepted().body("La accion solicitada se realizo");
    }

}
