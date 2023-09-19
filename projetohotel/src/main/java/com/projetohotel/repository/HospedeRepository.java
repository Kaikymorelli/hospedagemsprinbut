package com.projetohotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetohotel.entities.Hospede;

public interface HospedeRepository extends JpaRepository<Hospede, Long> {

}
