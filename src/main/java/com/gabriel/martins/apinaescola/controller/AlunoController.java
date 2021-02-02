package com.gabriel.martins.apinaescola.controller;

import com.gabriel.martins.apinaescola.model.entity.AlunoEntity;
import com.gabriel.martins.apinaescola.model.entity.EscolaEntity;
import com.gabriel.martins.apinaescola.model.service.AlunoService;
import com.gabriel.martins.apinaescola.model.service.EscolaService;
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
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class AlunoController {
    
    @Autowired
    private AlunoService service;
    
    @Autowired
    private EscolaService escolaService;
    
    @PostMapping("/aluno")
    public ResponseEntity<?> cadastrarEscola(@RequestBody AlunoEntity aluno){
        try {
            EscolaEntity escola = escolaService.findById(aluno.getEscola().getId());
            String codigoGerado = service.gerarCodigoEscola(escola, aluno.getUsuario().getCpf());
            
            aluno.setEscola(escola);
            aluno.setCodigoGeradoEscola(codigoGerado);
            
            service.save(aluno);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(aluno);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não foi possível cadastrar.");
        }
    }
    
    @GetMapping("/aluno/escola/{id}")
    public ResponseEntity<?> listarAlunosEscola(@PathVariable Long id){
        try {
            List<AlunoEntity> alunos = service.findByEscola(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(alunos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não foi possível encontrar os alunos.");
        }
    }
    
    @GetMapping("/aluno/{id}")
    public ResponseEntity<?> buscarAlunoPorId(@PathVariable Long id){
        try {
            AlunoEntity aluno = service.findById(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(aluno);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não foi possível encontrar o aluno.");
        }
    }
    
    @PutMapping("/aluno/{id}")
    public ResponseEntity<?> atualizarAlunoPorId(@PathVariable Long id, @RequestBody AlunoEntity aluno) {
        try {
            service.update(aluno);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(aluno);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Requisição inválida.");
        }
    }
    
    @DeleteMapping("/aluno/{id}")
    public ResponseEntity<?> removerAlunoPorId(@PathVariable Long id) {
        try {
            service.remove(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(Boolean.TRUE);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Necessário enviar um identificador válido.");
        }
    }
}
