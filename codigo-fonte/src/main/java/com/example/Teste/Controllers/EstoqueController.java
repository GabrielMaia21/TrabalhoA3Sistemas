package com.example.Teste.Controllers;

import com.example.Teste.domain.estoque.Estoque;
import com.example.Teste.domain.estoque.RepositoryEstoque;
import com.example.Teste.domain.estoque.RequestEstoque;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController

@RequestMapping("/estoque")
public class EstoqueController {

    @Autowired
    private RepositoryEstoque repository;

    @GetMapping
    public ResponseEntity getAllProdutos(){
        var Allprodutos = repository.findAllByActiveTrue();
        return ResponseEntity.ok(Allprodutos);
    }

    @PostMapping
    public ResponseEntity registerProduto(@RequestBody @Valid RequestEstoque data){
        Estoque newProduto = new Estoque(data);
        repository.save(newProduto);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateProduto(@RequestBody @Valid RequestEstoque data){
        Optional<Estoque> optionalProduto = repository.findById(data.id());
        if(optionalProduto.isPresent()){
            Estoque produto = optionalProduto.get();
            produto.setName(data.name());
            produto.setPrince_in_cents(data.prince_in_cents());
            return ResponseEntity.ok(produto);
        } else {
            throw new EntityNotFoundException();
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteProduto(@PathVariable String id){
        Optional<Estoque> optionalProduto = repository.findById(id);
        if(optionalProduto.isPresent()){
            Estoque produto = optionalProduto.get();
            produto.setActive(false);
            return ResponseEntity.noContent().build();
        } else {
            throw new EntityNotFoundException();
        }

    }

    @GetMapping("/produto-menor-quantidade")
    public Optional<Estoque> getEstoqueComMenorQuantidade() {
        Optional<Estoque> estoque = repository.findEstoqueComMenorQuantidade();

        return repository.findEstoqueComMenorQuantidade();
    }

}

