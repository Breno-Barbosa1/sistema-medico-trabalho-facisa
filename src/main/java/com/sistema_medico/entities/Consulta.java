package com.sistema_medico.entities;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "consultas")
public class Consulta implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "consulta_id")
    private Long id;

    @Column(name = "nome_cliente", length = 255, nullable = false)
    private String nomeCliente;

    @Column(name = "cpf_cliente", length = 255, nullable = false)
    private String cpfCliente;

    @Column(name = "valor", nullable = false)
    private Double valor;

    @ManyToOne
    @JoinColumn(name = "medico_id")
    private Medico medico;

    public Consulta() {
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

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Consulta consulta = (Consulta) o;
        return Objects.equals(getId(), consulta.getId()) && Objects.equals(getNomeCliente(), consulta.getNomeCliente()) && Objects.equals(getCpfCliente(), consulta.getCpfCliente()) && Objects.equals(getValor(), consulta.getValor()) && Objects.equals(getMedico(), consulta.getMedico());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNomeCliente(), getCpfCliente(), getValor(), getMedico());
    }
}