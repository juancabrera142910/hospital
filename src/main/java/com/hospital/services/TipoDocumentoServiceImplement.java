package com.hospital.services;

import com.hospital.controller.request.TipoDocumentoRequest;
import com.hospital.controller.response.TipoDocumentoResponse;
import com.hospital.entitys.TipoDocumento;
import com.hospital.entitys.repository.TipoDocumentoRespository;
import com.hospital.services.service.TipoDocumentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class TipoDocumentoServiceImplement implements TipoDocumentoService {

    private final TipoDocumentoRespository tipoDocumentoRespository;

    @Override
    public List<TipoDocumento> listarTiposDeDocumentos() {
       return tipoDocumentoRespository.listDocumentType();
    }

    @Override
    public void guardarTiposDeDocumentos(TipoDocumentoRequest tipoDocumentoRequest) {
       if(Objects.nonNull(tipoDocumentoRequest)){
               TipoDocumento tipoDocumento =  TipoDocumento.builder()
                       .sigla(tipoDocumentoRequest.getSigla())
                       .descripcion(tipoDocumentoRequest.getDescripcion())
                       .build();
               tipoDocumentoRespository.save(tipoDocumento);
       }
    }

    @Override
    public void eliminarTiposDeDocumentos(Long id) {
        tipoDocumentoRespository.deleteById(id);
    }

    @Override
    public void actualizarTiposDeDocumentos(TipoDocumentoRequest tipoDocumentoRequest) {
        if(Objects.nonNull(tipoDocumentoRequest)){
            TipoDocumento tipoDocumento = TipoDocumento.builder()
                    .sigla(tipoDocumentoRequest.getSigla())
                    .descripcion(tipoDocumentoRequest.getDescripcion())
                     .build();
            tipoDocumentoRespository.save(tipoDocumento);
        }
    }

    @Override
    public TipoDocumentoResponse consultarTiposDeDocumentos(Long id) {
            TipoDocumento tipoDocumento = tipoDocumentoRespository.findByDocumentType(id);
            if(Objects.nonNull(tipoDocumento)){
               return TipoDocumentoResponse.builder()
                        .id(tipoDocumento.getId())
                        .sigla(tipoDocumento.getSigla())
                        .descripcion(tipoDocumento.getDescripcion())
                        .build();
            }
           return TipoDocumentoResponse.builder().build();
    }
}
