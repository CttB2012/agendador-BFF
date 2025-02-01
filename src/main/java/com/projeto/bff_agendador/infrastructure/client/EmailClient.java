package com.projeto.bff_agendador.infrastructure.client;

import com.projeto.bff_agendador.business.dto.out.TarefasDTOResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "notificacao", url = "${notificacao.url}")
public interface EmailClient {

  @PostMapping
  Void enviarEmail(@RequestBody TarefasDTOResponse tarefasDTO);
}
