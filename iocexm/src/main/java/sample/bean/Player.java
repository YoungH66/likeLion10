package sample.bean;

public class Player {
    private String playerName;
    private Dice dice;  // 실행될때 주사위를 인젝션 받아야 함.

    // DI 할 수 있는 방법은?
    // 1. 생성자를 통한 주입
    // 2. 설정자를 통한 주입(setter)
    // 3. 필드를 통한 주입

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Dice getDice() {
        return dice;
    }

    public void setDice(Dice dice) {
        this.dice = dice;
    }

    public void play(){
        System.out.println(playerName + " is roll the dice..");
        System.out.println("face is " + dice.getNumber());
    }
}
