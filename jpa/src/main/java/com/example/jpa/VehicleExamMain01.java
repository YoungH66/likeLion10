package com.example.jpa;

import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class VehicleExamMain01 {

    private static void find(){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        try {
            List<Vehicle> vehicles = em.createQuery(
                    "SELECT v FROM Vehicle v", Vehicle.class).getResultList();
            for (Vehicle vehicle : vehicles) {
                if (vehicle instanceof Car) {
                    Car car = (Car) vehicle;
                    System.out.println("Car: " + car.getManufacturer() + ", Seats: " + car.getSeatCount());
                } else if (vehicle instanceof Truck) {
                    Truck truck = (Truck) vehicle;
                    System.out.println("Truck: " + truck.getManufacturer() + ", Payload Capacity: " + truck.getPayloadCapacity());
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
//
//        em.getTransaction().begin();
//        Car car1 = new Car();
//        car1.setManufacturer("Ford");
//        car1.setSeatCount(4);
//        em.persist(car1);
//
//        Car car2 = new Car();
//        car2.setManufacturer("Kia");
//        car2.setSeatCount(4);
//        em.persist(car2);
//
//        Truck truck1 = new Truck();
//        truck1.setManufacturer("Benz");
//        truck1.setPayloadCapacity(5.5);
//        em.persist(truck1);
//
//        em.getTransaction().commit();
        find();
    }
}
