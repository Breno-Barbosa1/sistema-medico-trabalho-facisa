package com.sistema_medico.controllers;

import com.sistema_medico.dtos.ConsultaDTO;
import com.sistema_medico.services.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/consultas")
public class ConsultaController {
    
    @Autowired
    ConsultaService service;

    @GetMapping(
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<ConsultaDTO> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "/{id}",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ConsultaDTO findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @PostMapping(
        produces = {
            MediaType.APPLICATION_JSON_VALUE
        },
        consumes = {
            MediaType.APPLICATION_JSON_VALUE
        }
    )
    public ResponseEntity<ConsultaDTO> create(@RequestBody ConsultaDTO consultaDTO) {
        var dto = service.create(consultaDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @PutMapping(
        produces = {
            MediaType.APPLICATION_JSON_VALUE
        },
        consumes = {
            MediaType.APPLICATION_JSON_VALUE
        }
    )
    public ResponseEntity<ConsultaDTO> update(@RequestBody ConsultaDTO consultaDTO) {
        var dto = service.update(consultaDTO);

        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}