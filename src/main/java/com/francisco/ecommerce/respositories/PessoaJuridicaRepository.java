package com.francisco.ecommerce.respositories;

import com.francisco.ecommerce.entities.Pessoa;
import com.francisco.ecommerce.entities.PessoaFisica;
import com.francisco.ecommerce.entities.PessoaJuridica;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PessoaJuridicaRepository {

    @PersistenceContext
    private EntityManager em;

    public List<PessoaJuridica> pessoaJuridicas(){
        Query query = em.createQuery("from PessoaJuridica");
        return query.getResultList();
    }

    public void salvar(PessoaJuridica pessoaJuridica) {
        em.persist(pessoaJuridica);
    }


    public void remove(Long id){
        Pessoa p = em.find(PessoaJuridica.class, id);
        em.remove(p);
    }

    public PessoaJuridica pessoaJuridica(Long id){
        return em.find(PessoaJuridica.class, id);
    }

    public void update(PessoaJuridica pessoaJuridica){
        em.merge(pessoaJuridica);
    }
}
