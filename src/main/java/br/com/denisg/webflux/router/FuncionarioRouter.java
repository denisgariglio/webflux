package br.com.denisg.webflux.router;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;



@Configuration
public class FuncionarioRouter {
	
	@Bean
	public RouterFunction<ServerResponse> route(FuncionarioHandler handler){
		return RouterFunctions
				.route(GET("/funcionario").and(accept(MediaType.APPLICATION_JSON)), handler::findAll)
				.andRoute(GET("/funcionario/{id}").and(accept(MediaType.APPLICATION_JSON)), handler::findById)
				.andRoute(GET("/funcionario/cpf/{cpf}").and(accept(MediaType.APPLICATION_JSON)), handler::findByCpf)
				.andRoute(POST("/funcionario").and(accept(MediaType.APPLICATION_JSON)), handler::save);
		
	}

}
