package com.projeto.bff_agendador.business.service;


import com.projeto.bff_agendador.business.dto.in.LoginDTORequest;
import com.projeto.bff_agendador.business.dto.out.TarefasDTOResponse;
import com.projeto.bff_agendador.infrastructure.enums.StatusNotificacaoEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CronService {

    private final TarefasService _tarefasService;
    private final EmailService _emailService;
    private final UsuarioService _usuarioService;

    @Value("${usuario.email}")
    private String email;
    @Value("${usuario.senha}")
    private String senha;

    @Scheduled(cron = "${cron.horario}")
    public void buscaTarefaPorHora(){

        String token = login(converterParaRequestDTO());
        LocalDateTime proximaHora = LocalDateTime.now().plusHours(1);
        LocalDateTime proximaHoraMaisCincoMin = LocalDateTime.now().plusMinutes(5);

        List<TarefasDTOResponse> listaTarefas = _tarefasService.buscarTarefasPorPeriodo(proximaHora,
                                                                                        proximaHoraMaisCincoMin,
                                                                                        token);

        listaTarefas.forEach(tarefa -> {_emailService.enviarEmail(tarefa);
                                        _tarefasService.alterarStatusTarefa
                                                (StatusNotificacaoEnum.NOTIFICADO, tarefa.getId(), token);
        });
    }

    public String login(LoginDTORequest loginDTORequest){
        return  _usuarioService.loginUsuario(loginDTORequest);
    }

    public LoginDTORequest converterParaRequestDTO(){
        return LoginDTORequest.builder()
                .email(email)
                .senha(senha)
                .build();
    }
}
