package br.ufsc.ine5429.pseudorandomnumbers;

import java.math.BigInteger;

public class MillerRabinPrimalityTest {
    /**
     * Informa se o número é primo ou não 
     * 
     * @param n número a ser testado
     * 
     * @return true - o número é primo ou false - o número é composto
     * 
     */
    public boolean isPrime(BigInteger n){
        //executa 40 vezes com diferentes 'a' para garantir maior chance do numero ser primo
        for (int i = 0; i < 40; i++) {
            if(!testPrime(n)){
                return false;
            }
        }
        return true;
    }

    /**
     * execução unica do teste, indica que o numero tem chance de ser primo
     * 
     * @param n número a ser testado
     * 
     * @return true - o número tem chance de ser primo ou false - o número é composto
     * 
     */
    private boolean testPrime(BigInteger n){
        BigInteger nMinOne = n.subtract(BigInteger.ONE);
        BigInteger base = nMinOne;
        BigInteger a = BigInteger.ZERO;

        do {
           a = LinearCongruentialGenerator.generatePseudoRandomNumber(nMinOne.bitLength(), 5, 2, 257, false);
        } while (a.compareTo(nMinOne) >= 0 || a.compareTo(BigInteger.ONE) <= 0);

        int k = 0;
        while (base.mod(BigInteger.TWO).equals(BigInteger.ZERO)) {
            base = base.shiftRight(1);
            k++;
        }

        BigInteger currentVal = a.modPow(base,n);

        if(currentVal.equals(BigInteger.ONE)){
            return true;
        }

        for (int i = 0; i < k; i++) {
            if(currentVal.equals(n.subtract(BigInteger.ONE))){
                return true;
            }else{
                currentVal = currentVal.modPow(BigInteger.TWO, n);
            }
        }
        
        return false;
    }
}