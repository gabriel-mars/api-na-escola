/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gabriel.martins.apinaescola.controller;

import com.gabriel.martins.apinaescola.model.entity.EscolaEntity;
import com.gabriel.martins.apinaescola.model.entity.ProfessorEntity;
import com.gabriel.martins.apinaescola.model.entity.ResponsavelEntity;
import com.gabriel.martins.apinaescola.model.entity.UsuarioEntity;
import com.gabriel.martins.apinaescola.model.service.EscolaService;
import com.gabriel.martins.apinaescola.model.service.ProfessorService;
import com.gabriel.martins.apinaescola.model.service.ResponsavelService;
import com.gabriel.martins.apinaescola.model.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author gabrielmartins
 */

@CrossOrigin
@RestController
public class UserController {
    
    @Autowired
    private EscolaService escolaService;
    
    @Autowired
    private ProfessorService professorService;
    
    @Autowired
    private ResponsavelService responsavelService;
    
    @Autowired
    private UsuarioService usuarioService;
    
    @PostMapping("/user/login")
    public ResponseEntity<?> loginUser(@RequestBody UsuarioEntity user){
        try {
            user = usuarioService.findByLogin(user.getEmail(), user.getSenha());
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(user);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário e/ou senha incorretos.");
        }
    }
    
    @GetMapping("/user/login/complemento")
    public ResponseEntity<?> completarLogin(@RequestBody UsuarioEntity user){
        try {
            switch (user.getTipo().getLabel()) {
                case "Escola":
                    EscolaEntity escola = new EscolaEntity(user.getEmail(), user.getSenha());
                    escola = escolaService.findByLogin(escola);
                    return ResponseEntity.status(HttpStatus.ACCEPTED).body(escola);
                case "Professor(a)":
                    ProfessorEntity professor = professorService.findByLogin(user.getEmail(), user.getSenha());
                    return ResponseEntity.status(HttpStatus.ACCEPTED).body(professor);
                case "Responsável":
                    ResponsavelEntity responsavel = responsavelService.findByLogin(user.getEmail(), user.getSenha());
                    return ResponseEntity.status(HttpStatus.ACCEPTED).body(responsavel);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário e/ou senha incorretos.");
        }
        
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário e/ou senha incorretos.");
    }
}
