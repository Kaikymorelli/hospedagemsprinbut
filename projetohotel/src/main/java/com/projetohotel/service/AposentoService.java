package com.projetohotel.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetohotel.entities.Aposento;
import com.projetohotel.repository.AposentoRepository;

@Service
public class AposentoService {
	private final AposentoRepository aposentoRepository;
	
	@Autowired
    public AposentoService(AposentoRepository aposentoRepository) {
        this.aposentoRepository = aposentoRepository;
    }
	
	  public List<Aposento> getAllAposentos() {
	        return aposentoRepository.findAll();
	    }

	    public Aposento getAposentoById(Long codigo) {
	        Optional<Aposento> aposento = aposentoRepository.findById(codigo);
	        return aposento.orElse(null);
	    }

	    public Aposento salvarProduto(Aposento aposento) {
	        return aposentoRepository.save(aposento);
	    }

	    public Aposento updateProduto(Long codigo, Aposento updatedAposento) {
	        Optional<Aposento> existingAposento = aposentoRepository.findById(codigo);
	        if (existingAposento.isPresent()) {
	            updatedAposento.setId(codigo);
	            return aposentoRepository.save(updatedAposento);
	        }
	        return null;
	    }

	    public boolean deleteAposento(Long codigo) {
	        Optional<Aposento> existingAposento = aposentoRepository.findById(codigo);
	        if (existingAposento.isPresent()) {
	           aposentoRepository.deleteById(codigo);
	            return true;
	        }
	        return false;
	    }

}
