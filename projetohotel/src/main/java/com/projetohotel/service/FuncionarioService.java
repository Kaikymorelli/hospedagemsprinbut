package com.projetohotel.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetohotel.entities.Funcionario;
import com.projetohotel.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
	
	private final FuncionarioRepository funcionarioRepository;
	
	@Autowired
    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }
	
	  public List<Funcionario> getAllfuncionario() {
	        return funcionarioRepository.findAll();
	    }

	    public Funcionario getFuncionarioById(Long codigo) {
	        Optional<Funcionario> funcionario = funcionarioRepository.findById(codigo);
	        return funcionario.orElse(null);
	    }

	    public Funcionario salvarFuncionario(Funcionario funcionario) {
	        return funcionarioRepository.save(funcionario);
	    }

	    public Funcionario updateFuncionario(Long codigo, Funcionario updatedFuncionario) {
	        Optional<Funcionario> existingFuncionario = funcionarioRepository.findById(codigo);
	        if (existingFuncionario.isPresent()) {
	            updatedFuncionario.setId(codigo);
	            return funcionarioRepository.save(updatedFuncionario);
	        }
	        return null;
	    }

	    public boolean deleteFuncionario(Long codigo) {
	        Optional<Funcionario> existingFuncionario = funcionarioRepository.findById(codigo);
	        if (existingFuncionario.isPresent()) {
	            funcionarioRepository.deleteById(codigo);
	            return true;
	        }
	        return false;
	    }

}
