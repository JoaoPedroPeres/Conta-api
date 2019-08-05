package com.db1.conta.contaapi.service;

import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
	

}
