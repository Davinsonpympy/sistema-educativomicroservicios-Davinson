package com.example.matriculas_servicio.cliente;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "asignaturas-servicio", url = "http://localhost:8082/api/asignaturas")
public interface AsignaturaClient {
    @GetMapping("/{id}")
    Object obtenerAsignaturaPorId(@PathVariable("id") Long id);
}