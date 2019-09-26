package br.com.springboot.contato.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.springboot.contato.model.Contato;
import br.com.springboot.contato.service.ContatosService;

@RestController
@RequestMapping("/contatos")
public class ContatosController {

	@Autowired
	private ContatosService contatosService;

	@PostMapping
	public ResponseEntity<Contato> adicionar(@Valid @RequestBody Contato contato) {

		Contato pessoa = contatosService.adicionar(contato);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pessoa.getId()).toUri();
		return ResponseEntity.created(uri).body(pessoa);

	}

	@GetMapping
	public ResponseEntity<List<Contato>> listar() {

		return ResponseEntity.ok().body(contatosService.listar());

	}

	@GetMapping("/{id}")
	public ResponseEntity<Contato> buscar(@PathVariable Long id) {

		return ResponseEntity.ok(contatosService.buscar(id));

	}

	@PutMapping("/{id}")
	public ResponseEntity<Contato> atualizar(@PathVariable Long id, @Valid @RequestBody Contato contato) {

		return ResponseEntity.ok(contatosService.atualizar(id, contato));

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id) {

		contatosService.remover(id);
		return ResponseEntity.noContent().build();

	}
}