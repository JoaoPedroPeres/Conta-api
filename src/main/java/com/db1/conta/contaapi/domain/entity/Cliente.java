package com.db1.conta.contaapi.domain.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.springframework.util.Assert;
import org.springframework.util.Assert;

@Entity
@Table(name="cliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome", length = 60, nullable = false, unique = true)
	private String nome;
	
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<Endereco> listaEnderecos = new ArrayList<>();
	
	@Column(name = "cpf", length = 11, nullable = false, unique = true)
	private String cpf;
	
	protected Cliente() {}
	
	public Cliente(String nome, String cpf) {
		Assert.hasText(cpf, "Deve ser adicionado um CPF válido");
		Assert.hasText(nome, "Deve ser adicionado um nome válido");
		this.cpf = cpf;
		this.nome = nome;
	}
	
	public void addEndereco(String logradouro, String numero, Cidade cidade, TipoEndereco tipoEndereco, String complemento, String cep) {
		Endereco endereco = new Endereco(this, logradouro, numero, cidade, tipoEndereco, complemento, cep);
		this.listaEnderecos.add(endereco);
	}
	
	public void addEnderecoCobranca(String logradouro, String numero, Cidade cidade, TipoEndereco tipoEndereco, String complemento, String cep) {
		this.addEndereco(logradouro, numero, cidade, TipoEndereco.Cobrança, complemento, cep);
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
	
	

}
