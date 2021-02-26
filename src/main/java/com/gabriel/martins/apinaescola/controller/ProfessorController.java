/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gabriel.martins.apinaescola.controller;

import com.gabriel.martins.apinaescola.model.entity.ProfessorEntity;
import com.gabriel.martins.apinaescola.model.entity.UsuarioEntity;
import com.gabriel.martins.apinaescola.model.service.ProfessorService;
import com.gabriel.martins.apinaescola.model.service.UsuarioService;
import java.util.List;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author b2ml
 */
@CrossOrigin
@RestController
public class ProfessorController {
    
    @Autowired
    private ProfessorService service;
    
    @Autowired
    private UsuarioService usuarioService;
        
    @PostMapping("/professor")
    public ResponseEntity<?> saveProfessor(@RequestParam("hash") String hash, @RequestBody ProfessorEntity professor){
        if(!hash.isBlank() || !hash.isEmpty()){
            try {
                UsuarioEntity user = usuarioService.findByHash(hash);
                if(user != null){
                    service.save(professor);
                    return ResponseEntity.status(HttpStatus.ACCEPTED).body(professor);
                } else {
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Necessário autenticação.");
                }
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não foi possível cadastrar.");
            }
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Necessário autenticação.");
        }
    }
    
    @GetMapping("/professor/{id}")
    public ResponseEntity<?> findById(@RequestParam("hash") String hash, @PathVariable Long id) {
        if(!hash.isBlank() || !hash.isEmpty()){
            try {
                UsuarioEntity user = usuarioService.findByHash(hash);
                if(user != null){
                    ProfessorEntity professor = service.findById(id);
                    return ResponseEntity.status(HttpStatus.ACCEPTED).body(professor);
                } else {
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Necessário autenticação.");
                }
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Necessário enviar um identificador válido.");
            }
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Necessário autenticação.");
        }
    }
    
    @DeleteMapping("/professor/{id}")
    public ResponseEntity<?> deleteProfessorById(@RequestParam("hash") String hash, @PathVariable Long id) {
        if(!hash.isBlank() || !hash.isEmpty()){
            try {
                UsuarioEntity user = usuarioService.findByHash(hash);
                if(user != null){
                    service.remove(id);
                    return ResponseEntity.status(HttpStatus.ACCEPTED).body(Boolean.TRUE);
                } else {
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Necessário autenticação.");
                }
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Necessário enviar um identificador válido.");
            }
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Necessário autenticação.");
        }
    }

    @PutMapping("/professor")
    public ResponseEntity<?> updateProfessor(@RequestParam("hash") String hash, @RequestBody ProfessorEntity professor) {
        if(!hash.isBlank() || !hash.isEmpty()){
            try {
                UsuarioEntity user = usuarioService.findByHash(hash);
                if(user != null){
                    service.update(professor);
                    return ResponseEntity.status(HttpStatus.ACCEPTED).body(professor);
                } else {
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Necessário autenticação.");
                }
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Requisição inválida.");
            }
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Necessário autenticação.");
        }
    }
    
    @GetMapping("/professor/escola/{id}")
    public ResponseEntity<?> findByEscola(@RequestParam("hash") String hash, @PathVariable Long id) {
        if(!hash.isBlank() || !hash.isEmpty()){
            try {
                UsuarioEntity user = usuarioService.findByHash(hash);
                if(user != null){
                    List<ProfessorEntity> professores = service.findByEscola(id);
                    return ResponseEntity.status(HttpStatus.ACCEPTED).body(professores);
                } else {
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Necessário autenticação.");
                }
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Necessário enviar um identificador válido.");
            }
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Necessário autenticação.");
        }
    }
}
