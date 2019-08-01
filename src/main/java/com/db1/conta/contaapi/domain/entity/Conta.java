package com.db1.conta.contaapi.domain.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.util.Assert;

@Entity
@Table(name="conta")
public class Conta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "agencia_id", nullable = false)
	private Agencia agencia;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "conta_Tipo", nullable = false)
	private ContaTipo tipo;
	
	@Column(name = "numero", length = 20, nullable = false, unique = true)
	private String numero;
	
	@Column(name = "numero", length = 20, nullable = false)
	private Double saldo;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente", nullable = false)
	private Cliente cliente;
	
	@ElementCollection
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
	public void criarHistorico() {
		
	}
}
