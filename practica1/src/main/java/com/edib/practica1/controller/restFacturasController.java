package com.edib.practica1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edib.practica1.model.TablaFacturas;
import com.edib.practica1.repository.FacturasRepository;

@RestController
@RequestMapping("/api")
public class restFacturasController {
	
	@Autowired
	FacturasRepository facturasRepository;
	 
	@PostMapping("/facturas")
	public ResponseEntity<TablaFacturas> createTablaFacturas(@RequestBody TablaFacturas tablaFacturas) {
		try {
			TablaFacturas tablasFacturasSave = facturasRepository.save(tablaFacturas);
			return new ResponseEntity<>(tablasFacturasSave, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/facturas")
	public ResponseEntity<List<TablaFacturas>> getTablaFacturas() {

		try {
			List<TablaFacturas> TablaFacturasSave = facturasRepository.findAll();
			return new ResponseEntity<>(TablaFacturasSave, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/facturas/{id}")
	public ResponseEntity<TablaFacturas> getTablaFacturasById(@PathVariable("id") long id) {
		
		Optional<TablaFacturas> tablaFacturaData = facturasRepository.findById(id);

		if (tablaFacturaData.isPresent()) {
			return new ResponseEntity<>(tablaFacturaData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
		
	
	
	@PutMapping("/facturas/{id}")
	public ResponseEntity<TablaFacturas> updateTablaFacturas(@PathVariable("id") long id, @RequestBody TablaFacturas tablaFacturas) {
		Optional<TablaFacturas> tablaFacturaData = facturasRepository.findById(id);

		if (tablaFacturaData.isPresent()) {
			TablaFacturas tablasFacturasSave = tablaFacturaData.get();
			tablasFacturasSave.setDescripcion(tablaFacturas.getDescripcion());
			tablasFacturasSave.setImporte(tablaFacturas.getImporte());
			tablasFacturasSave.setPagado(tablaFacturas.isPagado());

			return new ResponseEntity<>(facturasRepository.save(tablasFacturasSave), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/facturas/{id}")
	public ResponseEntity<HttpStatus> deleteTablaFacturas(@PathVariable("id") long id) {
		try {
			facturasRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	

}
