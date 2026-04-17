package com.sistema_medico.services;

import com.sistema_medico.dtos.ConsultaDTO;
import com.sistema_medico.entities.Consulta;
import com.sistema_medico.entities.Medico;
import com.sistema_medico.exceptions.ConsultaNaoEncontradaException;
import com.sistema_medico.exceptions.MedicoNaoEncontradoException;
import com.sistema_medico.mapper.ConsultaMapper;
import com.sistema_medico.repositories.ConsultaRepository;
import com.sistema_medico.repositories.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConsultaService {

    @Autowired
    ConsultaRepository consultaRepository;

    @Autowired
    MedicoRepository medicoRepository;

    @Autowired
    ConsultaMapper consultaMapper;

    public List<ConsultaDTO> findAll() {
        List<Consulta> entities = consultaRepository.findAll();

        List<ConsultaDTO> dtos = new ArrayList<>();

        for (Consulta entity : entities) {
            var dto = consultaMapper.ConsultaToConsultaDTO(entity);
            dto.setMedicoId(entity.getMedico().getId());
            dtos.add(dto);
        }

        return dtos;
    }

    public ConsultaDTO findById(Long id) {
        var entity = consultaRepository.findById(id)
            .orElseThrow(() -> new ConsultaNaoEncontradaException("Consulta não encontrada para o ID: " + id));

        var dto = consultaMapper.ConsultaToConsultaDTO(entity);
        dto.setMedicoId(entity.getMedico().getId());
        return dto;
    }

    public ConsultaDTO create(ConsultaDTO consultaDTO) {
        if (consultaDTO == null) throw new RuntimeException("O objeto não pode ser nulo ou vazio!");

        var entity = consultaMapper.ConsultaDTOToConsulta(consultaDTO);

        Medico medico = medicoRepository.findById(consultaDTO.getMedicoId())
            .orElseThrow(() -> new ConsultaNaoEncontradaException("Médico não encontrado para o ID: " + consultaDTO.getMedicoId()));

        entity.setMedico(medico);

        var dto = consultaMapper.ConsultaToConsultaDTO(consultaRepository.save(entity));
        dto.setMedicoId(medico.getId());
        return dto;
    }

    public ConsultaDTO update(ConsultaDTO consultaDTO) {
        if (consultaDTO == null) throw new RuntimeException("O objeto não pode ser nulo ou vazio!");

        Consulta consulta = consultaRepository.findById(consultaDTO.getId())
            .orElseThrow(() -> new ConsultaNaoEncontradaException("Consulta não encontrada para o ID: " + consultaDTO.getId()));

        Medico medico = medicoRepository.findById(consultaDTO.getMedicoId())
            .orElseThrow(() -> new MedicoNaoEncontradoException("Médico não encontrado para o ID: " + consultaDTO.getMedicoId()));

        consulta.setNomeCliente(consultaDTO.getNomeCliente());
        consulta.setCpfCliente(consultaDTO.getCpfCliente());
        consulta.setValor(consultaDTO.getValor());
        consulta.setMedico(medico);

        var dto = consultaMapper.ConsultaToConsultaDTO(consultaRepository.save(consulta));
        dto.setMedicoId(medico.getId());
        return dto;
    }

    public void delete(Long id) {
        var entity = consultaRepository.findById(id)
            .orElseThrow(() -> new ConsultaNaoEncontradaException("Consulta não encontrada para o ID: " + id));

        consultaRepository.delete(entity);
    }
}