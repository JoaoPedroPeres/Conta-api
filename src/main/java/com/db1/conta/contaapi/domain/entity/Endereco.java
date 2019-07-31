package com.db1.conta.contaapi.domain.entity;

import java.util.ArrayList;
import java.util.List;
import org.springframework.util.Assert;

public class Endereco {
	
	private Long id;
	
	private Cliente cliente;
	
	private String logradouro;
	
	private String numero;
	
	private Cidade cidade;
	
	private TipoEndereco tipoEndereco;
	
	private String complemento;
	
	public Endereco(Cliente cliente, String logradouro, String numero, Cidade cidade, TipoEndereco tipoEndereco, String complemento) {
		Assert.notNull(cidade, "Cidade inválida");
		Assert.hasText(logradouro, "É necessário haver um logradouro");
		Assert.hasText(numero, "Número inválido");
		Assert.notNull(tipoEndereco, "O endereço deve ter um tipo");
		Assert.notNull(cliente, "Deve ser adicionado um cliente");
		this.cidade = cidade;
		this.cliente = cliente;
		this.complemento = complemento;
		this.logradouro = logradouro;
		this.numero = numero;
		this.tipoEndereco = tipoEndereco;
	}

	public Long getId() {
		return id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public TipoEndereco getTipoEndereco() {
		return tipoEndereco;
	}

	public String getComplemento() {
		return complemento;
	}
	
	

}
