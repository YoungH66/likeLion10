package ch02;

public class Dog {
    String breed;
    int age;
    String color;

    // 생성자
    // 접근제한자 클래스명(매개변수들 - 초기화할 변수들 ...){}
    Dog(String breed, String color) {
        this.breed = breed;
        this.color = color;
    }
    Dog(){}
    void bark(){
        System.out.println("멍멍");
    }

    void displayInfo() {
        System.out.println("품종 : " + breed + "\n나이 : " + age + "\n털 색 : " + color);
    }

    static void classMethod(){
        System.out.println("클래스 메소드는 인스턴스화 하지 않아도 사용할 수 있다.");
    }

    void instanceMethod(){
        System.out.println("인스턴스 메소드는 반드시 인스턴스화 한 후에 사용할 수 있다.");
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public static void main(String[] args) {
        Dog.classMethod(); // 클래스로 바로 접근해서 사용 가능

        Dog dog = new Dog();
        dog.instanceMethod(); // 인트턴스화 해야 접근 가능
    }
}
