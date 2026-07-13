package com.liviahenrique.chamadosApi.dto;

import com.liviahenrique.chamadosApi.enums.Prioridade;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CriarChamadoRequest(
    @NotBlank(message = "O título é obrigatório")
    @Size(max = 150, message = "O título deve ter no máximo 150 caracteres")
    String titulo,

    @NotBlank(message = "A descrição é obrigatória")
    @Size(max = 1000, message = "A descrição deve ter no máximo 1000 caracteres")
    String descricao,

    @NotNull(message = "A prioridade é obrigatória")
    Prioridade prioridade
) {
}
