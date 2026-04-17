package com.sistema_medico.services;

import com.sistema_medico.dtos.MedicoDTO;
import com.sistema_medico.entities.Medico;
import com.sistema_medico.exceptions.MedicoNaoEncontradoException;
import com.sistema_medico.mapper.MedicoMapper;
import com.sistema_medico.repositories.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MedicoService {

    @Autowired
    MedicoRepository medicoRepository;

    @Autowired
    MedicoMapper mapper;

    public List<MedicoDTO> findAll() {
        List<Medico> entities = medicoRepository.findAll();

        List<MedicoDTO> dtos = new ArrayList<>();

        for (Medico entity : entities) {
            dtos.add(mapper.MedicoToMedicoDTO(entity));
        }

        return dtos;
    }

    public MedicoDTO findById(Long id) {
        var entity = medicoRepository.findById(id)
            .orElseThrow(() -> new MedicoNaoEncontradoException("Médico não encontrado para o ID: " + id));

        return mapper.MedicoToMedicoDTO(entity);
    }

    public MedicoDTO create(MedicoDTO medicoDTO) {
        if (medicoDTO == null) throw new RuntimeException("O objeto não pode ser nulo ou vazio!");

        var entity = mapper.MedicoDTOToMedico(medicoDTO);

        return mapper.MedicoToMedicoDTO(medicoRepository.save(entity));
    }

    public MedicoDTO update(MedicoDTO medicoDTO) {
        if (medicoDTO == null) throw new RuntimeException("O objeto não pode ser nulo ou vazio!");

        Medico entity = medicoRepository.findById(medicoDTO.getId())
            .orElseThrow(() -> new MedicoNaoEncontradoException("Médico não encontrado para o ID: " + medicoDTO.getId()));

        entity.setNome(medicoDTO.getNome());
        entity.setCpf(medicoDTO.getCpf());
        entity.setEspecializacao(medicoDTO.getEspecializacao());

        return mapper.MedicoToMedicoDTO(medicoRepository.save(entity));
    }

    public void delete(Long id) {
        var entity = medicoRepository.findById(id)
            .orElseThrow(() -> new MedicoNaoEncontradoException("Médico não encontrado para o ID: " + id));

        medicoRepository.delete(entity);
    }
}