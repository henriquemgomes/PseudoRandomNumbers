package br.ufsc.ine5429.pseudorandomnumbers;

import java.math.BigInteger;

public class LaggedFibonacciGenerator {
    public static BigInteger generatePseudoRandomNumber(int size, int firstIndex, int secondIndex) {
        int j = firstIndex;
        int k = secondIndex; 
        int iterations = size - 1;
        BigInteger seed = BigInteger.valueOf(System.nanoTime());
        int[] seedArray = new int[seed.toString().length()];
        String randomBitString = "1";
        for (int i = 0; i < seed.toString().length(); i++) {
          // - '0' para pegar a diferença do código ascii do caractere
          seedArray[i] = seed.toString().charAt(i) - '0';
        }
        for (int i = 0; i < iterations; i++) {
            int newPseudoRandom = (seedArray[j-1] + seedArray[k-1]) % 2;
            for (int l = 0; l < seedArray.length - 1; l++) {
                seedArray[l] = seedArray[l+1];
            }
            seedArray[seedArray.length - 1] = newPseudoRandom;
            randomBitString += newPseudoRandom;
        }

        BigInteger pseudoRandomNumber = new BigInteger(randomBitString, 2);
        return pseudoRandomNumber;
    }
}
