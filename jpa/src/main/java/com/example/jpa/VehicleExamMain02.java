package com.example.jpa;

import jakarta.persistence.EntityManager;

import java.util.List;

public class VehicleExamMain02 {
    private static void find(){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        try {
            List<Vehicle2> vehicles = em.createQuery(
                    "SELECT v FROM Vehicle2 v", Vehicle2.class).getResultList();
            for (Vehicle2 vehicle : vehicles) {
                if (vehicle instanceof Car2) {
                    Car2 car = (Car2) vehicle;
                    System.out.println("Car2: " + car.getManufacturer() + ", Seats: " + car.getSeatCount());
                } else if (vehicle instanceof Truck2) {
                    Truck2 truck = (Truck2) vehicle;
                    System.out.println("Truck2: " + truck.getManufacturer() + ", Payload Capacity: " + truck.getPayloadCapactiy());
                }
            }
        }catch (Exception e){
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
            throw e;
        }finally {
            em.close();
        }
    }
    public static void main(String[] args) {
//        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
////
//        em.getTransaction().begin();
//        Car2 car1 = new Car2();
//        car1.setManufacturer("Hyundai");
//        car1.setSeatCount(4);
//        em.persist(car1);
//
//        Car2 car2 = new Car2();
//        car2.setManufacturer("ferrari");
//        car2.setSeatCount(4);
//        em.persist(car2);
//
//        Truck2 truck1 = new Truck2();
//        truck1.setManufacturer("쌍용");
//        truck1.setPayloadCapactiy(5.5);
//        em.persist(truck1);
////
//        em.getTransaction().commit();
        find();
    }
}
