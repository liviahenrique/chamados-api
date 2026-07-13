package com.liviahenrique.chamadosApi.service;

import com.liviahenrique.chamadosApi.dto.ChamadoResponse;
import com.liviahenrique.chamadosApi.dto.CriarChamadoRequest;
import com.liviahenrique.chamadosApi.entity.Chamado;
import com.liviahenrique.chamadosApi.enums.StatusChamados;
import com.liviahenrique.chamadosApi.repository.ChamadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ChamadoService {

    private final ChamadoRepository chamadoRepository;

    public ChamadoResponse criar(CriarChamadoRequest request) {
        Chamado chamado = Chamado.builder()
                .protocolo(gerarProtocolo())
                .titulo(request.titulo())
                .descricao(request.descricao())
                .prioridade(request.prioridade())
                .status(StatusChamados.ABERTO)
                .criadoEm(LocalDateTime.now())
                .build();

        Chamado salvo = chamadoRepository.save(chamado);

        return converterParaResponse(salvo);
    }

    public List<ChamadoResponse> listarTodos() {
        return chamadoRepository.findAll()
                .stream()
                .map(this::converterParaResponse)
                .toList();
    }

    public ChamadoResponse buscarPorProtocolo(String protocolo) {
        Chamado chamado = chamadoRepository.findByProtocolo(protocolo)
                .orElseThrow(() -> new RuntimeException("Chamado não encontrado"));

        return converterParaResponse(chamado);
    }

    private String gerarProtocolo() {
        return "CH-" + UUID.randomUUID()
                .toString()
                .substring(0, 8)
                .toUpperCase();
    }

    private ChamadoResponse converterParaResponse(Chamado chamado) {
        return new ChamadoResponse(
                chamado.getId(),
                chamado.getProtocolo(),
                chamado.getTitulo(),
                chamado.getDescricao(),
                chamado.getPrioridade(),
                chamado.getStatus(),
                chamado.getCriadoEm(),
                chamado.getAtualizadoEm()
        );
    }
}
