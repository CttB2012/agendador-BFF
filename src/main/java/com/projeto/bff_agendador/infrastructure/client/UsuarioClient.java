package com.projeto.bff_agendador.infrastructure.client;

import com.projeto.bff_agendador.business.dto.in.EnderecoDTORequest;
import com.projeto.bff_agendador.business.dto.in.LoginDTORequest;
import com.projeto.bff_agendador.business.dto.in.TelefoneDTORequest;
import com.projeto.bff_agendador.business.dto.in.UsuarioDTORequest;
import com.projeto.bff_agendador.business.dto.out.EnderecoDTOResponse;
import com.projeto.bff_agendador.business.dto.out.TelefoneDTOResponse;
import com.projeto.bff_agendador.business.dto.out.UsuarioDTOResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "usuario", url = "${usuario.url}")
public interface UsuarioClient {

    @PostMapping
    UsuarioDTOResponse salvarUsuario(@RequestBody UsuarioDTORequest usuarioDTO);

    @PostMapping("/login")
    String login(@RequestBody LoginDTORequest loginDTORequest);


    @GetMapping
    UsuarioDTOResponse buscarUsuarioByEmail(@RequestParam("email") String email,
                                            @RequestHeader(name = "Authorization") String token);

    @DeleteMapping("/{email}")
    Void deletarUsuarioByEmail(@PathVariable String email,
                               @RequestHeader(name = "Authorization") String token);

    @PutMapping
    UsuarioDTOResponse atualizarDadosUsuario(@RequestBody UsuarioDTORequest usuarioDTO,
                                             @RequestHeader(name = "Authorization") String token);

    @PutMapping("/endereco")
    EnderecoDTOResponse atualizarEndereco(@RequestBody EnderecoDTORequest enderecoDTO,
                                          @RequestParam("id") Long id,
                                          @RequestHeader(name = "Authorization") String token);

    @PutMapping("/telefone")
    TelefoneDTOResponse atualizarTelefone(@RequestBody TelefoneDTORequest telefoneDTO,
                                          @RequestParam("id") Long id,
                                          @RequestHeader(name = "Authorization") String token);

    @PostMapping("/enderecoCadastro")
    EnderecoDTOResponse cadastrarEndereco(@RequestBody EnderecoDTORequest enderecoDTO,
                                          @RequestHeader(name = "Authorization") String token);

    @PostMapping("/telefoneCadastro")
    TelefoneDTOResponse cadastrarTelefone(@RequestBody TelefoneDTORequest telefoneDTO,
                                          @RequestHeader(name = "Authorization") String token);
}
