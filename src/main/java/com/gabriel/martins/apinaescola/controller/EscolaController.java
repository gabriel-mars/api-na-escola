package com.gabriel.martins.apinaescola.controller;

import com.gabriel.martins.apinaescola.model.entity.EscolaEntity;
import com.gabriel.martins.apinaescola.model.service.EscolaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não foi possível cadastrar.");
        }
    }
    
    @PostMapping("/escola/login")
    public ResponseEntity<?> loginEscola(@RequestBody EscolaEntity escola){
        try {
            escola = service.findByLogin(escola);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(escola);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário e/ou senha incorretos.");
        }
    }
    
    @GetMapping("/escola/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        try {
            EscolaEntity escola = service.findById(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(escola);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Necessário enviar um identificador válido.");
        }
    }

    @DeleteMapping("/escola/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable Long id) {
        try {
            service.remove(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(Boolean.TRUE);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Necessário enviar um identificador válido.");
        }
    }

    @PutMapping("/escola/{id}")
    public ResponseEntity<?> updateUserById(@PathVariable Long id, @RequestBody EscolaEntity escola) {
        try {
            service.update(escola);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(escola);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Requisição inválida.");
        }
    }
}
