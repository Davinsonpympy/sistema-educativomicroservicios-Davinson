package com.example.matriculas_servicio.service.impl;


import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.matriculas_servicio.cliente.AsignaturaClient;
import com.example.matriculas_servicio.cliente.UsuarioClient;
import com.example.matriculas_servicio.entity.Matricula;
import com.example.matriculas_servicio.repository.MatriculaRepository;
import com.example.matriculas_servicio.service.MatriculaService;

@Service
public class MatriculaServiceImpl implements MatriculaService {

    private final MatriculaRepository repository;
    private final UsuarioClient usuarioClient;
    private final AsignaturaClient asignaturaClient;

    public MatriculaServiceImpl(MatriculaRepository repository, UsuarioClient usuarioClient, AsignaturaClient asignaturaClient) {
        this.repository = repository;
        this.usuarioClient = usuarioClient;
        this.asignaturaClient = asignaturaClient;
    }

    @Override
    public List<Matricula> listar() {
        return repository.findAll();
    }

    @Override
    public Matricula registrar(Matricula matricula) {
        Object usuario = usuarioClient.obtenerUsuarioPorId(matricula.getUsuarioId());
        Object asignatura = asignaturaClient.obtenerAsignaturaPorId(matricula.getAsignaturaId());

        if (usuario != null && asignatura != null) {
            matricula.setFechaRegistro(LocalDate.now());
            return repository.save(matricula);
        }
        throw new RuntimeException("Usuario o asignatura no válidos");
    }

    @Override
    public Matricula obtener(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}