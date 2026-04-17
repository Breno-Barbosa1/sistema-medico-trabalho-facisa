package com.sistema_medico.dtos;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class ConsultaDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String nomeCliente;
    private String cpfCliente;
    private Double valor;
    private Long medicoId;

    public ConsultaDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Long getMedicoId() {
        return medicoId;
    }

    public void setMedicoId(Long medicoId) {
        this.medicoId = medicoId;
    }

    @Override
    public boolean equals(Object o) {

        if (o == null || getClass() != o.getClass()) return false;
        ConsultaDTO that = (ConsultaDTO) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getNomeCliente(), that.getNomeCliente()) && Objects.equals(getCpfCliente(), that.getCpfCliente()) && Objects.equals(getValor(), that.getValor()) && Objects.equals(getMedicoId(), that.getMedicoId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNomeCliente(), getCpfCliente(), getValor(), getMedicoId());
    }
}