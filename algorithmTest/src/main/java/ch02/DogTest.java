package ch02;

public class DogTest {
    public static void main(String[] args) {
        /*Dog dog = new Dog();    // 인스턴스화
        dog.setAge(3);
        dog.setBreed("진돗개");
        dog.setColor("흰색");
        dog.displayInfo();
        System.out.println();

        dog.age = 5;
        dog.breed = "테리어";
        dog.color = "검정";
        dog.bark();
        dog.displayInfo();*/
        Dog dog = new Dog("진돗개", "흰색");
        dog.bark();
        dog.displayInfo();
    }
}
