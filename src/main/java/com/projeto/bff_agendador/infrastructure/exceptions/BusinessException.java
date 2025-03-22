package com.projeto.bff_agendador.infrastructure.exceptions;



public class BusinessException extends RuntimeException {

    public BusinessException(String messagem){
        super(messagem);
    }

    public BusinessException(String messagem, Throwable throwable){
        super(messagem, throwable);
    }
}
