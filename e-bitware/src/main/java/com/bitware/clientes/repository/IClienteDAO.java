package com.bitware.clientes.repository;

import java.util.Optional;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.bitware.clientes.models.Cliente;

@Repository
public interface IClienteDAO extends MongoRepository<Cliente, String> {
	
	@Query("{clienteId:'?0'}")
	Cliente getClienteById(Integer id);
}
