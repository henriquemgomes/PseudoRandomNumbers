package br.ufsc.ine5429.pseudorandomnumbers;

import java.math.BigInteger;

public class LinearCongruentialGenerator{
    /**
     * Retorna um numero pseudo aleatório utilizando o LinearCongruentialGenerator
     * O gerado estara dentro do limite de numeros representáveis pelo tamanho informado.
     * 
     * @param size tamanho do numero a ser gerado, em bits
     * @param multiplier valor que sera multiplicado a cada iteração
     * @param increment valor que sera incrementado a cada iteração
     * @param modulus valor para ser usado como mod
     * @param useBitRange flag usada para este algoritmo gerar numeros considerado apenas o limite superior, ou seja, 
     * numeros representados por 1 bit até o maior possibel representado pelo tamanho escolhido, 
     * usado para gerar seeds nos testes de primalidade
     */
    public static BigInteger generatePseudoRandomNumber(int size, int multiplier, int increment, int modulus, boolean useBitRange){
        int a = multiplier;
        int b = increment;
        int m = modulus;
        BigInteger seed = BigInteger.valueOf(System.nanoTime());
        int[] randomNumbers = new int[size];
        String randomBitString = "";
        if (useBitRange) {
            //trava o bit mais a esquerda em 1, garantindo que ele sera daquela faixa de valores representados pelo tamanho escolhido
            randomBitString = "1";
            //diminui o numero de bits gerados, já que um já foi definido
            randomNumbers = new int[size - 1];
        }

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