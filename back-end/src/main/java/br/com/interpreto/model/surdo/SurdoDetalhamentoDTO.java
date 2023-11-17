package br.com.interpreto.model.surdo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public record SurdoDetalhamentoDTO(
        Long id,
        String cpf,
        String nome,
        String sobrenome,
        String telefone,
        String email,
        String senha,
        @JsonFormat(pattern="yyyy-MM-dd")
        LocalDate dataNascimento
) {
    public SurdoDetalhamentoDTO(Surdo surdo){
        this(surdo.getId(), surdo.getCpf(), surdo.getNome(), surdo.getSobrenome(), surdo.getTelefone(),
                surdo.getLogin(), surdo.getSenha(), surdo.getDataNascimento());
    }
}
