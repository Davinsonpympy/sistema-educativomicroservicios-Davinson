package com.example.matriculas_servicio.controller;

import org.springframework.web.bind.annotation.*;

import com.example.matriculas_servicio.entity.Matricula;
import com.example.matriculas_servicio.service.MatriculaService;

import java.util.List;

@RestController
@RequestMapping("/api/matriculas")

public class MatriculaController {

    private final MatriculaService matriculaService;

    public MatriculaController(MatriculaService matriculaService) {
        this.matriculaService = matriculaService;
    }

    @GetMapping
    public List<Matricula> listar() {
        return matriculaService.listar();
    }

    @PostMapping
    public Matricula registrar(@RequestBody Matricula matricula) {
        return matriculaService.registrar(matricula);
    }

    @GetMapping("/{id}")
    public Matricula obtener(@PathVariable Long id) {
        return matriculaService.obtener(id);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        matriculaService.eliminar(id);
    }
}
