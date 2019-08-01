package com.db1.conta.contaapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.db1.conta.contaapi.domain.entity.Cliente;
import com.db1.conta.contaapi.domain.entity.Endereco;
import com.db1.conta.contaapi.domain.entity.Agencia;
import com.db1.conta.contaapi.domain.entity.Cidade;
import com.db1.conta.contaapi.domain.entity.Estado;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
	Cliente findByNome(String nome);
	Cliente findByCpf(String cpf);

}
