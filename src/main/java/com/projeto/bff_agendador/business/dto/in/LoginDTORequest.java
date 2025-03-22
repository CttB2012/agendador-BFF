package com.projeto.bff_agendador.business.dto.in;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class LoginDTORequest {

    private String email;
    private String senha;

}
