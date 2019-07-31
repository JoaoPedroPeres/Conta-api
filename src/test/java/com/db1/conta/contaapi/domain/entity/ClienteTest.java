package com.db1.conta.contaapi.domain.entity;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class ClienteTest {
	
	@Test
	public void deveRetornarNomeObrigatorio() {
		String mensagem = null;
		try {		
			Cliente cliente = new Cliente(" ", "11212125123");
		}catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("Deve ser adicionado um nome válido", mensagem);
	}
	
	@Test
	public void deveRetornarCpfObrigatorio() {
		String mensagem = null;
		try {		
			Cliente cliente = new Cliente("José", null);
		}catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("Deve ser adicionado um CPF válido", mensagem);
	}
	
	@Test
	public void deveCriarUmCliente() {
		String mensagem = null;
		Cliente cliente = null;
		try {		
			cliente = new Cliente("José", "11212125123");
		}catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertNull(mensagem);
		Assert.assertEquals("José", cliente.getNome());
		Assert.assertEquals("11212125123", cliente.getCpf());
	}

}
