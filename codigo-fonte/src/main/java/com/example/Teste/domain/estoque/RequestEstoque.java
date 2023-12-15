package com.example.Teste.domain.estoque;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RequestEstoque(

        String id,
        @NotBlank
        String name,

        @NotNull
        Integer prince_in_cents,

        @NotNull
        Integer quantidade) {
}
