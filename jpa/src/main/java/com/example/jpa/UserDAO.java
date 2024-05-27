package com.example.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class UserDAO {
    public User findUser(Long id){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        try {
            User user = em.find(User.class, id);
            return user;
        }finally {
            em.close();
        }
    }

    private EntityManagerFactory emf;

    public UserDAO() {
        emf = Persistence.createEntityManagerFactory("UserPU");
    }

    public void close(){
        if(emf != null){
            emf.close();
        }
    }

    public void createUser(User user){
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
//        EntityManager entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();

            entityManager.persist(user);

            entityManager.getTransaction().commit();
        }finally {
            entityManager.close();
        }
    }
}
