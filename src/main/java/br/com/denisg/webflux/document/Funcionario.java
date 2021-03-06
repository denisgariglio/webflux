package br.com.denisg.webflux.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Document
@Getter
@Setter
@ToString
public class Funcionario {
	
	@Id
	private String id;
	private String nome;
	private String cpf;
	private String endereco;
	private String telefone;

}
