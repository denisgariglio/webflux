package br.com.denisg.webflux.services;

import br.com.denisg.webflux.document.Funcionario;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface FuncionarioService {
	
	Flux<Funcionario> findAll();
	Mono<Funcionario> findById(String id);
	Mono<Funcionario> finByCpf(String cpf);
	Mono<Funcionario> save(Funcionario funcionario);	
 
}
