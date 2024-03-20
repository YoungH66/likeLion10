package ch02;

public class Mic {
    String manufacurer;
    String type;
    boolean pwr;

    Mic(String manufacurer, String type, boolean pwr){
        this.manufacurer = manufacurer;
        this.type = type;
        this.pwr = pwr;
    }

    Mic(String manufacurer, String type){
        this.manufacurer = manufacurer;
        this.type = type;
    }

    Mic(){}

    void displayInfo(){
        System.out.println("제조사 : " + manufacurer);
        System.out.println("제품 형태 : " + type);
        if(pwr)
            System.out.println("전원 켜짐");
        else
            System.out.println("전원 꺼짐");
    }
}


