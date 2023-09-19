package com.projetohotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetohotel.entities.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}
