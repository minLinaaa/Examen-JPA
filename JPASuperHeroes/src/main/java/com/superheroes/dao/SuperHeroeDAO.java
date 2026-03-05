/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.superheroes.dao;


import com.superheroes.model.SuperHeroe;
import com.superheroes.util.JPAUtil;
import jakarta.persistence.EntityManager;
import java.util.List;

/**
 *
 * @author anapa
 */
public class SuperHeroeDAO implements ISuperHeroeDAO {
      @Override
    public void insertar(SuperHeroe e) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void actualizar(SuperHeroe e) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(e);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void eliminar(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        SuperHeroe hero = em.find(SuperHeroe.class, id);
        if (hero != null) {
            em.remove(hero);
        }
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public SuperHeroe buscar(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        SuperHeroe hero = em.find(SuperHeroe.class, id);
        em.close();
        return hero;
    }

    @Override
    public List<SuperHeroe> listar() {
        EntityManager em = JPAUtil.getEntityManager();
        List<SuperHeroe> lista =
                em.createQuery("SELECT s FROM SuperHeroe s", SuperHeroe.class)
                        .getResultList();
        em.close();
        return lista;
    }
    
}
