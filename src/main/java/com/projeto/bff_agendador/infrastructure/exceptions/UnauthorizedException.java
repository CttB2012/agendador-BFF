package com.projeto.bff_agendador.infrastructure.exceptions;



public class UnauthorizedException extends RuntimeException {

    public UnauthorizedException(String messagem){
        super(messagem);
    }

    public UnauthorizedException(String messagem, Throwable throwable){
        super(messagem, throwable);
    }
}
