package com.nixsolutions.ppp;

public class Marker extends AbstractWriter {
    private static final double consumptionPerChar = 0.01;
    private static final double consumptionPerCharBetween21And40 = 0.0109;
    private static final double consumptionPerCharAfter40 = 0.0121;

    @Override
    public void write(StringBuilder builder, char[] chars) {
        for (char c : chars) {
            builder.append(c);
            countOfCharacters++;
            if (countOfCharacters <= 20) {
                writingSubstance -= consumptionPerChar;
            }
            if (countOfCharacters >= 21 && countOfCharacters <= 40) {
                writingSubstance -= consumptionPerCharBetween21And40;
            }
            if (countOfCharacters >= 41) {
                writingSubstance -= consumptionPerCharAfter40;
            }
        }
    }
    @Override
    void erase(StringBuilder builder) {
        //Marker cannot erase.
    }
    @Override
    public void showWritingMediumBalance() {
        System.out.println("Marker written balance: " + String.format("%.4f", writingSubstance * 100));
    }
}
