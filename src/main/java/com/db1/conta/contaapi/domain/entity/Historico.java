package com.db1.conta.contaapi.domain.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.util.Assert;

@Entity
@Table(name="historico")
public class Historico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "historico_Tipo", nullable = false)
	private HistoricoTipo tipo;
	
	@Column(name = "data", nullable = false)
	private LocalDateTime data;
	
	@Column(name = "valor", length = 20, nullable = false)
	private Double valor;
	
	@Column(name = "valorResultante", length = 20, nullable = false)
	private Double valorResultante;
	
	public Historico(HistoricoTipo tipo, Double valor, Conta conta, Double valorResultante) {
		Assert.notNull(tipo, "O histórico deve ter um tipo");
		Assert.notNull(valor, "Não há valor na transação");
		Assert.notNull(valorResultante, "Não houve valor resultante");
		this.data = LocalDateTime.now();
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

	public Double getValorResultante() {
		return valorResultante;
	}
	
	

}
