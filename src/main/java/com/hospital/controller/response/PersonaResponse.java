package com.hospital.controller.response;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonaResponse {
    private Long id;
    private String nombre;
    private String apellido;
    private TipoDocumentoResponse tipoDocumentoResponse;
}
