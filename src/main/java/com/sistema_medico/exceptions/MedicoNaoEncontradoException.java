package com.sistema_medico.exceptions;

public class MedicoNaoEncontradoException extends RuntimeException {
    public MedicoNaoEncontradoException(String message) {
        super(message);
    }

    public MedicoNaoEncontradoException() {
        super("Médico não encontrado!");
    }
}