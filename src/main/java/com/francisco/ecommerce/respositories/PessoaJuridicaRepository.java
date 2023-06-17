package com.francisco.ecommerce.respositories;

import com.francisco.ecommerce.entities.Pessoa;
import com.francisco.ecommerce.entities.PessoaFisica;
import com.francisco.ecommerce.entities.PessoaJuridica;
import com.francisco.ecommerce.entities.Produto;
import jakarta.persistence.*;
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


    public List<PessoaJuridica> findPessoaJuridicaByNome(String nome) {
        TypedQuery<PessoaJuridica> query =
                em.createQuery("SELECT pj FROM PessoaJuridica pj WHERE pj.razaoSocial LIKE :nomepesquisa", PessoaJuridica.class);
        query.setParameter("nomepesquisa", "%"+nome+"%");
        return query.getResultList();
    }

    public PessoaJuridica findIdByRazaoSocial(String nome) {
        String jpql = "SELECT p FROM PessoaJuridica p WHERE p.razaoSocial = :nome";
        TypedQuery<PessoaJuridica> query = em.createQuery(jpql, PessoaJuridica.class);
        query.setParameter("nome", nome);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }



}
