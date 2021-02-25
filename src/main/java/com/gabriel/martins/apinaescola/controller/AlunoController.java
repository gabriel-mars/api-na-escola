package com.gabriel.martins.apinaescola.controller;

import com.gabriel.martins.apinaescola.model.entity.AlunoEntity;
import com.gabriel.martins.apinaescola.model.entity.EscolaEntity;
import com.gabriel.martins.apinaescola.model.entity.UsuarioEntity;
import com.gabriel.martins.apinaescola.model.service.AlunoService;
import com.gabriel.martins.apinaescola.model.service.EscolaService;
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

@CrossOrigin
@RestController
public class AlunoController {
    
    @Autowired
    private AlunoService service;
    
    @Autowired
    private EscolaService escolaService;
    
    @Autowired
    private UsuarioService usuarioService;
    
    @PostMapping("/aluno")
    public ResponseEntity<?> cadastrarAluno(@RequestParam("hash") String hash, @RequestBody AlunoEntity aluno){
        if(hash.isBlank() || hash.isEmpty()){
            try {
                UsuarioEntity user = usuarioService.findByHash(hash);
                if(user != null){
                    EscolaEntity escola = escolaService.findById(aluno.getEscola().getId());
                    String codigoGerado = service.gerarCodigoEscola(escola, aluno.getUsuario().getCpf());

                    aluno.setEscola(escola);
                    aluno.setCodigoGeradoEscola(codigoGerado);

                    service.save(aluno);
                    return ResponseEntity.status(HttpStatus.ACCEPTED).body(aluno);
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
    
    @GetMapping("/aluno/escola/{id}")
    public ResponseEntity<?> listarAlunosEscola(@RequestParam("hash") String hash, @PathVariable Long id){
        if(hash.isBlank() || hash.isEmpty()){
            try {
                UsuarioEntity user = usuarioService.findByHash(hash);
                if(user != null){
                    List<AlunoEntity> alunos = service.findByEscola(id);
                    return ResponseEntity.status(HttpStatus.ACCEPTED).body(alunos);
                } else {
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Necessário autenticação.");
                }
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não foi possível encontrar os alunos.");
            }
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Necessário autenticação.");
        }
    }
    
    @GetMapping("/aluno/{id}")
    public ResponseEntity<?> buscarAlunoPorId(@RequestParam("hash") String hash, @PathVariable Long id){
        if(hash.isBlank() || hash.isEmpty()){
            try {
                UsuarioEntity user = usuarioService.findByHash(hash);
                if(user != null){
                    AlunoEntity aluno = service.findById(id);
                    return ResponseEntity.status(HttpStatus.ACCEPTED).body(aluno);
                } else {
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Necessário autenticação.");
                }
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não foi possível encontrar o aluno.");
            }
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Necessário autenticação.");
        }
    }
    
    @PutMapping("/aluno/{id}")
    public ResponseEntity<?> atualizarAlunoPorId(@RequestParam("hash") String hash, @PathVariable Long id, @RequestBody AlunoEntity aluno) {
        if(hash.isBlank() || hash.isEmpty()){
            try {
                UsuarioEntity user = usuarioService.findByHash(hash);
                if(user != null){
                    service.update(aluno);
                    return ResponseEntity.status(HttpStatus.ACCEPTED).body(aluno);
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
    
    @DeleteMapping("/aluno/{id}")
    public ResponseEntity<?> removerAlunoPorId(@RequestParam("hash") String hash, @PathVariable Long id) {
        if(hash.isBlank() || hash.isEmpty()){
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
}
