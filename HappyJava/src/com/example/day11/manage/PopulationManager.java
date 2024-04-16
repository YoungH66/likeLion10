package com.example.day11.manage;

import java.util.*;

public class PopulationManager {
    //알맞게 구현해 주세요.
    Map<String, Integer> population = new HashMap<>();

    void addOrUpdateCity(String city, int population) {
        System.out.println("데이터 입력 city: " + city + " population: " + population);
        if(this.population.containsKey(city)) {
            System.out.println("이미 존재하는 도시입니다. 인구수를 수정합니다.");
            this.population.replace("city", population);
        }else{
            this.population.put(city, population);
        }
        System.out.println();
    }

    void removeCity(String city) {
        if(!this.population.containsKey(city)) {
            System.out.println("해당 데이터가 없습니다.");
            return;
        }
        System.out.println("해당 데이터를 삭제했습니다.");
        this.population.remove(city);
        System.out.println();
    }

    void displayPopulation(String city) {
        if(!this.population.containsKey(city)) {
            System.out.println("해당 데이터가 없습니다.");
            return;
        }
        System.out.println("해당 도시 인구수 정보");
        System.out.println("city: " + city + ", population: " + this.population.get(city));
        System.out.println();
    }

    void displayAll(){
        System.out.println("도시 전체 정보");
        for(String city : population.keySet()){
            System.out.println("city: " + city + ", population: " + population.get(city));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        PopulationManager manager = new PopulationManager();
        Scanner scanner = new Scanner(System.in);

        manager.addOrUpdateCity("서울", 10000000);
        manager.addOrUpdateCity("부산", 3500000);

        while (true) {
            System.out.println("명령을 입력하세요 (추가/수정, 삭제, 조회, 전체 조회, 종료): ");
            String command = scanner.next();
            if (command.equals("종료")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            String city;
            switch (command) {
                // case를 영어 이외로 할 경우 예외 발생할 가능성 있음
                case "추가/수정":
                    System.out.print("도시 이름을 입력하세요: ");
                    city = scanner.next();
                    System.out.print("인구를 입력하세요: ");
                    int population = scanner.nextInt();
                    manager.addOrUpdateCity(city, population);
                    break;
                case "삭제":
                    System.out.print("도시 이름을 입력하세요: ");
                    city = scanner.next();
                    manager.removeCity(city);
                    break;
                case "조회":
                    System.out.print("도시 이름을 입력하세요: ");
                    city = scanner.next();
                    manager.displayPopulation(city);
                    break;
                case "전체 조회":
                    manager.displayAll();
                    break;
                default:
                    System.out.println("알 수 없는 명령입니다.");
            }
        }
        scanner.close();
    }
}