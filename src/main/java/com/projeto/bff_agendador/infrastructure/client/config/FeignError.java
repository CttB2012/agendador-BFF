package com.projeto.bff_agendador.infrastructure.client.config;

import com.projeto.bff_agendador.infrastructure.exceptions.BusinessException;
import com.projeto.bff_agendador.infrastructure.exceptions.ConflictException;
import com.projeto.bff_agendador.infrastructure.exceptions.ResourceNotFoundException;
import com.projeto.bff_agendador.infrastructure.exceptions.UnauthorizedException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class FeignError implements ErrorDecoder {

    @Override
    public Exception decode(String s, Response response) {
        switch (response.status()){
            case 409:
                return new ConflictException("Erro: Atributo já cadastrado.");
            case 403:
                return new ResourceNotFoundException("Erro: Atributo não encontrado.");
            case 401:
                return new UnauthorizedException("Erro: usuário não autorizado.");

            default:
                return new BusinessException("Erro: falha no servidor. ");
        }
    }
}
