package com.gabriel.martins.apinaescola.controller;

import com.gabriel.martins.apinaescola.model.entity.EscolaEntity;
import com.gabriel.martins.apinaescola.model.service.EscolaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class EscolaController {

    @Autowired
    private EscolaService service;

    @PostMapping("/escola")
    public ResponseEntity<?> cadastrarEscola(@RequestBody EscolaEntity escola){
        try {
            service.save(escola);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(escola);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não foi possível cadastrar a escola.");
        }
    }

    @PostMapping("/escola/login")
    public ResponseEntity<EscolaEntity> loginEscola(@RequestBody EscolaEntity escola){
        try {
            EscolaEntity escolaLogada = service.findByLogin(escola);
            return ResponseEntity.accepted().body(escolaLogada);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
