package com.back.StartTech.repository;

import com.back.StartTech.entity.Carrinho;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarrinhoRepository extends JpaRepository<Carrinho, Long> {
    Optional<Carrinho> findByCliente_Id(long idCliente);
}
