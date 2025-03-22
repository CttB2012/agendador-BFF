package com.projeto.bff_agendador.controller;


import com.projeto.bff_agendador.business.dto.in.EnderecoDTORequest;
import com.projeto.bff_agendador.business.dto.in.LoginDTORequest;
import com.projeto.bff_agendador.business.dto.in.TelefoneDTORequest;
import com.projeto.bff_agendador.business.dto.in.UsuarioDTORequest;
import com.projeto.bff_agendador.business.dto.out.EnderecoDTOResponse;
import com.projeto.bff_agendador.business.dto.out.TelefoneDTOResponse;
import com.projeto.bff_agendador.business.dto.out.UsuarioDTOResponse;
import com.projeto.bff_agendador.business.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
@Tag(name = "Usuario", description = "Cadastro e login de usuario")
public class UsuarioController {

    private final UsuarioService _usuarioService;


    @PostMapping
    @Operation(summary = "Salvar usuarios", description = "Cria um novo usuario")
    @ApiResponse(responseCode = "200", description = "Usuario salvo com sucesso")
    @ApiResponse(responseCode = "409", description = "Usuario ja cadastrado")
    @ApiResponse(responseCode = "500", description = "Erro no servidor")
    public ResponseEntity<UsuarioDTOResponse> salvarUsuario(@RequestBody UsuarioDTORequest usuarioDTO){
        return ResponseEntity.ok(_usuarioService.salvarUsuario(usuarioDTO));
    }

    @PostMapping("/login")
    @Operation(summary = "Login de usuarios", description = "Login do usuario")
    @ApiResponse(responseCode = "200", description = "Usuario logado com sucesso")
    @ApiResponse(responseCode = "401", description = "Credenciais invalidas")
    @ApiResponse(responseCode = "500", description = "Erro no servidor")
    public String login(@RequestBody LoginDTORequest loginDTO){
        return _usuarioService.loginUsuario(loginDTO);
    }

    @GetMapping
    @Operation(summary = "Buscar dados de usuarios pelo email", description = "Busca usuarios pelo email")
    @ApiResponse(responseCode = "200", description = "Usuario Encontrado ")
    @ApiResponse(responseCode = "403", description = "Usuario nao encontrado")
    @ApiResponse(responseCode = "500", description = "Erro no servidor")
    @ApiResponse(responseCode = "401", description = "Credenciais invalidas")
    private ResponseEntity<UsuarioDTOResponse> buscarUsuarioByEmail(@RequestParam("email") String email,
                                                                    @RequestHeader(name = "Authorization", required = false) String token ){
        return ResponseEntity.ok(_usuarioService.buscarUsuarioByEmail(email, token));
    }

    @DeleteMapping("/{email}")
    @Operation(summary = "Exclui usuarios pelo email", description = "Exclui usuarios")
    @ApiResponse(responseCode = "200", description = "Usuario excluido com sucesso")
    @ApiResponse(responseCode = "403", description = "Usuario nao encontrado")
    @ApiResponse(responseCode = "500", description = "Erro no servidor")
    @ApiResponse(responseCode = "401", description = "Credenciais invalidas")
    public ResponseEntity<Void> deletarUsuarioByEmail(@PathVariable String email,
                                                      @RequestHeader(name = "Authorization", required = false) String token){
        _usuarioService.DeletarUsuarioByEmail(email, token);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @Operation(summary = "Atualizar dados do usuario", description = "Atualizar dados do usuario")
    @ApiResponse(responseCode = "200", description = "Dados de Usuario atualizados com sucesso")
    @ApiResponse(responseCode = "403", description = "Usuario nao encontrado")
    @ApiResponse(responseCode = "500", description = "Erro no servidor")
    @ApiResponse(responseCode = "401", description = "Credenciais invalidas")
    public ResponseEntity<UsuarioDTOResponse> atualizarDadosUsuario(@RequestBody UsuarioDTORequest usuarioDTO,
                                                                    @RequestHeader(name = "Authorization", required = false) String token){
        return ResponseEntity.ok(_usuarioService.atualizarDadosUsuario(usuarioDTO, token));
    }

    @PutMapping("/endereco")
    @Operation(summary = "Atualizar endereço do usuario", description = "Atualizar endereço do usuario")
    @ApiResponse(responseCode = "200", description = "Endereço atualizado com sucesso")
    @ApiResponse(responseCode = "403", description = "Usuario nao encontrado")
    @ApiResponse(responseCode = "500", description = "Erro no servidor")
    @ApiResponse(responseCode = "401", description = "Credenciais invalidas")
    public ResponseEntity<EnderecoDTOResponse> atualizarEndereco(@RequestBody EnderecoDTORequest enderecoDTO,
                                                                 @RequestParam("id") Long id,
                                                                 @RequestHeader(name = "Authorization", required = false) String token){
        return ResponseEntity.ok(_usuarioService.atualizarEndereco(enderecoDTO, id, token));
    }

    @PutMapping("/telefone")
    @Operation(summary = "Atualizar telefone do usuario", description = "Atualizar telefone do usuario")
    @ApiResponse(responseCode = "200", description = "Telefone atualizado com sucesso")
    @ApiResponse(responseCode = "403", description = "Usuario nao encontrado")
    @ApiResponse(responseCode = "500", description = "Erro no servidor")
    @ApiResponse(responseCode = "401", description = "Credenciais invalidas")
    public ResponseEntity<TelefoneDTOResponse> atualizarTelefone(@RequestBody TelefoneDTORequest telefoneDTO,
                                                                 @RequestParam("id") Long id,
                                                                 @RequestHeader(name = "Authorization", required = false) String token){
        return ResponseEntity.ok(_usuarioService.atualizarTelefone(telefoneDTO, id, token));
    }

    @PostMapping("/enderecoCadastro")
    @Operation(summary = "Salvar novo endereço", description = "Salvar novo endereço")
    @ApiResponse(responseCode = "200", description = "Endereço salvo com sucesso")
    @ApiResponse(responseCode = "403", description = "Usuario nao encontrado")
    @ApiResponse(responseCode = "500", description = "Erro no servidor")
    @ApiResponse(responseCode = "401", description = "Credenciais invalidas")
    public ResponseEntity<EnderecoDTOResponse> cadastrarEndereco(@RequestBody EnderecoDTORequest enderecoDTO,
                                                                 @RequestHeader(name = "Authorization", required = false) String token){
        return ResponseEntity.ok(_usuarioService.cadastrarEndereco(token, enderecoDTO));
    }

    @PostMapping("/telefoneCadastro")
    @Operation(summary = "Salvar novo telefone", description = "Salvar novo telefone")
    @ApiResponse(responseCode = "200", description = "Telefone salvo com sucesso")
    @ApiResponse(responseCode = "403", description = "Usuario nao encontrado")
    @ApiResponse(responseCode = "500", description = "Erro no servidor")
    @ApiResponse(responseCode = "401", description = "Credenciais invalidas")
    public ResponseEntity<TelefoneDTOResponse> cadastrarTelefone(@RequestBody TelefoneDTORequest telefoneDTO,
                                                                 @RequestHeader(name = "Authorization", required = false) String token){
        return ResponseEntity.ok(_usuarioService.cadastrarTelefone(telefoneDTO, token));
    }
}
