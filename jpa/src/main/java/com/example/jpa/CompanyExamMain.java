package com.example.jpa;

import jakarta.persistence.EntityManager;

public class CompanyExamMain {
    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
    }
}
