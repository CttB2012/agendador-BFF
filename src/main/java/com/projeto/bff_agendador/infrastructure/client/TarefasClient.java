package com.projeto.bff_agendador.infrastructure.client;

import com.projeto.bff_agendador.business.dto.in.TarefasDTORequest;
import com.projeto.bff_agendador.business.dto.out.TarefasDTOResponse;
import com.projeto.bff_agendador.infrastructure.enums.StatusNotificacaoEnum;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@FeignClient(name = "agendador-tarefas", url = "${agendador-tarefas.url}")
public interface TarefasClient {

    @PostMapping
    TarefasDTOResponse salvarNovaTarefa(@RequestBody TarefasDTORequest tarefasDTORequest,
                                       @RequestHeader(name = "Authorization") String token);

    @GetMapping("/eventos")
    List<TarefasDTOResponse> buscarTarefasPorPeriodo(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicial,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFinal,
            @RequestHeader(name = "Authorization") String token);


    @GetMapping
    List<TarefasDTOResponse> buscarTarefasPorEmail(@RequestHeader(name = "Authorization") String token);

    @DeleteMapping
    void excluirPorId(@RequestParam("id") String id, @RequestHeader(name = "Authorization") String token);

    @PatchMapping
    TarefasDTOResponse alterarStatusTarefa(@RequestParam("status") StatusNotificacaoEnum status,
                                           @RequestParam("id") String id,
                                           @RequestHeader(name = "Authorization") String token);

    @PutMapping
    TarefasDTOResponse atualizarTarefa(@RequestBody TarefasDTORequest tarefasDTORequest,
                                      @RequestParam("id") String id,
                                      @RequestHeader(name = "Authorization") String token);

}