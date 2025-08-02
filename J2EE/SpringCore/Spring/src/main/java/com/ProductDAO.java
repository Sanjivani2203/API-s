package com;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDAO {

    @Autowired
    private EntityManager em;

    // Save product
    public void save(Product p) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(p);
        et.commit();
    }

    // Fetch product by id
    public Product getProduct(int pid) {
        Query query = em.createQuery("SELECT p FROM Product p WHERE p.id = :pid");
        query.setParameter("pid", pid);
        return (Product) query.getSingleResult();
    }

    // Update product name by id
    public void updateName(int pid, String name) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        Query query = em.createQuery("UPDATE Product p SET p.name = :name WHERE p.id = :pid");
        query.setParameter("name", name);
        query.setParameter("pid", pid);
        query.executeUpdate();
        et.commit();
    }
    
}
