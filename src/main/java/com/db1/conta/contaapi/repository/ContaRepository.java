package com.db1.conta.contaapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.db1.conta.contaapi.domain.entity.Conta;
import com.db1.conta.contaapi.domain.entity.ContaTipo;
import com.db1.conta.contaapi.domain.entity.Cliente;
import com.db1.conta.contaapi.domain.entity.Agencia;
import com.db1.conta.contaapi.domain.entity.Cidade;
import com.db1.conta.contaapi.domain.entity.Estado;

public interface ContaRepository {
	
	Conta findByAgencia(Agencia agencia);
	Conta findByTipo(ContaTipo tipo);
	Conta findByNumero(String numero);
	Conta findBySaldo(Double saldo);
	Conta findByCliente(Cliente cliente);
	Conta findByAgenciaCidade(Cidade cidade);
	Conta findByAgenciaCidadeEstado(Estado estado);
}
