package com.gabriel.martins.apinaescola.model.service;

import com.gabriel.martins.apinaescola.model.dao.EmailRepository;
import com.gabriel.martins.apinaescola.model.dao.EscolaRepository;
import com.gabriel.martins.apinaescola.model.entity.DiaLetivoEntity;
import com.gabriel.martins.apinaescola.model.entity.EmailEntity;
import com.gabriel.martins.apinaescola.model.entity.EscolaEntity;
import com.gabriel.martins.apinaescola.model.entity.RequisicaoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
@Transactional(readOnly = true)
public class EscolaService {

    @Autowired
    private EscolaRepository repository;

    @Autowired
    private EmailRepository emailRepository;

    @Transactional(readOnly = false)
    public void save(EscolaEntity entity) throws Exception {
        try {
            repository.save(entity);

            EmailEntity email = new EmailEntity();
            email.setCodigoMec(entity.getCodigoMec());
            email.setEmailEscola(entity.getEmail());
            email.setNomeEscola(entity.getNome());
            email.setCaracteristica("cadastro");

            emailRepository.save(email);
        } catch (Exception e) {
            Logger.getLogger(EscolaService.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Transactional(readOnly = false)
    public void update(EscolaEntity entity) throws Exception { repository.update(entity); }

    @Transactional(readOnly = false)
    public void remove(Long id) throws Exception { repository.delete(id); }

    public EscolaEntity findById(Long id) { return repository.findById(id); }

    public EscolaEntity findByLogin(EscolaEntity escola) { return repository.findByLogin(escola); }

    @Transactional(readOnly = true)
    public List<EscolaEntity> buscarTodos() { return repository.findAll(); }

    @Transactional(readOnly = true)
    public EscolaEntity verifyLogin(EscolaEntity escola){
        try {
            escola = repository.findByLogin(escola);
        }catch (Exception e){
            Logger.getLogger(EscolaService.class.getName()).log(Level.SEVERE, "NULL -> Escola não encontrada", e);
        }

        return escola;
    }

    public void completarCadastroEscola(EscolaEntity escola) { repository.finishCreateEscola(escola); }

    @Transactional(readOnly = true)
    public EscolaEntity buscarPorCodigo(Integer codigoMecEscola) throws Exception {
        EscolaEntity escola = new EscolaEntity();

        try {
            escola = repository.readByCodigo(codigoMecEscola);
        } catch (Exception e) {
            Logger.getLogger(EscolaService.class.getName()).log(Level.SEVERE, "NULL -> Escola não encontrada", e);
        }

        return escola;
    }

    public void updateSenhaEscola(EscolaEntity escola) { repository.updateSenhaEscola(escola); }

    public String gerarSenhaAleatoria() {
        String senhaAleatoria;

        senhaAleatoria = generateSecurityKey();

        return senhaAleatoria;
    }

    private String generateSecurityKey(){
        int maxCharacters = 8;
        String[] characters = { "a", "1", "b", "2", "4", "5", "6", "7", "8",
                "9", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k",
                "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w",
                "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I",
                "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U",
                "V", "W", "X", "Y", "Z","!","#","$","%" };

        StringBuilder securityKey = new StringBuilder();

        for (int i = 0; i < maxCharacters; i++) {
            int posicao = (int) (Math.random() * characters.length);
            securityKey.append(characters[posicao]);
        }

        return securityKey.toString();
    }

    @Transactional(readOnly = true)
    public List<RequisicaoEntity> buscarRequisicoes(Long id) { return repository.findRequisicoes(id); }

    @Transactional(readOnly = false)
    public void salvarDiasetivos(List<DiaLetivoEntity> dias) { repository.saveAllDiasLetivos(dias); }

    @Transactional(readOnly = true)
    public List<DiaLetivoEntity> getDiasLetivos(Long idEscola){ return repository.findDiasLetivosByEscola(idEscola); }
}
