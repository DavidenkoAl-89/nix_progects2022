package com.nixsolution.ppp.junit.robot;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;

public class Program {
    Robot robot;
    Path path;
    public Program(Robot robot) {
        this.robot = robot;
    }
    public Program(Robot robot, Path path) {
        this.robot = robot;
        this.path = path;
    }
    public void writeRouteToFile(String commandFoRobot) {
        try (PrintWriter writer = new PrintWriter((new FileWriter(String.valueOf(path), true)))) {
            writer.println(robotGo(commandFoRobot));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private Robot robotGo(String command) {
        char[] chars = command.toCharArray();
        for (Character c : chars) {
            switch (c) {
                case 'l': robot.turnLeft();
                    break;
                case 'r': robot.turnRight();
                    break;
                case 'f': robot.stepForward();
                    break;
                default: {
                    throw new IllegalArgumentException("Unknown command " + command);
                }
            }
        }
        return robot;
    }
}