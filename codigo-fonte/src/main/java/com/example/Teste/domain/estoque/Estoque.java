package com.example.Teste.domain.estoque;


import com.example.Teste.domain.cliente.Cliente;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "estoque")
@Entity(name = "estoque")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode (of = "id")
public class Estoque {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    private String id;

    private String name;

    private Integer prince_in_cents;

    private Integer quantidade;

    private Boolean active;

    public Estoque(RequestEstoque requestEstoque){
        this.name = requestEstoque.name();
        this.prince_in_cents = requestEstoque.prince_in_cents();
        this.quantidade = requestEstoque.quantidade();
        this.active = true;
    }

}
