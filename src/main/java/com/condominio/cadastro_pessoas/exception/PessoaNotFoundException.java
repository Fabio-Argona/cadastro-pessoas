package com.condominio.cadastro_pessoas.exception;

public class PessoaNotFoundException extends RuntimeException {

    public PessoaNotFoundException() {
        super();
    }

    public PessoaNotFoundException(String message) {
        super(message);
    }

    public PessoaNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public PessoaNotFoundException(Throwable cause) {
        super(cause);
    }
}
