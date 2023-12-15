package com.example.Teste.domain.vendas;

import com.example.Teste.domain.estoque.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RepositoryVendas extends JpaRepository<Vendas, String> {
    List<Vendas>findAllByActiveTrue();

    @Query("SELECT v FROM Vendas v ORDER BY v.quantidadePedido DESC")
    public default Vendas findProdutoComMaiorQuantidadePedido() {
        List<Vendas> vendas = findAll();

        if (vendas == null || vendas.isEmpty()) {
            return null;
        }

        Vendas produtoComMaiorQuantidade = vendas.get(0);

        for (Vendas venda : vendas) {
            if (venda.getQuantidade_pedido() > produtoComMaiorQuantidade.getQuantidade_pedido()) {
                produtoComMaiorQuantidade = venda;
            }
        }

        return produtoComMaiorQuantidade;
    }

    List<Vendas> findByClienteId(String id_cliente);

}

