package com.sistema_medico.mapper;

import com.sistema_medico.dtos.ConsultaDTO;
import com.sistema_medico.entities.Consulta;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ConsultaMapper {

    ConsultaDTO ConsultaToConsultaDTO(Consulta consulta);
    Consulta ConsultaDTOToConsulta(ConsultaDTO consultaDTO);
}
