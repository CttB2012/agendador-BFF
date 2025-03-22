package com.projeto.bff_agendador.business.dto.in;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TelefoneDTORequest {

    private String numero;
    private String ddd;
}
