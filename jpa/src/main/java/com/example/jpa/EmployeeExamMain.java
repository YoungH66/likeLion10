package com.example.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EmployeeExamMain {
    private static void find(){
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        try {
            Project project = entityManager.find(Project.class, 1L);
            log.info("Project Title : {}", project.getTitle());

            for(Employee employee : project.getEmployees()){
                log.info("Employee Name : {}", employee.getName());
            }
            entityManager.getTransaction().commit();
        }catch (Exception e){
            if(entityManager.getTransaction().isActive())
                entityManager.getTransaction().rollback();
            throw e;
        }
        finally {
            entityManager.close();
        }
    }

    private static void create(){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try {
            Employee employee = new Employee();
            employee.setName("King");

            Project project = new Project();
            project.setTitle("New Project Title");

            employee.getProjects().add(project);
            project.getEmployees().add(employee);

            em.persist(employee);
            em.persist(project);

            em.getTransaction().commit();
        }catch (Exception e){
            if(em.getTransaction().isActive())
                em.getTransaction().rollback();
            throw e;
        }finally {
            em.close();
        }
    }

    private static void delete(){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try {
            Employee employee = em.find(Employee.class, 3L);
            em.remove(employee);
            log.info("deleted Complete");
            em.getTransaction().commit();
        }catch (Exception e){
            if(em.getTransaction().isActive())
                em.getTransaction().rollback();
            throw e;
        }finally {
            em.close();
        }
    }

    private static void update(){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try {
            Employee employee = em.find(Employee.class, 3L);
            employee.setName("Queen");

            em.getTransaction().commit();
        }catch (Exception e){
            if(em.getTransaction().isActive())
                em.getTransaction().rollback();
            throw e;
        }finally {
            em.close();
        }
    }
    public static void main(String[] args) {
//        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
//        find();
//        create();
        update();
        delete();
    }
}
