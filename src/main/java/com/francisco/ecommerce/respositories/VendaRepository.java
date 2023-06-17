package com.francisco.ecommerce.respositories;


import com.francisco.ecommerce.entities.Produto;
import com.francisco.ecommerce.entities.Venda;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class VendaRepository {

    @PersistenceContext
    private EntityManager em;

    public List<Venda> vendas(){
        Query query = em.createQuery("from Venda");
        return query.getResultList();
    }

    public void save(Venda venda){
        em.persist(venda);
    }

    public List<Venda> findByData(LocalDate data) {
        Query query = em.createQuery("SELECT v FROM Venda v WHERE v.data = :data");
        query.setParameter("data", data);
        return query.getResultList();
    }
}
