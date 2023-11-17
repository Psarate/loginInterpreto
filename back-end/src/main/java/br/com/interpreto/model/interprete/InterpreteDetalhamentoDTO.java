package br.com.interpreto.model.interprete;

import br.com.interpreto.model.enums.Especialidade;
import br.com.interpreto.model.enums.Regiao;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.Set;

public record InterpreteDetalhamentoDTO(
        Long id,
        String cpf,
        String nome,
        String sobrenome,
        String telefone,
        String email,
        String senha,
        @JsonFormat(pattern="yyyy-MM-dd")
        LocalDate dataNascimento,
        Set<Especialidade> especialidades,
        Set<Regiao> regioes,
        Double valorHora) {
    public InterpreteDetalhamentoDTO(Interprete interprete){
            this(interprete.getId(), interprete.getCpf(), interprete.getNome(), interprete.getSobrenome(), interprete.getTelefone(),
                    interprete.getLogin(), interprete.getSenha(), interprete.getDataNascimento(), interprete.getEspecialidade(),
                    interprete.getRegioes(), interprete.getValorHora());
    }
}
