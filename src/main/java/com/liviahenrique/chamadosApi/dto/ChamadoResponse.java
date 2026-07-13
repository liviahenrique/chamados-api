package com.liviahenrique.chamadosApi.dto;

import com.liviahenrique.chamadosApi.enums.Prioridade;
import com.liviahenrique.chamadosApi.enums.StatusChamados;

import java.time.LocalDateTime;

public record ChamadoResponse(
        Long id,
        String protocolo,
        String titulo,
        String descricao,
        Prioridade prioridade,
        StatusChamados status,
        LocalDateTime criadoEm,
        LocalDateTime atualizadoEm
) {
}
