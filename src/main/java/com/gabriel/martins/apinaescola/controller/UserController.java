/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gabriel.martins.apinaescola.controller;

import com.gabriel.martins.apinaescola.model.entity.EscolaEntity;
import com.gabriel.martins.apinaescola.model.entity.ProfessorEntity;
import com.gabriel.martins.apinaescola.model.entity.ResponsavelEntity;
import com.gabriel.martins.apinaescola.model.entity.UserEntity;
import com.gabriel.martins.apinaescola.model.service.EscolaService;
import com.gabriel.martins.apinaescola.model.service.ProfessorService;
import com.gabriel.martins.apinaescola.model.service.ResponsavelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
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
    
    @PostMapping("/user/login")
    public ResponseEntity<?> loginUser(@RequestHeader("api-hash") String hash, @RequestBody UserEntity user){
        if(hash.isBlank() || hash.isEmpty()){
            try {
                switch(user.getTipo().getLabel()){
                    case "Escola":
//                        EscolaEntity escola = escolaService.findByLogin(escola);
//                        return ResponseEntity.status(HttpStatus.ACCEPTED).body(escola);
                        break;
                    
                    case "Professor(a)":
//                        ProfessorEntity professor = professorService.findByLogin(professor);
//                        return ResponseEntity.status(HttpStatus.ACCEPTED).body(professor);
                        break;
                        
                    case "Responsável":
//                        ResponsavelEntity responsavel = responsavelService.findByLogin(responsavel);
//                        return ResponseEntity.status(HttpStatus.ACCEPTED).body(responsavel);
                        break;
                }
                
                return ResponseEntity.status(HttpStatus.ACCEPTED).body("OK");
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário e/ou senha incorretos.");
            }
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Necessário autenticação.");
        }
    }
}
