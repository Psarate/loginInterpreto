package br.com.interpreto.model.surdo;

import br.com.interpreto.model.usuario.Usuario;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "surdo")
public class Surdo extends Usuario {

    //file docCID;

    //CONSTRUTOR
    public Surdo() {

    }
    public Surdo(SurdoCadastroDTO dados) {
        this.setCpf(dados.cpf()); //dados são do tipo SurdoDTO que possuem GETTER, dados.cpf é como se usar esse GETTER
        this.setNome(dados.nome());
        this.setSobrenome(dados.sobrenome());
        this.setTelefone(dados.telefone());
        this.setLogin(dados.email());
        this.setSenha(dados.senha());
        this.setDataNascimento(dados.dataNascimento());
        this.setAtivo(false);

    }
	public void surdoAtualizarDTO(SurdoAtualizaDTO novosDados) {
		this.setCpf(novosDados.cpf()); //dados são do tipo SurdoDTO que possuem GETTER, dados.cpf é como se usar esse GETTER
        this.setNome(novosDados.nome());
        this.setSobrenome(novosDados.sobrenome());
        this.setTelefone(novosDados.telefone());
        this.setLogin(novosDados.email());
        this.setSenha(novosDados.senha());
        this.setDataNascimento(novosDados.dataNascimento());
        this.setAtivo(false);
	}

}