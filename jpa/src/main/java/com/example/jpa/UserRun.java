package com.example.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class UserRun {
    public static void main(String[] args) {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("UserPU");
//        EntityManager entityManager = emf.createEntityManager();
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
//        // 엔티티
//        User user = new User();
////        user.setId(1L);
//        user.setName("YH");
//        user.setEmail("test@test.com");
//
//        entityManager.getTransaction().begin();
//
//        entityManager.persist(user);
//
//        entityManager.getTransaction().commit();

        // 여기까지도 영속성 컨텍스트가 관리하지는 않음.
        entityManager.getTransaction().begin();
//
//        //영속성 컨텍스트에게 관리를 맡김.  (영속상태)
//        entityManager.persist(user);
//        System.out.println("userId :::::::::::::::::"+user.getId());


//        User user1 = entityManager.find(User.class, 1L);
//        User user2 = entityManager.find(User.class, 1L);
//
//        if(user1 == user2)
//            System.out.println("user1 == user2");
//        else
//            System.out.println("user1 != user2");


//        //update
//        User user1 = entityManager.find(User.class, 1L);
//        user1.setEmail("new_user1@gmail.com");
//
//        user1.setName("updatedUser001");
//        user1.setName("updatedUser002");
//        user1.setEmail("new_user2@gmail.com");
//
        //delete
        User user1 = entityManager.find(User.class, 1L);
        entityManager.remove(user1);

        //이때 DB에 저장함.
        entityManager.getTransaction().commit();

    }
}
