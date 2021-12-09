package br.ufsc.ine5429.pseudorandomnumbers;

import java.math.BigDecimal;
import java.math.BigInteger;

public class LaggedFibonacciGenerator {
    public static BigInteger generatePseudoRandomNumber(int size, int firstIndex, int secondIndex) {
        int j = firstIndex;
        int k = secondIndex; 
        int iterations = size - 2;
        int[] randomNumberDigits = new int[iterations];
        BigInteger seed = BigInteger.valueOf(System.nanoTime());
        //BigInteger seed = new BigInteger("3643825324300600");
        int[] seedArray = new int[seed.toString().length()];
        for (int i = 0; i < seed.toString().length(); i++) {
          // - '0' para pegar a diferença do código do caractere
          seedArray[i] = seed.toString().charAt(i) - '0';
        }
        for (int i = 0; i < iterations; i++) {
            //Utils.printArray(seedArray);
            //System.out.print(" --algarismo-calculado--> ");
            int newPseudoRandom = (seedArray[j-1] + seedArray[k-1]) % 2;
            //System.out.println(newPseudoRandom);
            for (int l = 0; l < seedArray.length - 1; l++) {
                seedArray[l] = seedArray[l+1];
            }
            seedArray[seedArray.length - 1] = newPseudoRandom;
            randomNumberDigits[i] = newPseudoRandom;
        }
        BigInteger pseudoRandomNumber = new BigInteger("1"+Utils.transformArrayIntoString(randomNumberDigits), 2);
        return pseudoRandomNumber;
    }
}
