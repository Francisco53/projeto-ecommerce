package com.francisco.ecommerce.respositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class ProdutoRepository {

    @PersistenceContext
    private EntityManager em;
}
