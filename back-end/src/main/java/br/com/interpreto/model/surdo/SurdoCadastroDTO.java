package br.com.interpreto.model.surdo;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

public record SurdoCadastroDTO(
        //RECORDS possuem GETTERS inclusos
        //TRABALHAR NAS VALIDACOES
        @NotBlank
        String cpf,
        @NotBlank(message = "O nome não pode estar em branco ou nulo!")
        @Length(min= 0 , max = 20)
        String nome,
        @NotBlank
        String sobrenome,
        @NotBlank
        String telefone,
        @NotBlank
        @Email
        String email,
        //@NotBlank
        String senha,
        @JsonFormat(pattern="yyyy-MM-dd")
        LocalDate dataNascimento
) {
}
