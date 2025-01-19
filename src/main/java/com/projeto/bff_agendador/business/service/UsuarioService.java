package com.projeto.bff_agendador.business.service;


import com.projeto.bff_agendador.business.dto.in.EnderecoDTORequest;
import com.projeto.bff_agendador.business.dto.in.LoginDTORequest;
import com.projeto.bff_agendador.business.dto.in.TelefoneDTORequest;
import com.projeto.bff_agendador.business.dto.in.UsuarioDTORequest;
import com.projeto.bff_agendador.business.dto.out.EnderecoDTOResponse;
import com.projeto.bff_agendador.business.dto.out.TelefoneDTOResponse;
import com.projeto.bff_agendador.business.dto.out.UsuarioDTOResponse;
import com.projeto.bff_agendador.infrastructure.client.UsuarioClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioClient _usuarioClient;

    public UsuarioDTOResponse salvarUsuario(UsuarioDTORequest usuarioDTO) {
        return _usuarioClient.salvarUsuario(usuarioDTO);
    }


    public String loginUsuario(LoginDTORequest loginDTORequest){
        return  _usuarioClient.login(loginDTORequest);
    }

    public UsuarioDTOResponse buscarUsuarioByEmail(String email, String token ) {
            return _usuarioClient.buscarUsuarioByEmail(email, token);
    }



    public void DeletarUsuarioByEmail(String email, String token) {
        _usuarioClient.deletarUsuarioByEmail(email, token);
    }

    public UsuarioDTOResponse atualizarDadosUsuario(UsuarioDTORequest usuarioDTO, String token) {
        return _usuarioClient.atualizarDadosUsuario(usuarioDTO, token);
    }

    public EnderecoDTOResponse atualizarEndereco(EnderecoDTORequest enderecoDTO, Long idEndereco, String token) {
        return _usuarioClient.atualizarEndereco(enderecoDTO, idEndereco, token);
    }

    public TelefoneDTOResponse atualizarTelefone(TelefoneDTORequest telefoneDTO, Long idTelefone, String token) {
        return _usuarioClient.atualizarTelefone(telefoneDTO, idTelefone, token);

    }

    public EnderecoDTOResponse cadastrarEndereco(String token, EnderecoDTORequest enderecoDTO){
        return _usuarioClient.cadastrarEndereco(enderecoDTO, token);
    }

    public TelefoneDTOResponse cadastrarTelefone(TelefoneDTORequest telefoneDTO, String token){
        return _usuarioClient.cadastrarTelefone(telefoneDTO, token);
    }
}
