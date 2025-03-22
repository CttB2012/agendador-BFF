package com.projeto.bff_agendador.business.service;


import com.projeto.bff_agendador.business.dto.in.TarefasDTORequest;
import com.projeto.bff_agendador.business.dto.out.TarefasDTOResponse;
import com.projeto.bff_agendador.infrastructure.client.TarefasClient;
import com.projeto.bff_agendador.infrastructure.enums.StatusNotificacaoEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TarefasService {

    private final TarefasClient tarefasClient;


    public TarefasDTOResponse salvarNovaTarefa(String token, TarefasDTORequest tarefasDTORequest){
        return tarefasClient.salvarNovaTarefa(tarefasDTORequest, token);
    }

    public List<TarefasDTOResponse> buscarTarefasPorPeriodo(LocalDateTime dataInicial, LocalDateTime dataFinal, String token){
        return tarefasClient.buscarTarefasPorPeriodo(dataInicial, dataFinal, token);
    }

    public List<TarefasDTOResponse> buscarTarefasPorEmail(String token){
        return tarefasClient.buscarTarefasPorEmail(token);
    }

    public void excluirPelaId(String id, String token){
        tarefasClient.excluirPorId(id, token);
    }

    public TarefasDTOResponse alterarStatusTarefa(StatusNotificacaoEnum status, String id, String token){
        return tarefasClient.alterarStatusTarefa(status, id, token);
    }

    public TarefasDTOResponse atualizarTarefa(TarefasDTORequest tarefasDTORequest, String id, String token){
        return tarefasClient.atualizarTarefa(tarefasDTORequest, id, token);
    }
}
