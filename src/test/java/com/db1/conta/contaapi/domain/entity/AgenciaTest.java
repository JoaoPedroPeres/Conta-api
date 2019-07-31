package com.db1.conta.contaapi.domain.entity;

import org.junit.Assert;
import org.junit.Test;

public class AgenciaTest {
	
	@Test
	public void deveRetornarNumeroObrigatorio() {
		String mensagem = null;
		Cidade cidade = new Cidade("Maringá",Estado.PR);
		try {		
			Agencia agencia = new Agencia("", "3", cidade);
		}catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("Número é obrigatório", mensagem);
	}
	
	@Test
	public void deveRetornarDigitoObrigatorio() {
		String mensagem = null;
		Cidade cidade = new Cidade("Maringá",Estado.PR);
		try {		
			Agencia agencia = new Agencia("32501", " ", cidade);
		}catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("Digito é obrigatório", mensagem);
	}
	
	@Test
	public void deveRetornarCidadeObrigatorio() {
		String mensagem = null;
		try {		
			Agencia agencia = new Agencia("32501", "2", null);
		}catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("Cidade é obrigatório", mensagem);
	}
	
	@Test
	public void deveCriarUmaAgencia() {
		String mensagem = null;
		Cidade cidade = new Cidade("Maringá",Estado.PR);
		Agencia agencia = null;
		try {		
			agencia = new Agencia("32501", "2", cidade);
		}catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertNull(mensagem);
		Assert.assertEquals("32501", agencia.getNumero());
		Assert.assertEquals("2", agencia.getDigito());
		Assert.assertEquals(cidade, agencia.getCidade());
	}

}
