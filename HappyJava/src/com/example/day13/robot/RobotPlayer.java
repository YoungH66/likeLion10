package com.example.day13.robot;

public class RobotPlayer extends Thread {
    private String playerName;
    private Robot robot;

    public RobotPlayer(String playerName, Robot robot) {
        this.playerName = playerName;
        this.robot = robot;
    }

    public void run() {
        if(playerName.equals("A")){
            robot.leftLegActive();
        }else if(playerName.equals("B")){
            robot.rightLegActive();
        }else{
            robot.scannerActive();
        }
    }
}
