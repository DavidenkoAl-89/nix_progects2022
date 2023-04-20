package com.nixsolutions.ppp;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        generateRandomWriters();
    }
    private static void generateRandomWriters() {
        StringBuilder builder = new StringBuilder();
        AbstractWriter[] array = new AbstractWriter[10];
        AbstractWriter aw = null;
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int randomNumber = random.nextInt(3);
            switch (randomNumber) {
                case 0:
                    aw = new Pen();
                    for (int j = 0; j <= 10; j++) {
                        aw.write(builder, generateRandomChar());
                    }
                    break;
                case 1:
                    aw = new Pencil();
                    for (int j = 0; j <= 10; j++) {
                        aw.write(builder, generateRandomChar());
                        aw.erase(builder);
                    }
                    break;
                case 2:
                    aw = new Marker();
                    for (int j = 0; j <= 10; j++) {
                        aw.write(builder, generateRandomChar());
                    }
                    break;
            }
            array[i] = aw;
        }
        sortByWritingSubstance(array);
    }
    private static char[] generateRandomChar() {
        Random random = new Random();
        int length = random.nextInt(3) + 3;
        char[] chars = new char[length];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) (random.nextInt(26) + 'a');
        }
        return chars;
    }
    private static AbstractWriter[] sortByWritingSubstance(AbstractWriter[] aw) {
        AbstractWriter temp = null;
        for (int i = 0; i < aw.length; i++) {
            for (int j = 0; j < aw.length - 1 - i; j++) {
                if (aw[j].writingSubstance < aw[j + 1].writingSubstance) {
                    temp = aw[j];
                    aw[j] = aw[j + 1];
                    aw[j + 1] = temp;
                }
            }
            if (temp != null) {
                temp.showWritingMediumBalance();
            }
        }
        return aw;
    }
}

