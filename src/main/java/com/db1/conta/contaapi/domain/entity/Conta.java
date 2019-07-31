package com.db1.conta.contaapi.domain.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.Assert;

public class Conta {
	
	private Long id;
	
	private Agencia agencia;
	
	private ContaTipo tipo;
	
	private String numero;
	
	private Double saldo;
	
	private Cliente cliente;
	
	private List<Historico> listaHistoricos = new ArrayList<>();

	public Conta(String numero, Agencia agencia, ContaTipo tipo, Double saldo, Cliente cliente) {
		Assert.hasText(numero, "Número é obrigatório");
		Assert.notNull(agencia, "Agência inexistente");
		Assert.notNull(saldo, "Saldo Indisponível");
		Assert.notNull(tipo, "A Conta deve ter um tipo");
		Assert.notNull(cliente, "Cliente indisponível");
		this.agencia = agencia;
		this.tipo = tipo;
		this.numero = numero;
		this.saldo = saldo;
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public Agencia getAgencia() {
		return agencia;
	}

	public ContaTipo getTipo() {
		return tipo;
	}

	public String getNumero() {
		return numero;
	}

	public Double getSaldo() {
		return saldo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public List<Historico> getListaHistoricos() {
		return listaHistoricos;
	}
}
