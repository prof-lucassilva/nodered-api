package com.sensor.nodered_api.repository;

import com.sensor.nodered_api.model.Dado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DadoRepository extends JpaRepository<Dado, Long> {
}
