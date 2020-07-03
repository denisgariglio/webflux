package br.com.denisg.webflux.router;

import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import br.com.denisg.webflux.document.Funcionario;
import br.com.denisg.webflux.services.FuncionarioService;
import reactor.core.publisher.Mono;

@Component
public class FuncionarioHandler {
	
	@Autowired
	FuncionarioService service;
	
	public Mono<ServerResponse> findAll(ServerRequest request){
		
		return ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(service.findAll(), Funcionario.class);
	}
	
	public Mono<ServerResponse> findById(ServerRequest request){
		String id = request.pathVariable("id");
		return ok().contentType(MediaType.APPLICATION_JSON).body(service.findById(id), Funcionario.class);
				
	}
	
	public Mono<ServerResponse> findByCpf(ServerRequest request){
		String cpf = request.pathVariable("cpf");
		return ok().contentType(MediaType.APPLICATION_JSON).body(service.finByCpf(cpf), Funcionario.class);
	}
	
	public Mono<ServerResponse> save(ServerRequest request){
		final Mono<Funcionario> func = request.bodyToMono(Funcionario.class);
		
		return ok().contentType(MediaType.APPLICATION_JSON).body(fromPublisher(func.flatMap(service::save), Funcionario.class));
	}

}
