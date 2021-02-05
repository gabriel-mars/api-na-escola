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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class EscolaController {

    @Autowired
    private EscolaService service;
    
    @PostMapping("/escola")
    public ResponseEntity<?> cadastrarEscola(@RequestHeader("api-hash") String hash, @RequestBody EscolaEntity escola){
        if(hash.isBlank() || hash.isEmpty()){
            try {
                service.save(escola);
                return ResponseEntity.status(HttpStatus.ACCEPTED).body(escola);
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não foi possível cadastrar.");
            }
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Necessário autenticação.");
        }
    }
    
    @PostMapping("/escola/login")
    public ResponseEntity<?> loginEscola(@RequestHeader("api-hash") String hash, @RequestBody EscolaEntity escola){
        if(hash.isBlank() || hash.isEmpty()){
            try {
                escola = service.findByLogin(escola);
                return ResponseEntity.status(HttpStatus.ACCEPTED).body(escola);
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário e/ou senha incorretos.");
            }
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Necessário autenticação.");
        }
    }
    
    @GetMapping("/escola/{id}")
    public ResponseEntity<?> findById(@RequestHeader("api-hash") String hash, @PathVariable Long id) {
        if(hash.isBlank() || hash.isEmpty()){
            try {
                EscolaEntity escola = service.findById(id);
                return ResponseEntity.status(HttpStatus.ACCEPTED).body(escola);
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Necessário enviar um identificador válido.");
            }
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Necessário autenticação.");
        }
    }

    @DeleteMapping("/escola/{id}")
    public ResponseEntity<?> deleteUserById(@RequestHeader("api-hash") String hash, @PathVariable Long id) {
        if(hash.isBlank() || hash.isEmpty()){
            try {
                service.remove(id);
                return ResponseEntity.status(HttpStatus.ACCEPTED).body(Boolean.TRUE);
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Necessário enviar um identificador válido.");
            }
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Necessário autenticação.");
        }
    }

    @PutMapping("/escola/{id}")
    public ResponseEntity<?> updateUserById(@RequestHeader("api-hash") String hash, @PathVariable Long id, @RequestBody EscolaEntity escola) {
        if(hash.isBlank() || hash.isEmpty()){
            try {
                service.update(escola);
                return ResponseEntity.status(HttpStatus.ACCEPTED).body(escola);
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Requisição inválida.");
            }
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Necessário autenticação.");
        }
    }
}
