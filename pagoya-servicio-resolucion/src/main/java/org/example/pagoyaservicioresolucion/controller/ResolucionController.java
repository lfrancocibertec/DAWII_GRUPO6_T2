package org.example.pagoyaservicioresolucion.controller;

import org.example.pagoyaservicioresolucion.client.ReclamoFeignClient;
import org.example.pagoyaservicioresolucion.dto.ReclamoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/resolucion")
public class ResolucionController {

    @Autowired
    private ReclamoFeignClient feignClient;

    @PostMapping("/{id}")
    public ResponseEntity<Map<String, Object>> resolverReclamo(@PathVariable Long id, @RequestBody ReclamoDTO resolucionInfo) {
        Map<String, Object> response = new HashMap<>();

        try {

            ReclamoDTO reclamoExistente = feignClient.consultarReclamo(id);

            if (reclamoExistente == null) {
                response.put("mensaje", "Error: El reclamo no existe.");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }


            if (resolucionInfo.getEstado() != 2 && resolucionInfo.getEstado() != 3) {
                response.put("mensaje", "Error: El estado debe ser 2 (procedente) o 3 (improcedente).");
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }


            reclamoExistente.setEstado(resolucionInfo.getEstado());
            reclamoExistente.setNombreAnalista(resolucionInfo.getNombreAnalista());
            reclamoExistente.setObservacion(resolucionInfo.getObservacion());


            feignClient.actualizarReclamo(id, reclamoExistente);

            response.put("mensaje", "Éxito: Reclamo resuelto correctamente.");
            response.put("datos_actualizados", reclamoExistente);

            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (Exception e) {
            response.put("mensaje", "Error al comunicarse con el servicio de reclamos o reclamo no encontrado.");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
