package br.ufsc.ine5429.pseudorandomnumbers;

import java.math.BigInteger;


public class LaggedFibonacciGenerator {
    /**
     * Retorna um numero pseudo aleatório utilizando o LaggedFibonacciGenerator
     * O gerado estara dentro do limite de numeros representáveis pelo tamanho informado.
     * 
     * @param size tamanho do numero a ser gerado, em bits
     * @param firstIndex primeiro index escolhido para gerar o algoritmo, deve ser > 0
     * @param secondIndex segundo index escolhido para gerar o algoritmo, deve ser > firstIndex
     * @param oddOnly flag usada para este algoritmo gerar apenas numeros primos, usado nos teste de primalidade para nunca gerar numeros pares, que não podem ser primos
     */
    public static BigInteger generatePseudoRandomNumber(int size, int firstIndex, int secondIndex, boolean oddOnly) {
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
        if(oddOnly){
            //trava o bit mais a direita no valor 1, garantindo gerar apenas numeros ímpares
            randomBitString = randomBitString.substring(0, size-1)+'1';
        }
        BigInteger pseudoRandomNumber = new BigInteger(randomBitString, 2);
        return pseudoRandomNumber;
    }
}
