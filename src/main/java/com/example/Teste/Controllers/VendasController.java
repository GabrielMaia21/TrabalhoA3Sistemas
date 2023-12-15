package com.example.Teste.Controllers;

import com.example.Teste.domain.estoque.Estoque;
import com.example.Teste.domain.estoque.RepositoryEstoque;
import com.example.Teste.domain.vendas.RepositoryVendas;
import com.example.Teste.domain.vendas.RequestVendas;
import com.example.Teste.domain.vendas.Vendas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

@RestController

@RequestMapping("/vendas")
public class VendasController {
    @Autowired
    private RepositoryEstoque repositoryEstoque;
    @Autowired
    private EstoqueController estoqueController;
    @Autowired
    private RepositoryVendas repository;

    @GetMapping
    public ResponseEntity getAllVendas() {
        var AllVendas = repository.findAllByActiveTrue();
        return ResponseEntity.ok(AllVendas);
    }

    @PostMapping
    public ResponseEntity<String> realizarVenda(@RequestBody @Valid RequestVendas data) {
        try {
            Estoque estoque = repositoryEstoque.findById(data.id_produto()).orElse(null);
            if (estoque != null && estoque.getQuantidade() >= data.quantidade_pedido()) {
                Vendas vendas = new Vendas(data);
                estoque.setQuantidade(estoque.getQuantidade() - data.quantidade_pedido());
                repositoryEstoque.save(estoque);
                vendas.setActive(true);
                repository.save(vendas);
                return new ResponseEntity<>("Venda realizada com sucesso.", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Quantidade em estoque insuficiente para concluir a venda", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao processar a venda: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    private final RepositoryVendas repositoryVendas;

    public VendasController(RepositoryVendas repositoryVendas) {
        this.repositoryVendas = repositoryVendas;
    }

    @GetMapping("/produto-mais-vendido")
    public ResponseEntity<Vendas> getProdutoMaisVendido() {
        Vendas produtoComMaiorQuantidade = repositoryVendas.findProdutoComMaiorQuantidadePedido();

        if (produtoComMaiorQuantidade != null) {
            return ResponseEntity.ok(produtoComMaiorQuantidade);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}


