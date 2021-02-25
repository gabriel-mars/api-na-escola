package com.gabriel.martins.apinaescola.controller;

import com.gabriel.martins.apinaescola.model.entity.EscolaEntity;
import com.gabriel.martins.apinaescola.model.service.EscolaService;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
    public ResponseEntity<?> loginEscola(@RequestParam("hash") String hash, @RequestBody EscolaEntity escola){
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
    public ResponseEntity<?> findById(@RequestParam("hash") String hash, @PathVariable Long id) {
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
    
    @GetMapping("/escola/user")
    public ResponseEntity<?> findAllByUser(@RequestParam("hash") String hash) {

        if(!hash.isBlank() || !hash.isEmpty()){
            try {
                List<EscolaEntity> escolas = service.buscarTodos();
                return ResponseEntity.status(HttpStatus.ACCEPTED).body(escolas);
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Necessário enviar um identificador válido.");
            }
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Necessário autenticação.");
        }
    }

    @DeleteMapping("/escola/{id}")
    public ResponseEntity<?> deleteUserById(@RequestParam("hash") String hash, @PathVariable Long id) {
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
    public ResponseEntity<?> updateUserById(@RequestParam("hash") String hash, @PathVariable Long id, @RequestBody EscolaEntity escola) {
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
