package com.example.Teste.domain.cliente;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RequestCliente (
        String id,
        @NotBlank
        String name,

        @NotNull
        String telefone) {
}

