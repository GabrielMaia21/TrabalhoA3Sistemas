package com.example.Teste.domain.cliente;

import jakarta.persistence.*;
import lombok.*;




@Table (name = "cliente")
@Entity (name = "cliente")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    private String telefone;

    private boolean active;

    public Cliente(RequestCliente requestCliente){
        this.name = requestCliente.name();
        this.telefone = requestCliente.telefone();
        this.active = true;
    }
}
