package com.projeto.bff_agendador.business.service;


import com.projeto.bff_agendador.business.dto.in.TarefasDTORequest;
import com.projeto.bff_agendador.business.dto.out.TarefasDTOResponse;
import com.projeto.bff_agendador.infrastructure.client.EmailClient;
import com.projeto.bff_agendador.infrastructure.client.TarefasClient;
import com.projeto.bff_agendador.infrastructure.enums.StatusNotificacaoEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final EmailClient _emailClient;

    public void enviarEmail(TarefasDTOResponse tarefasDTOResponse){
        _emailClient.enviarEmail(tarefasDTOResponse);

    }

}
