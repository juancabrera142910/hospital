package com.hospital.entitys.repository;

import com.hospital.entitys.TipoDocumento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TipoDocumentoRespository extends JpaRepository<TipoDocumento,Long> {


    @Query(value = "SELECT * FROM tipo_documentos",nativeQuery = true)
    List<TipoDocumento> listDocumentType();

    @Query(value = "SELECT * FROM tipo_documentos WHERE id=:id",nativeQuery = true)
    TipoDocumento findByDocumentType(@Param("id") Long id);
}
