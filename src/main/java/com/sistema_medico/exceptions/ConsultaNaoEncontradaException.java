package com.sistema_medico.exceptions;

public class ConsultaNaoEncontradaException extends RuntimeException {
    public ConsultaNaoEncontradaException(String message) {
        super(message);
    }

    public ConsultaNaoEncontradaException() {
        super("Consulta não encontrada!");
    }
}