package com.sensor.nodered_api.service;

import com.sensor.nodered_api.model.Dado;
import com.sensor.nodered_api.repository.DadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DadoService {
    @Autowired
    private DadoRepository dadoRepository;

    public Dado salvarDado(Dado dado) {
        return dadoRepository.save(dado);
    }

    public List<Dado> listarTodos() {
        return dadoRepository.findAll();
    }
}