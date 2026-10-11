package org.example.pagoyaservicioresolucion.dto;

import lombok.Data;
@Data
public class ReclamoDTO {
    private Long numreclamo;
    private Integer estado;
    private String nombreAnalista;
    private String observacion;
}