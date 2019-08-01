package com.db1.conta.contaapi.domain.entity;

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
import javax.persistence.UniqueConstraint;

import org.springframework.util.Assert;

@Entity
@Table(name="endereco")
public class Endereco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id", nullable = false)
	private Cliente cliente;
	
	@Column(name = "logradouro", length = 60, nullable = false, unique = true)
	private String logradouro;
	
	@Column(name = "numero", length = 20, nullable = false, unique = true)
	private String numero;
	
	@ManyToOne
	@JoinColumn(name = "cidade", nullable = false, unique = true)
	private Cidade cidade;
	
	@Column(name = "cep")
	private String cep;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_Endereco", nullable = false)
	private TipoEndereco tipoEndereco;
	
	@Column(name = "complemento", length = 60, nullable = false, unique = true)
	private String complemento;
	
	protected Endereco() {}
	
	public Endereco(Cliente cliente, String logradouro, String numero, Cidade cidade, TipoEndereco tipoEndereco, String complemento, String cep) {
		Assert.notNull(cidade, "Cidade inválida");
		Assert.hasText(logradouro, "É necessário haver um logradouro");
		Assert.hasText(numero, "Número inválido");
		Assert.hasText(cep, "CEP inválido");
		Assert.isTrue(cep.length() == 8, "CEP inválido");
		Assert.notNull(tipoEndereco, "O endereço deve ter um tipo");
		Assert.notNull(cliente, "Deve ser adicionado um cliente");
		this.cidade = cidade;
		this.cliente = cliente;
		this.complemento = complemento;
		this.logradouro = logradouro;
		this.numero = numero;
		this.tipoEndereco = tipoEndereco;
		this.cep = cep;
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
