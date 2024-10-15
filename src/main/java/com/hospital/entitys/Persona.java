package com.hospital.entitys;

import jakarta.persistence.*;
import lombok.*;

@Entity /*persistence*/
@Table(name = "personas") /*persistence*/
@Builder
@Getter/*lombok*/
@Setter/*lombok*/
@AllArgsConstructor/*lombok*/
@NoArgsConstructor/*lombok*/
public class Persona {/*objeto de java*/
    @Id/*persistence*/
    @GeneratedValue(strategy = GenerationType.IDENTITY)/*persistence*/
    @Column(name = "id")/*persistence*/
    private Long id;/*objeto de java*/

    @Column(name = "nombres")/*persistence*/
    private String nombre;/*objeto de java*/

    @Column(name = "Apellidos")/*persistence*/
    private String apellido;/*objeto de java*/

    @ManyToOne
    @JoinColumn(name = "fk_tipo_documento",referencedColumnName = "id")
    private TipoDocumento fk_tipo_documento;/*objeto de java*/

}
