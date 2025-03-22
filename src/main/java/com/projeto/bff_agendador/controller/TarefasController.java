package com.projeto.bff_agendador.controller;



import com.projeto.bff_agendador.business.dto.in.TarefasDTORequest;
import com.projeto.bff_agendador.business.dto.out.TarefasDTOResponse;
import com.projeto.bff_agendador.business.service.TarefasService;
import com.projeto.bff_agendador.infrastructure.enums.StatusNotificacaoEnum;
import com.projeto.bff_agendador.infrastructure.security.SecurityConfig;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/tarefas")
@RequiredArgsConstructor
@Tag(name = "Tarefas", description = "Cadastra tarefas de usuarios")
@SecurityRequirement(name = SecurityConfig.SECURITY_SCHEME)
public class TarefasController {

    private final TarefasService _tarefasService;

    @PostMapping
    @Operation(summary = "Salvar tarefas", description = "Cria uma nova tarefa")
    @ApiResponse(responseCode = "200", description = "Tarefa salva com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro no servidor")
    @ApiResponse(responseCode = "401", description = "Usuário não autorizado.")
    public ResponseEntity<TarefasDTOResponse> salvarNovaTarefa(@RequestBody TarefasDTORequest tarefasDTORequest,
                                                              @RequestHeader(name = "Authorization", required = false) String token){
        return ResponseEntity.ok(_tarefasService.salvarNovaTarefa(token, tarefasDTORequest));
    }

    @GetMapping("/eventos")
    @Operation(summary = "Busca tarefas por periodo", description = "Busca tarefas por periodo")
    @ApiResponse(responseCode = "200", description = "Tarefas  encontradas com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro no servidor")
    @ApiResponse(responseCode = "401", description = "Usuário não autorizado.")
    public ResponseEntity<List<TarefasDTOResponse>> buscarTarefasPorPeriodo(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicial,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFinal,
            @RequestHeader(name = "Authorization", required = false) String token){

        return ResponseEntity.ok(_tarefasService.buscarTarefasPorPeriodo(dataInicial, dataFinal, token));
    }

    @GetMapping
    @Operation(summary = "Busca tarefas por email de usuario", description = "Busca tarefas por email de usuario")
    @ApiResponse(responseCode = "200", description = "Tarefas  encontradas com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro no servidor")
    @ApiResponse(responseCode = "403", description = "Email não encontrada.")
    @ApiResponse(responseCode = "401", description = "Usuário não autorizado.")
    public ResponseEntity<List<TarefasDTOResponse>> buscarTarefasPorEmail(@RequestHeader(name = "Authorization", required = false) String token) {

        List<TarefasDTOResponse> tarefas = _tarefasService.buscarTarefasPorEmail(token);
        return ResponseEntity.ok(tarefas);
    }

    @DeleteMapping
    @Operation(summary = "Exclui tarefas por ID", description = "Exclui tarefas por ID")
    @ApiResponse(responseCode = "200", description = "Tarefas  excluidas com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro no servidor")
    @ApiResponse(responseCode = "403", description = "Tarefa Id não encontrada.")
    @ApiResponse(responseCode = "401", description = "Usuário não autorizado.")
    public ResponseEntity<Void> excluirPorId(@RequestParam("id") String id, @RequestHeader(name = "Authorization", required = false) String token) {
        _tarefasService.excluirPelaId(id, token);

        return ResponseEntity.ok().build();
    }

    @PatchMapping
    @Operation(summary = "Altera status de tarefas", description = "Altera status de tarefas cadastradas")
    @ApiResponse(responseCode = "200", description = "Status de tarefas  alterados com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro no servidor")
    @ApiResponse(responseCode = "403", description = "Tarefa Id não encontrada.")
    @ApiResponse(responseCode = "401", description = "Usuário não autorizado.")
    public ResponseEntity<TarefasDTOResponse> alterarStatusTarefa(@RequestParam("status") StatusNotificacaoEnum status,
                                                                  @RequestParam("id") String id,
                                                                  @RequestHeader(name = "Authorization", required = false) String token){
        return ResponseEntity.ok(_tarefasService.alterarStatusTarefa(status, id, token));
    }

    @PutMapping
    @Operation(summary = "Altera dados de tarefas", description = "Altera dados de tarefas cadastradas")
    @ApiResponse(responseCode = "200", description = "Dados de tarefas  alterados com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro no servidor")
    @ApiResponse(responseCode = "403", description = "Tarefa Id não encontrada.")
    @ApiResponse(responseCode = "401", description = "Usuário não autorizado.")
    public ResponseEntity<TarefasDTOResponse> atualizarTarefa(@RequestBody TarefasDTORequest tarefasDTORequest,
                                                             @RequestParam("id") String id, @RequestHeader(name = "Authorization", required = false) String token){

        return ResponseEntity.ok(_tarefasService.atualizarTarefa(tarefasDTORequest, id, token));
    }
}
