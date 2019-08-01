package com.db1.conta.contaapi.repository;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.db1.conta.contaapi.domain.entity.Endereco;
import com.db1.conta.contaapi.domain.entity.Agencia;
import com.db1.conta.contaapi.domain.entity.Cidade;
import com.db1.conta.contaapi.domain.entity.Cliente;
import com.db1.conta.contaapi.domain.entity.TipoEndereco;
import com.db1.conta.contaapi.domain.entity.Estado;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EnderecoRepositoryTest {
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@After
	public void afterTest() {
		enderecoRepository.deleteAll();
		cidadeRepository.deleteAll();
	}
	
	@Test
	public void deveSalvarUmEnderecoComCliente() {
		Cidade cidade = cidadeRepository.save(new Cidade("Maringá", Estado.AC));
		Cliente cliente = clienteRepository.save(new Cliente("José Almeida", "11111111111"));
		Endereco endereco = new Endereco(cliente, "Rua Marcílio Dias", "4510", cidade, TipoEndereco.Comercial, "B", "44444444");
		
		Endereco enderecoSalva = enderecoRepository.save(endereco);
		
		Assert.assertNotNull(enderecoSalva.getId());
		Assert.assertEquals(endereco.getTipoEndereco(), enderecoSalva.getTipoEndereco());
		Assert.assertEquals(endereco.getCliente().getNome(), enderecoSalva.getCliente().getNome());
		Assert.assertEquals(endereco.getNumero(), enderecoSalva.getNumero());
		Assert.assertEquals(endereco.getLogradouro(), enderecoSalva.getLogradouro());
		Assert.assertEquals(endereco.getCidade().getNome(), enderecoSalva.getCidade().getNome());
	}
	
	@Test
	public void deveBuscarEnderecoPorLogradouro() {
		Cidade cidade = cidadeRepository.save(new Cidade("Maringá", Estado.PR));
		Cliente cliente = clienteRepository.save(new Cliente("João Cleber", "22222222222"));
		Endereco endereco = new Endereco(cliente, "Rua Marcílio Dias", "4510", cidade, TipoEndereco.Comercial, "B", "66666666");
		
		enderecoRepository.save(endereco);
		
		Endereco enderecoBuscadoPorNome = enderecoRepository.findByLogradouro("Rua Marcílio Dias");
		
		Assert.assertNotNull(enderecoBuscadoPorNome.getId());
		Assert.assertEquals(endereco.getTipoEndereco(), enderecoBuscadoPorNome.getTipoEndereco());
		Assert.assertEquals(endereco.getCliente().getNome(), enderecoBuscadoPorNome.getCliente().getNome());
		Assert.assertEquals(endereco.getNumero(), enderecoBuscadoPorNome.getNumero());
		Assert.assertEquals(endereco.getLogradouro(), enderecoBuscadoPorNome.getLogradouro());
		Assert.assertEquals(endereco.getCidade().getNome(), enderecoBuscadoPorNome.getCidade().getNome());
	}
	
}
