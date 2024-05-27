package com.example.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class UserRun {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("UserPU");
        EntityManager entityManager = emf.createEntityManager();

        // 엔티티
        User user = new User();
//        user.setId(1L);
        user.setName("YH");
        user.setEmail("test@test.com");

        entityManager.getTransaction().begin();

        entityManager.persist(user);

        entityManager.getTransaction().commit();
    }
}
