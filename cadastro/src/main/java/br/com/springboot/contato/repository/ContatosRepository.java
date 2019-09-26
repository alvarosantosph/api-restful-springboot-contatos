package br.com.springboot.contato.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.springboot.contato.model.Contato;

public interface ContatosRepository extends JpaRepository<Contato, Long> {

}
