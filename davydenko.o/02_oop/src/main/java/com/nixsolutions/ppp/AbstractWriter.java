package com.nixsolutions.ppp;

public abstract class AbstractWriter {
    protected int countOfCharacters;

    protected double writingSubstance = 1.0;
    public abstract void write(StringBuilder builder, char[] chars);
    abstract void erase(StringBuilder builder);
    public abstract void showWritingMediumBalance();

}
