package com.sistema_medico.dtos;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class MedicoDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;
    private String cpf;
    private String especializacao;

    public MedicoDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEspecializacao() {
        return especializacao;
    }

    public void setEspecializacao(String especializacao) {
        this.especializacao = especializacao;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MedicoDTO medicoDTO = (MedicoDTO) o;
        return Objects.equals(getId(), medicoDTO.getId()) && Objects.equals(getNome(), medicoDTO.getNome()) && Objects.equals(getCpf(), medicoDTO.getCpf()) && Objects.equals(getEspecializacao(), medicoDTO.getEspecializacao());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome(), getCpf(), getEspecializacao());
    }
}