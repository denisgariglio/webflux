package br.com.denisg.webflux.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import br.com.denisg.webflux.document.Funcionario;
import reactor.core.publisher.Mono;

public interface FuncionarioRepository extends ReactiveMongoRepository<Funcionario, String> {
	
	Mono<Funcionario> findByCpf(String cpf);

}
