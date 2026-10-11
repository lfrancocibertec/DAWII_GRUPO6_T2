package org.example.pagoyaservicioreclamos.controller;
import org.example.pagoyaservicioreclamos.entity.Reclamo;
import org.example.pagoyaservicioreclamos.repository.ReclamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/api/reclamos")
public class ReclamoController {

    @Autowired
    private ReclamoRepository repository;

    @PostMapping
    public Reclamo registrar(@RequestBody Reclamo reclamo) {
        return repository.save(reclamo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reclamo> consultar(@PathVariable Long id) {
        Optional<Reclamo> reclamo = repository.findById(id);
        return reclamo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reclamo> actualizar(@PathVariable Long id, @RequestBody Reclamo detallesReclamo) {
        Optional<Reclamo> reclamoExistente = repository.findById(id);
        if(reclamoExistente.isPresent()) {
            Reclamo reclamo = reclamoExistente.get();
            reclamo.setEstado(detallesReclamo.getEstado());
            reclamo.setNombreAnalista(detallesReclamo.getNombreAnalista());
            reclamo.setObservacion(detallesReclamo.getObservacion());
            return ResponseEntity.ok(repository.save(reclamo));
        }
        return ResponseEntity.notFound().build();
    }
}