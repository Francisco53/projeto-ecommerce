package com.francisco.ecommerce.respositories;

import com.francisco.ecommerce.entities.Endereco;
import com.francisco.ecommerce.entities.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EnderecoRepository {

    @PersistenceContext
    private EntityManager em;

    public Endereco save(Endereco endereco){
        em.persist(endereco);
        return endereco;
    }

    public Endereco endereco(Long id){
        return em.find(Endereco.class, id);
    }

    public List<Endereco> enderecos(){
        Query query = em.createQuery("from Endereco");
        return query.getResultList();
    }

    public void remove(Long id){
        Endereco e = em.find(Endereco.class, id);
        em.remove(e);
    }

    public void update(Endereco endereco){
        em.merge(endereco);
    }


    public Endereco findById(Long id) {
        return em.find(Endereco.class, id);
    }

}
