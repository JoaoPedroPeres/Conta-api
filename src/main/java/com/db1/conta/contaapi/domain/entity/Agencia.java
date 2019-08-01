package com.db1.conta.contaapi.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.util.Assert;


@Entity
@Table(name = "Agencia")
public class Agencia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "numero", length = 4, nullable = false, unique = true)
	private String numero;
	
	@Column(name = "digito", length = 1, nullable = false)
	private String digito;
	
	@ManyToOne
	@JoinColumn(name = "cidade_id", nullable = false)
	private Cidade cidade;
	
	protected Agencia() {}

	public Agencia(String numero, String digito, Cidade cidade) {
		Assert.hasText(numero, "Número é obrigatório");
		Assert.hasText(digito, "Digito é obrigatório");
		Assert.notNull(cidade, "Cidade é obrigatório");
		this.cidade = cidade;
		this.digito = digito.trim();
		this.numero = numero.trim();
	}

	public Long getId() {
		return id;
	}

	public String getNumero() {
		return numero;
	}

	public String getDigito() {
		return digito;
	}

	public Cidade getCidade() {
		return cidade;
	}
	
	

}
