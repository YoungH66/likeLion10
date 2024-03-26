package com.example.day06.test0326;

public class ElectricCar extends Car{
    double batteryCapacity;
    public ElectricCar(String brand, String model, int year, double batteryCapacity){
        super(brand, model, year);
        this.batteryCapacity = batteryCapacity;
    }
    @Override
    public void displayInfo(){
        System.out.println("Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year + '\'' +
                ", batteryCapacity=" + batteryCapacity +
                '}');
    }
}
