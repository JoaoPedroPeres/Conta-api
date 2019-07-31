package com.db1.conta.contaapi.domain.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.util.Assert;

public class Historico {
	
	private Long id;
	
	private HistoricoTipo tipo;
	
	private LocalDateTime data;
	
	private Double valor;
	
	private Conta conta;
	
	private Double valorResultante;
	
	public Historico(HistoricoTipo tipo, Double valor, Conta conta, Double valorResultante) {
		Assert.notNull(tipo, "O histórico deve ter um tipo");
		Assert.notNull(valor, "Não há valor na transação");
		Assert.notNull(conta, "Conta inválida");
		Assert.notNull(valorResultante, "Não houve valor resultante");
		this.conta = conta;
		this.valor = valor;
		this.tipo = tipo;
		this.valorResultante = valorResultante;		
	}

	public Long getId() {
		return id;
	}

	public HistoricoTipo getTipo() {
		return tipo;
	}

	public LocalDateTime getData() {
		return data;
	}

	public Double getValor() {
		return valor;
	}

	public Conta getConta() {
		return conta;
	}

	public Double getValorResultante() {
		return valorResultante;
	}
	
	

}
