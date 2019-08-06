package com.db1.conta.contaapi.service;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import com.db1.conta.contaapi.domain.dto.CidadePersistDTO;
import com.db1.conta.contaapi.domain.dto.CidadeResponseDTO;
import com.db1.conta.contaapi.repository.CidadeRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CidadeServiceTest {
	
	@Autowired
	private CidadeService cidadeService;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@After
	public void limpar() {
		cidadeRepository.deleteAll();
	}
	
//	@Test
//	public void deveCriarUmaCidade() {
//		CidadePersistDTO dto = new CidadePersistDTO();
//		dto.setNome("Maringa");
//		dto.setEstado("PR");
//		CidadeResponseDTO response = new CidadeResponseDTO();
//		
//		Assert.hasText(dto.getNome()););
//	}

}
