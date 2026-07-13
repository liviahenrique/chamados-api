package com.liviahenrique.chamadosApi.controller;

import com.liviahenrique.chamadosApi.dto.ChamadoResponse;
import com.liviahenrique.chamadosApi.dto.CriarChamadoRequest;
import com.liviahenrique.chamadosApi.service.ChamadoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/chamados")
@RequiredArgsConstructor
public class ChamadoController {

    private final ChamadoService chamadoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ChamadoResponse criar(
            @Valid @RequestBody CriarChamadoRequest request
    ) {
        return chamadoService.criar(request);
    }

    @GetMapping
    public List<ChamadoResponse> listarTodos() {
        return chamadoService.listarTodos();
    }

    @GetMapping("/protocolo/{protocolo}")
    public ChamadoResponse buscarPorProtocolo(
            @PathVariable String protocolo
    ) {
        return chamadoService.buscarPorProtocolo(protocolo);
    }
}