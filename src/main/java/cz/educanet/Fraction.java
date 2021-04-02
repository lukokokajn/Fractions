package cz.educanet;

public class Fraction {

    private final int numerator;
    private final int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }
    public Fraction plus(Fraction other) {

        int cislo = MathUtils.findLowestCommonMultiple(denominator, other.denominator);

        int a = cislo / other.denominator;
        int b = cislo / denominator;
        int c = numerator * a;
        int d = other.numerator * b;

        int fr = c + d;

        return new Fraction(fr, cislo);
    }

    public Fraction minus(Fraction other) {

        int cislo = MathUtils.findLowestCommonMultiple(denominator, other.denominator);

        int a = cislo / other.denominator;
        int b = cislo / denominator;
        int c = numerator * a;
        int d = other.numerator * b;

        int fr = c - d;

        return new Fraction(fr, cislo);
    }

    public Fraction times(Fraction other) {

        int timesDen = denominator * other.denominator;
        int timesNum = numerator * other.numerator;

        return new Fraction(timesNum, timesDen);
    }

    public Fraction dividedBy(Fraction other) {

        int divideDen = denominator * other.numerator;
        int divideNum = numerator * other.denominator;

        return new Fraction(divideNum, divideDen);
    }

    public Fraction getReciprocal() {
        return new Fraction(getDenominator(), getNumerator());
    }

    public Fraction simplify() {
        int fr2 = MathUtils.findGreatestCommonDenominator(numerator, denominator);

        int a = numerator / fr2;
        int b = denominator / fr2;

        return new Fraction(a, b);
    }

    public float toFloat() {
        float prevod = 0;
        if (denominator != 0) {
            prevod = (float) numerator / (float) denominator;
        } else {
            System.out.println("0 nelze");
        }
        return prevod;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }
}