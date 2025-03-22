package com.projeto.bff_agendador.business.dto.out;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TelefoneDTOResponse {

    private Long id;
    private String numero;
    private String ddd;
}
