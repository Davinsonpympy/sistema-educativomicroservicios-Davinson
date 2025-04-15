package com.example.matriculas_servicio.service;

import java.util.List;

import com.example.matriculas_servicio.entity.Matricula;

public interface MatriculaService {
    List<Matricula> listar();
    Matricula registrar(Matricula matricula);
    Matricula obtener(Long id);
    void eliminar(Long id);
}
