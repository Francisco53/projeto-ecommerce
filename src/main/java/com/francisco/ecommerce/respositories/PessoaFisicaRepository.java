package com.francisco.ecommerce.respositories;

import com.francisco.ecommerce.entities.Pessoa;
import com.francisco.ecommerce.entities.PessoaFisica;
import jakarta.persistence.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class PessoaFisicaRepository {

    @PersistenceContext
    private EntityManager em;

    public List<PessoaFisica> pessoaFisicas(){
        Query query = em.createQuery("from PessoaFisica");
        return query.getResultList();
    }

    public void salvar(PessoaFisica pessoaFisica) {
        em.persist(pessoaFisica);
    }


    public void remove(Long id){
        Pessoa p = em.find(PessoaFisica.class, id);
        em.remove(p);
    }

    public PessoaFisica pessoaFisica(Long id){
        return em.find(PessoaFisica.class, id);
    }

    public void update(PessoaFisica pessoaFisica){
        em.merge(pessoaFisica);
    }


    public PessoaFisica findIdByNome(String nome) {
        String jpql = "SELECT p FROM PessoaFisica p WHERE p.nome = :nome";
        TypedQuery<PessoaFisica> query = em.createQuery(jpql, PessoaFisica.class);
        query.setParameter("nome", nome);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }


}
