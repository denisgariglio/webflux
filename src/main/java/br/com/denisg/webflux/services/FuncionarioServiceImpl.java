package br.com.denisg.webflux.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.denisg.webflux.document.Funcionario;
import br.com.denisg.webflux.repository.FuncionarioRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

	@Autowired
	FuncionarioRepository repository;
	
	@Override
	public Flux<Funcionario> findAll() {
		return repository.findAll();
	}

	@Override
	public Mono<Funcionario> findById(String id) {
		return repository.findById(id);
	}

	@Override
	public Mono<Funcionario> finByCpf(String cpf) {
		return repository.findByCpf(cpf);
	}

	@Override
	public Mono<Funcionario> save(Funcionario funcionario) {
		return repository.save(funcionario);
	}

}
