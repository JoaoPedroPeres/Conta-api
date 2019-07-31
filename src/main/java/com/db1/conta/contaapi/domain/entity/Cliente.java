package com.db1.conta.contaapi.domain.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.Assert;

public class Cliente {
	
	private Long id;
	
	private String nome;
	
	private List<Endereco> listaEnderecos = new ArrayList<>();
	
	private String cpf;
	
	private List<Conta> listaContas;
	
	public Cliente(String nome, String cpf) {
		Assert.hasText(cpf, "Deve ser adicionado um CPF válido");
		Assert.hasText(nome, "Deve ser adicionado um nome válido");
		this.cpf = cpf;
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public List<Endereco> getListaEnderecos() {
		return listaEnderecos;
	}

	public String getCpf() {
		return cpf;
	}

	public List<Conta> getListaContas() {
		return listaContas;
	}
	
	

}
