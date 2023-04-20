package com.nixsolution.ppp.junit.robot;

import static com.nixsolution.ppp.junit.robot.Direction.*;

public class Robot {
    private int x;
    private int y;
    Direction direction;
    StringBuilder builder = new StringBuilder();
    public Robot(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }
    public void turnLeft() {
        if (direction == UP) {
            direction = LEFT;
        } else if (direction == DOWN) {
            direction = RIGHT;
        } else if (direction == LEFT) {
            direction = DOWN;
        } else if (direction == RIGHT) {
            direction = UP;
        }
    }
    public void turnRight() {
        if (direction == UP) {
            direction = RIGHT;
        } else if (direction == DOWN) {
            direction = LEFT;
        } else if (direction == LEFT) {
            direction = UP;
        } else if (direction == RIGHT) {
            direction = DOWN;
        }
    }

    public void stepForward() {
        switch (direction) {
            case UP: y++;
                break;
            case DOWN: y--;
                break;
            case LEFT: x--;
                break;
            case RIGHT: x++;
                break;
        }
        builder.append(x).append(" ").append(y).append("\n");
    }

    @Override
    public String toString() {
        return builder.toString();
    }
}



