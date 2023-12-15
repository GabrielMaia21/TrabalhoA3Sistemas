package com.example.Teste.domain.estoque;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RepositoryEstoque extends JpaRepository<Estoque,String> {
    List<Estoque>findAllByActiveTrue();



    @Query("SELECT e FROM estoque e ORDER BY e.quantidade ASC")
    Optional<Estoque> findEstoqueComMenorQuantidade();
}
