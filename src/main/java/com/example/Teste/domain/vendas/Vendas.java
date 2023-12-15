package com.example.Teste.domain.vendas;

import com.example.Teste.domain.cliente.Cliente;
import com.example.Teste.domain.estoque.Estoque;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(name =  "vendas")
@Table(name = "vendas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Vendas {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToMany
    private List<Estoque> estoque = new ArrayList<>();

    private String id_produto;

    private LocalDate data_venda;

    private String id_cliente;

    private Integer quantidade_pedido;

    private boolean active;

    public Vendas(RequestVendas requestVendas){
        this.id_produto = requestVendas.id_produto();
        this.data_venda = requestVendas.data_venda();
        this.id_cliente = requestVendas.id_cliente();
        this.quantidade_pedido = requestVendas.quantidade_pedido();
        this.active = true;
    }

    @ManyToOne
    private Cliente cliente;
}
