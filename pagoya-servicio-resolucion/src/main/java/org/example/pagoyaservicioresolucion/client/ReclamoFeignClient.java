package org.example.pagoyaservicioresolucion.client;

import org.example.pagoyaservicioresolucion.dto.ReclamoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "pagoya-servicio-reclamos")
public interface ReclamoFeignClient {
    @GetMapping("/api/reclamos/{id}")
    ReclamoDTO consultarReclamo(@PathVariable("id") Long id);

    @PutMapping("/api/reclamos/{id}")
    ReclamoDTO actualizarReclamo(@PathVariable("id") Long id, @RequestBody ReclamoDTO reclamoDTO);
}
