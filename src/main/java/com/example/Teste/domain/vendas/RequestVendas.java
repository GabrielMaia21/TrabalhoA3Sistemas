package com.example.Teste.domain.vendas;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record RequestVendas(
        @NotBlank
        String id_produto,

        LocalDate data_venda,
        @NotBlank
        String id_cliente,
        @NotNull
        Integer quantidade_pedido
) {
}
