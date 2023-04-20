package com.nixsolutions.ppp;

public class Pen extends AbstractWriter {
    private static final double consumptionPerChar = 0.015;
    @Override
    public void write(StringBuilder builder, char[] chars) {
        for (char c : chars) {
            builder.append(c);
            writingSubstance -= consumptionPerChar;
        }
    }
    @Override
    public void erase(StringBuilder builder) {
        //Pen cannot erase.
    }
    @Override
    public void showWritingMediumBalance() {
        System.out.println("Pen written balance: " + String.format("%.4f", writingSubstance * 100));
    }
}
