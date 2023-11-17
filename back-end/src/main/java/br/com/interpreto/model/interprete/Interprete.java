package br.com.interpreto.model.interprete;

import br.com.interpreto.model.enums.Especialidade;
import br.com.interpreto.model.enums.Regiao;
import br.com.interpreto.model.usuario.Usuario;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.validation.Valid;

import java.util.Set;

@Entity
@Table(name = "interprete")
public class Interprete extends Usuario {

	private Double valorHora;
	@Enumerated(EnumType.STRING)
	private Set<Especialidade> especialidade;
	// file docCertificado;
	@Enumerated(EnumType.STRING)
	private Set<Regiao> regioes;

	public Interprete(@Valid InterpreteCadastroDTO dados) {
		this.setCpf(dados.cpf());
		this.setNome(dados.nome());
		this.setSobrenome(dados.sobrenome());
		this.setTelefone(dados.telefone());
		this.setLogin(dados.email());
		this.setSenha(dados.senha());
		this.setDataNascimento(dados.dataNascimento());
		this.setAtivo(false);
		this.valorHora = dados.valorHora();
		this.especialidade = dados.especialidades();
		this.regioes = dados.regioes();
	}
	
	public void interpreteAtualizarDTO(InterpreteAtualizaDTO novosDados) {
		this.setCpf(novosDados.cpf());
		this.setNome(novosDados.nome());
		this.setSobrenome(novosDados.sobrenome());
		this.setTelefone(novosDados.telefone());
		this.setLogin(novosDados.email());
		this.setSenha(novosDados.senha());
		this.setDataNascimento(novosDados.dataNascimento());
		this.valorHora = novosDados.valorHora();
		this.especialidade = novosDados.especialidades();
		this.regioes = novosDados.regioes();
	}

	// CONSTRUTOR
	public Interprete() {
	}

	public Double getValorHora() {
		return valorHora;
	}

	public void setValorHora(Double valorHora) {
		this.valorHora = valorHora;
	}

	public Set<Especialidade> getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(Set<Especialidade> especialidade) {
		this.especialidade = especialidade;
	}

	public Set<Regiao> getRegioes() {
		return regioes;
	}

	public void setRegioes(Set<Regiao> regioes) {
		this.regioes = regioes;
	}
}
