package br.com.interpreto.controller;

import br.com.interpreto.model.interprete.Interprete;
import br.com.interpreto.model.interprete.InterpreteAtualizaDTO;
import br.com.interpreto.model.interprete.InterpreteCadastroDTO;
import br.com.interpreto.model.interprete.InterpreteDetalhamentoDTO;
import br.com.interpreto.service.InterpreteService;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/interprete")
@CrossOrigin(origins = "*")
public class InterpreteController {
	private final InterpreteService interpreteService;

	@Autowired //INJECAO DE DEPENDENCIA VIA CONSTRUTOR
	public InterpreteController(InterpreteService interpreteService) {
		this.interpreteService = interpreteService;
	}

	@GetMapping
	public ResponseEntity<List<InterpreteDetalhamentoDTO>> listarInterprete() {
		return interpreteService.listarInterprete();
	}

	@PostMapping
	public ResponseEntity cadastrarInterprete(@RequestParam("dados") String dados, @RequestParam("arquivo") MultipartFile arquivo, UriComponentsBuilder uriBuilder) throws JsonProcessingException {
		return interpreteService.cadastrarInterprete(dados, arquivo, uriBuilder);
	}

	@GetMapping("/{id}")
	public ResponseEntity buscarInterprete(@PathVariable Long id) {
		return interpreteService.buscarInterprete(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity atualizarInterprete(@PathVariable Long id, @RequestBody @Valid InterpreteAtualizaDTO novosDados) {
		return interpreteService.atualizarInterprete(id, novosDados);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity deletarInterprete(@PathVariable Long id) {
		return interpreteService.deletarInterprete(id);
	}

}
