package com.db1.conta.contaapi.domain.entity;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class ContaTest {
	
	@Test
	public void deveRetornarAgenciaObrigatorio() {
		String mensagem = null;
		Agencia agencia = Mockito.mock(Agencia.class);
		Cliente cliente = Mockito.mock(Cliente.class);
		try {		
			Conta conta = new Conta("6", null, ContaTipo.Corrente, 13.0, cliente);
		}catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("Agência inexistente", mensagem);
	}
	
	@Test
	public void deveRetornarNumeroObrigatorio() {
		String mensagem = null;
		Agencia agencia = Mockito.mock(Agencia.class);
		Cliente cliente = Mockito.mock(Cliente.class);
		try {		
			Conta conta = new Conta(" ", agencia, ContaTipo.Corrente, 13.0, cliente);
		}catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("Número é obrigatório", mensagem);
	}
	
	@Test
	public void deveRetornarTipoObrigatorio() {
		String mensagem = null;
		Agencia agencia = Mockito.mock(Agencia.class);
		Cliente cliente = Mockito.mock(Cliente.class);
		try {		
			Conta conta = new Conta("6", agencia, null, 13.0, cliente);
		}catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("A Conta deve ter um tipo", mensagem);
	}
	
	@Test
	public void deveRetornarSaldoObrigatorio() {
		String mensagem = null;
		Agencia agencia = Mockito.mock(Agencia.class);
		Cliente cliente = Mockito.mock(Cliente.class);
		try {		
			Conta conta = new Conta("6", agencia, ContaTipo.Corrente, null, cliente);
		}catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("Saldo Indisponível", mensagem);
	}
	
	@Test
	public void deveRetornarClienteObrigatorio() {
		String mensagem = null;
		Agencia agencia = Mockito.mock(Agencia.class);
		Cliente cliente = Mockito.mock(Cliente.class);
		try {		
			Conta conta = new Conta("6", agencia, ContaTipo.Corrente, 13.0, null);
		}catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("Cliente indisponível", mensagem);
	}
	
	@Test
	public void deveCriarUmaConta() {
		String mensagem = null;
		Agencia agencia = Mockito.mock(Agencia.class);
		Cliente cliente = Mockito.mock(Cliente.class);
		Conta conta = null;
		try {		
			conta = new Conta("6", agencia, ContaTipo.Corrente, 13.0, cliente);
		}catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertNull(mensagem);
		Assert.assertEquals("6", conta.getNumero());
		Assert.assertEquals(agencia, conta.getAgencia());
		Assert.assertEquals(ContaTipo.Corrente, conta.getTipo());
//		Assert.assertEquals(13.0, conta.getSaldo());
		Assert.assertEquals(cliente, conta.getCliente());
	}

}
