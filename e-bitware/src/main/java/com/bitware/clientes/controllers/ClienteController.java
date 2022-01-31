package com.bitware.clientes.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bitware.clientes.models.Cliente;
import com.bitware.clientes.models.ObjectResponse;
import com.bitware.clientes.repository.IClienteDAO;

@RestController
@CrossOrigin(origins="*", methods= {RequestMethod.POST, RequestMethod.PUT, RequestMethod.GET, RequestMethod.DELETE})
@RequestMapping("/api/clientes")
public class ClienteController {
	@Autowired
	private IClienteDAO repository;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@PostMapping("/insertar")
	public ResponseEntity<ObjectResponse> crea( @Validated @RequestBody Cliente cliente) {
		
		Cliente clienteTemporal = this.repository.insert(cliente);
		ObjectResponse objResponse;
		if( clienteTemporal.get_id() == null) {
			objResponse = new ObjectResponse("-1", "Accion NO permitida", HttpStatus.BAD_REQUEST);
			return ResponseEntity.ok(objResponse);
		}else {
			objResponse = new ObjectResponse(clienteTemporal,"0", "Accion permitida", HttpStatus.CREATED);
			return ResponseEntity.ok(objResponse);
		}
	}
	
	@GetMapping("/")
	public List<Cliente> obtener(){
		return repository.findAll();
	}
	
	@GetMapping("/recuperMongo/{id}")
	public ResponseEntity<ObjectResponse> obtenerUsuarioMongo(@PathVariable String id) {
		Optional<Cliente> clienteTmp =  repository.findById(id);
		ObjectResponse objectResponse;
		
		if(clienteTmp.get().get_id() == null) {
			objectResponse = new ObjectResponse("-1", "Accion NO permitida", HttpStatus.BAD_REQUEST);
			return ResponseEntity.ok(objectResponse);
		}else {
			objectResponse = new ObjectResponse(clienteTmp,"0", "Accion permitida", HttpStatus.FOUND);
			return ResponseEntity.ok(objectResponse);
		}
		
	}
	
	@GetMapping("/recuperaUsuario/{id}")
	public ResponseEntity<ObjectResponse> obetenerUsuario(@PathVariable Integer id){
		Optional<Cliente> clienteTmp = Optional.of(repository.getClienteById(id));
		ObjectResponse objectResponse;
		
		if(clienteTmp.get().get_id() == null) {
			objectResponse = new ObjectResponse("-1", "Accion NO permitida", HttpStatus.BAD_REQUEST);
			return ResponseEntity.ok(objectResponse);
		}else {
			objectResponse = new ObjectResponse(clienteTmp,"0", "Accion permitida", HttpStatus.FOUND);
			return ResponseEntity.ok(objectResponse);
		}
		
	}
	
	@PutMapping("/actualizar/{id}")
	public ResponseEntity<ObjectResponse> actualizarUsuarioMongo(@PathVariable String id, @Validated @RequestBody Cliente cliente ) { 
		Cliente clienteTmp = repository.save(cliente);
		ObjectResponse objectResponse;
		if(clienteTmp.get_id() == null) {
			objectResponse = new ObjectResponse("-1", "Accion NO permitida", HttpStatus.BAD_REQUEST);
			return ResponseEntity.ok(objectResponse);
		}else {
			objectResponse = new ObjectResponse(clienteTmp,"0", "Accion permitida", HttpStatus.FOUND);
			return ResponseEntity.ok(objectResponse);
		}
		
	}
	
	@PutMapping("/actualizaCliente")
	public ResponseEntity<ObjectResponse> actualizarCliente(
			@Validated @RequestBody Cliente cliente){
		ObjectResponse obj;
		ObjectResponse obj2;
		
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(cliente.get_id()));
		Update update = new Update();
		update.set("edad", cliente.getEdad());
		update.set("estatura", cliente.getEstatura());
		update.set("peso", cliente.getPeso());
		update.set("geb", cliente.getGeb());
		
		Cliente clienteTmp = mongoTemplate.findAndModify(query, update, Cliente.class);
		Optional<Cliente> clienteRecuperado = repository.findById(clienteTmp.get_id());
		
		if( clienteRecuperado.get().get_id() == null) {
			obj = new ObjectResponse("-1", "Accion NO permitida", HttpStatus.BAD_REQUEST);
			return ResponseEntity.ok(obj);
		}else {
			obj2 = new ObjectResponse(clienteRecuperado,"0", "Accion permitida", HttpStatus.CREATED);
			return ResponseEntity.ok(obj2);
		}		
	}
	
	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable String id) {
		repository.deleteById(id);
	}
	
	
	
}
