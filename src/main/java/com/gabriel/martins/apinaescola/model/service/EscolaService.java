package com.gabriel.martins.apinaescola.model.service;

import com.gabriel.martins.apinaescola.model.dao.EscolaRepository;
import com.gabriel.martins.apinaescola.model.entity.EscolaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class EscolaService {

    @Autowired
    private EscolaRepository repository;

    @Transactional(readOnly = false)
    public void save(EscolaEntity entity) throws Exception {
        repository.save(entity);
    }

    @Transactional(readOnly = false)
    public void update(Object entity) throws Exception {

    }

    @Transactional(readOnly = false)
    public void remove(Object entity, Long id) throws Exception {

    }

    public EscolaEntity findById(Long id) {
        return null;
    }

    public EscolaEntity findByLogin(EscolaEntity escola) {
        return repository.findByLogin(escola);
    }
}
