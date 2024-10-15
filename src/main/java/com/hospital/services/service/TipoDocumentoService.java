package com.hospital.services.service;

import com.hospital.controller.request.TipoDocumentoRequest;
import com.hospital.controller.response.TipoDocumentoResponse;
import com.hospital.entitys.TipoDocumento;

import java.util.List;

public interface TipoDocumentoService {

    List<TipoDocumento> listarTiposDeDocumentos();
    void guardarTiposDeDocumentos(TipoDocumentoRequest tipoDocumentoRequest);
    void eliminarTiposDeDocumentos(Long id);
    void actualizarTiposDeDocumentos(TipoDocumentoRequest tipoDocumentoRequest);
    TipoDocumentoResponse consultarTiposDeDocumentos(Long id);
}
