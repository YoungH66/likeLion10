package sample.bean;

public class Dice {
    private int face;

    public Dice() {
        System.out.println("roll the dice");
    }

    public Dice(int face) {
        this.face = face;
        System.out.println("roll the dice.. face = " + face);
    }

    public int getNumber(){
        return (int)(Math.random()*face+1);
    }
}
