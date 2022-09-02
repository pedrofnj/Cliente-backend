package io.github.pedrofnj.clientes.model.repository;

import io.github.pedrofnj.clientes.model.entity.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository<Servico, Integer> {
}
