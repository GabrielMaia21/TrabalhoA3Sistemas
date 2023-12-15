package com.example.Teste.domain.estoque;

import com.example.Teste.domain.cliente.Cliente;
import com.example.Teste.domain.cliente.RepositoryCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SeederEstoque implements CommandLineRunner {

    public final RepositoryEstoque repositoryEstoque;

    @Autowired
    public SeederEstoque(RepositoryEstoque repositoryEstoque){
        this.repositoryEstoque = repositoryEstoque;
    }

    @Override
    public void run (String... args){
        List<Estoque> estoques = new ArrayList<>();

        estoques.add(new Estoque("1", "Camisa", 50, 100,true));
        estoques.add(new Estoque("2", "Calça", 100, 100,true));
        estoques.add(new Estoque("3", "Tênis", 150, 100,true));
        estoques.add(new Estoque("4", "Bermuda", 80, 100,true));
        estoques.add(new Estoque("5", "Meia", 25, 100,true));
        estoques.add(new Estoque("6", "Camiseta", 40, 100,true));
        estoques.add(new Estoque("7", "Cueca", 20, 100,true));
        estoques.add(new Estoque("8", "Relógio", 300, 100,true));
        estoques.add(new Estoque("9", "Pulseira", 15, 100,true));
        estoques.add(new Estoque("10", "Corrente", 15, 100,true));

        repositoryEstoque.saveAll(estoques);
    }
}
