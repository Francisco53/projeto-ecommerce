package com.francisco.ecommerce.respositories;

import com.francisco.ecommerce.entities.Pessoa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class PesssoaRepository {

    @PersistenceContext
    private EntityManager em;

    public Pessoa findById(Long id){
        return em.find(Pessoa.class, id);
    }
}
