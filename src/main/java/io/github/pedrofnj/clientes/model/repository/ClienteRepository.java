package io.github.pedrofnj.clientes.model.repository;

import io.github.pedrofnj.clientes.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
