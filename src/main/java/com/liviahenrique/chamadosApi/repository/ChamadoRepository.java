package com.liviahenrique.chamadosApi.repository;

import com.liviahenrique.chamadosApi.entity.Chamado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChamadoRepository extends JpaRepository<Chamado, Long> {

    Optional<Chamado> findByProtocolo(String protocolo);
}
