package com.nixsolutions.ppp;

public class Pencil extends AbstractWriter {
    private static final double consumptionPerChar = 0.0095;
    @Override
    public void write(StringBuilder builder, char[] chars) {
        for (char c : chars) {
            builder.append(c);
            writingSubstance -= consumptionPerChar;
            countOfCharacters++;
            if (countOfCharacters % 20 == 0) {
                writingSubstance += 0.03;
            }
        }
    }
    @Override
    void erase(StringBuilder builder) {
        if (builder.length() > 0) {
            builder.setLength(builder.length() - 1);
        }
    }
    @Override
    public void showWritingMediumBalance() {
        System.out.println("Pencil written balance: " + String.format("%.4f", writingSubstance * 100));
    }
}
