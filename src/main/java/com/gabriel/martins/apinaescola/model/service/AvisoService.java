package com.gabriel.martins.apinaescola.model.service;

import com.gabriel.martins.apinaescola.model.dao.AvisoRepository;
import com.gabriel.martins.apinaescola.model.entity.AvisoEntity;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class AvisoService {
    
    @Autowired
    private AvisoRepository repository;
    
    @Transactional(readOnly = false)
    public void salvar(AvisoEntity aviso) { repository.save(aviso); }

    @Transactional(readOnly = false)
    public void editar(AvisoEntity aviso) { repository.update(aviso); }

    @Transactional(readOnly = false)
    public void excluir(Long id) { repository.delete(id); }

    public AvisoEntity buscarPorId(Long id) { return repository.findById(id); }

    public List<AvisoEntity> buscarTodos() { return repository.findAll(); }
    
    public List<AvisoEntity> buscarPorEscola(Long idEscola) { return repository.findByEscola(idEscola); }

    public List<AvisoEntity> buscarPorProfessor(Long idProfessor) { return repository.findByProfessor(idProfessor); }

    public List<AvisoEntity> buscarPorData(Long idEscola, Date data) { return repository.findByDay(idEscola, data); }
}
