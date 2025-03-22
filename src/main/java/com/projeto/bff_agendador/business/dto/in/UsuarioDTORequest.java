package com.projeto.bff_agendador.business.dto.in;


import lombok.*;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UsuarioDTORequest {

    private String nome;
    private String email;
    private String senha;

    private List<EnderecoDTORequest> enderecosDTO;
    private List<TelefoneDTORequest> telefonesDTO;


}
