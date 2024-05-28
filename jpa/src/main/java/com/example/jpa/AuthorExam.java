package com.example.jpa;

import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AuthorExam {
    private static void find(){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try {
            Author author01 = em.find(Author.class, 1L);
            log.info("Author 1: {}", author01);

            for(Book book : author01.getStudents()) {
                log.info("Book title : {}", book.getTitle());
            }

            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }

    public static void main(String[] args) {
        find();
    }
}
