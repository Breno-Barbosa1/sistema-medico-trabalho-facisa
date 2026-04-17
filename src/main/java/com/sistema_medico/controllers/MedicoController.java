package com.sistema_medico.controllers;

import com.sistema_medico.dtos.MedicoDTO;
import com.sistema_medico.services.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/medicos")
public class MedicoController {

    @Autowired
    MedicoService service;

    @GetMapping(
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<MedicoDTO> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "/{id}",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public MedicoDTO findById(@PathVariable("id") Long id) {
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
    public ResponseEntity<MedicoDTO> create(@RequestBody MedicoDTO medicoDTO) {
        var dto = service.create(medicoDTO);

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
    public ResponseEntity<MedicoDTO> update(@RequestBody MedicoDTO medicoDTO) {
        var dto = service.update(medicoDTO);

        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}