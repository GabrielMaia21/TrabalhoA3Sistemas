package com.example.Teste.domain.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public  class SeederCliente implements CommandLineRunner {

    private RepositoryCliente repositoryCliente;

    public SeederCliente(RepositoryCliente repositoryCliente) {
        this.repositoryCliente = repositoryCliente;
    }

    @Override
    public void run (String... args) {

        List<Cliente> clientes = new ArrayList<>();

        clientes.add(new Cliente("1", "Gabriel", "123456789", true));
        clientes.add(new Cliente("2", "Pedro", "987654321", true));
        clientes.add(new Cliente("3", "Ivã", "111111111", true));
        clientes.add(new Cliente("4", "Rafael", "222222222", true));
        clientes.add(new Cliente("5", "Raissa", "333333333", true));
        clientes.add(new Cliente("6", "Athus", "444444444", true));
        clientes.add(new Cliente("7", "João", "55555555", true));
        clientes.add(new Cliente("8", "Vinicius", "666666666", true));
        clientes.add(new Cliente("9", "Lorena", "777777777", true));
        clientes.add(new Cliente("10", "Lucas", "888888888", true));

        repositoryCliente.saveAll(clientes);
    }


}
