package com.sensor.nodered_api.controller;

import com.sensor.nodered_api.model.Dado;
import com.sensor.nodered_api.service.DadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dados")
@CrossOrigin(origins = "*") // Permitir todas as origens
public class DadosController {

    @Autowired
    private DadoService dadoService;

    @PostMapping
    public ResponseEntity<Dado> criarDado(@RequestBody Dado dado) {
        Dado novoDado = dadoService.salvarDado(dado);
        return ResponseEntity.ok(novoDado);
    }

    @GetMapping
    public ResponseEntity<List<Dado>> listarDados() {
        List<Dado> dados = dadoService.listarTodos();
        return ResponseEntity.ok(dados);
    }
}