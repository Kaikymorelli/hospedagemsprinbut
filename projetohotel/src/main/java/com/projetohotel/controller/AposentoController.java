package com.projetohotel.controller;

import java.util.List;

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

import com.projetohotel.entities.Aposento;
import com.projetohotel.service.AposentoService;

@RestController
@RequestMapping("/aposentos")
public class AposentoController {
	private final AposentoService aposentoService;




	@Autowired
	public AposentoController(AposentoService aposentoService) {
		this.aposentoService = aposentoService;
	}


	@GetMapping("/{codigo}")
	public ResponseEntity<Aposento> getaposentosById(@PathVariable Long codigo) {
		Aposento aposento = aposentoService.getAposentoById(codigo);
		if (aposento != null) {
			return ResponseEntity.ok(aposento);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	public ResponseEntity<List<Aposento>> getAllAposentos() {
		List<Aposento> aposentos = aposentoService.getAllAposentos();
		return ResponseEntity.ok(aposentos);
	}

	@PostMapping("/")
	public ResponseEntity<Aposento> criarAposento(@RequestBody Aposento aposento) {
		Aposento criarAposento = aposentoService.salvarProduto(aposento);
		return ResponseEntity.status(HttpStatus.CREATED).body(criarAposento);
	}


	@PutMapping("/{codigo}")
	public ResponseEntity<Aposento> updateAposento(@PathVariable Long codigo, @RequestBody Aposento aposento) {
		Aposento updatedAposento = aposentoService.updateProduto(codigo, aposento);
		if (updatedAposento != null) {
			return ResponseEntity.ok(updatedAposento);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteProduto(@PathVariable Long id) {
		boolean deleted = aposentoService.deleteAposento(id);
		if (deleted) {
			return ResponseEntity.ok().body("O produto foi excluído com sucesso.");
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}