package com.projeto.bff_agendador.controller;


import com.projeto.bff_agendador.business.dto.out.TarefasDTOResponse;
import com.projeto.bff_agendador.business.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//@RequiredArgsConstructor
//public class NotificacaoController {
//
//    private final EmailService _emailService;
//
//    @PostMapping("/email")
//    public ResponseEntity<Void> enviarEmail(@RequestBody TarefasDTOResponse tarefasDTO){
//
//        _emailService.enviarEmail(tarefasDTO);
//        return ResponseEntity.ok().build();
//    }
//
//
//}
