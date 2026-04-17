package com.sistema_medico.mapper;

import com.sistema_medico.dtos.MedicoDTO;
import com.sistema_medico.entities.Medico;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MedicoMapper {

    MedicoDTO MedicoToMedicoDTO(Medico medico);
    Medico MedicoDTOToMedico(MedicoDTO medicoDTO);
}