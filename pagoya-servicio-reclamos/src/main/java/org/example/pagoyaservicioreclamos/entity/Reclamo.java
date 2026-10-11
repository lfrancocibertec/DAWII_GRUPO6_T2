package org.example.pagoyaservicioreclamos.entity;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
public class Reclamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numreclamo;

    private LocalDate fechareclamo;
    private String nomcliente;
    private String ultimos4tarjeta;
    private String motivo;

    private String nombreAnalista = "No asignado";
    private Integer estado = 1;
    private String observacion = "por evaluar";

    @PrePersist
    protected void onCreate() {
        fechareclamo = LocalDate.now();
    }
}