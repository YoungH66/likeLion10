package com.example.day13.robot;

public class RobotMain {
    public static void main(String[] args) {
        Robot robot = new Robot();
        RobotPlayer command1 = new RobotPlayer("A", robot);
        RobotPlayer command2 = new RobotPlayer("B", robot);
        RobotPlayer command3 = new RobotPlayer("C", robot);

        command1.start();
        command2.start();
        command3.start();
    }
}
