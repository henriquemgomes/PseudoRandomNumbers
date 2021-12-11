package br.ufsc.ine5429.pseudorandomnumbers;

import java.math.BigInteger;

public class LinearCongruentialGenerator{
    public static BigInteger generatePseudoRandomNumber(int size, int multiplier, int increment, int modulus){
        int a = multiplier;
        int b = increment;
        int m = modulus;
        BigInteger seed = BigInteger.valueOf(System.nanoTime());
        int[] randomNumbers = new int[size - 1];
        String randomBitString = "1";

        randomNumbers[0] = seed.mod(BigInteger.valueOf(m)).intValue();

        for (int i = 1; i < randomNumbers.length; i++) {
            randomNumbers[i] = (a * randomNumbers[i-1] + b) % m;
        }

        for (int i : randomNumbers) {
            randomBitString += i % 2;
        }

        return new BigInteger(randomBitString, 2);
    }
}