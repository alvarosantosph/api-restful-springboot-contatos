package br.com.springboot.contato.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.springboot.contato.model.Contato;
import br.com.springboot.contato.repository.ContatosRepository;

@Service
public class ContatosService {

	@Autowired
	ContatosRepository contatosRepository;
	
	public Contato adicionar(Contato contato) {
		
		return contatosRepository.save(contato);
		
	}

	public List<Contato> listar() {
		
		return contatosRepository.findAll();
		
	}
	
	public Contato buscar(Long id) {
		
		Contato contato = contatosRepository.findOne(id);
		return contato;
		
	}

	public Contato atualizar(Long id, Contato contato) {
		
		Contato existente = contatosRepository.findOne(id);
		BeanUtils.copyProperties(contato, existente, "id");
		existente = contatosRepository.save(existente);
		return existente;
		
	}

	public void remover(Long id) {
		
		Contato contato = contatosRepository.findOne(id);
		contatosRepository.delete(contato);
		
	}
}
