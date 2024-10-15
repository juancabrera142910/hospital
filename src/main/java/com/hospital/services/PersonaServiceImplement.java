package com.hospital.services;

import com.hospital.controller.request.PersonaRequest;
import com.hospital.controller.response.PersonaResponse;
import com.hospital.controller.response.TipoDocumentoResponse;
import com.hospital.entitys.Persona;
import com.hospital.entitys.TipoDocumento;
import com.hospital.entitys.repository.PersonaRepository;
import com.hospital.services.service.PersonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonaServiceImplement implements PersonaService {

    private final PersonaRepository personaRepository;


    @Override
    public List<Persona> getListPersons() {
        return personaRepository.listPersons();
    }

    @Override
    public void deletePerson(Long id) {
         personaRepository.deleteById(id);
    }

    @Override
    public PersonaResponse searchPerson(Long id) {
        Persona persona = personaRepository.searchPerson(id);
        return  Objects.nonNull(persona) ?
                buildPersonaResponse(persona) :
                PersonaResponse.builder().build();
    }


    @Override
    public void savePerson(PersonaRequest personaRequest) {
        Persona persona = new Persona();
        TipoDocumento tipoDocumento = new TipoDocumento();
        if(Objects.nonNull(personaRequest)){
            tipoDocumento.setId(personaRequest.getFk_tipo_documento());
            persona.setApellido(personaRequest.getApellido());
            persona.setNombre(personaRequest.getNombre());
            persona.setFk_tipo_documento(tipoDocumento);
            personaRepository.save(persona);
        }
    }

    @Override
    public void updatePerson(PersonaRequest personaRequest) {
        if(Objects.nonNull(personaRequest)){
            Optional<Persona> persona = personaRepository.findById(personaRequest.getId());
           if(persona.isPresent()){
               Persona personaActualizar = buildPersonaEntity(personaRequest);
               personaRepository.save(personaActualizar);
           }
        }
    }

    private static Persona buildPersonaEntity(PersonaRequest personaRequest) {
        return Persona.builder()
                .id(personaRequest.getId())
                .apellido(personaRequest.getApellido())
                .nombre(personaRequest.getNombre())
                .fk_tipo_documento(buildTipoDocumentoEntity(personaRequest))
                .build();
    }

    private static TipoDocumento buildTipoDocumentoEntity(PersonaRequest personaRequest) {
        return TipoDocumento.builder()
                .id(personaRequest.getFk_tipo_documento())
                .build();
    }

    private static PersonaResponse buildPersonaResponse(Persona persona) {
        return PersonaResponse.builder()
                .id(persona.getId())
                .nombre(persona.getNombre())
                .apellido(persona.getApellido())
                .tipoDocumentoResponse(buildTipoDocumentoRespose(persona.getFk_tipo_documento()))
                .build();
    }


    private static TipoDocumentoResponse buildTipoDocumentoRespose(TipoDocumento tipoDocumento){
       return TipoDocumentoResponse.builder()
                .id(tipoDocumento.getId())
                .sigla(tipoDocumento.getSigla())
                .descripcion(tipoDocumento.getDescripcion())
                .build();
    }
}
