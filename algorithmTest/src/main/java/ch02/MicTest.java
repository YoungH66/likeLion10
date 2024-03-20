package ch02;

public class MicTest {
    public static void main(String[] args) {
        /*Mic mic = new Mic();
        mic.manufacurer = "PILLLAR";
        mic.type = "스탠드 형";
        mic.pwr = true;
        mic.displayInfo();*/

        Mic mic = new Mic("PILLAR", "스탠드 형", true);
        mic.displayInfo();

        Mic mic2 = new Mic();
        mic2.displayInfo();
    }
}
