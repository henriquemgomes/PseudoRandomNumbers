package br.ufsc.ine5429.pseudorandomnumbers;

import java.math.BigInteger;

/**
 * Informa se o número é primo ou não 
 * 
 * @param n número a ser testado
 * 
 * @return true - o número é primo ou false - o número é composto
 * 
 */
public class FermatPrimalityTest {
    public boolean isPrime(BigInteger n){
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
        BigInteger a = BigInteger.ZERO;

        do {
           a = LinearCongruentialGenerator.generatePseudoRandomNumber(nMinOne.bitLength(), 5, 2, 257, false);
        } while (a.compareTo(n.subtract(BigInteger.ONE)) >= 0 || a.compareTo(BigInteger.ONE) <= 0);

        //verifica se a e n tem um mdc maior q 1
        if(!a.gcd(n).equals(BigInteger.ONE)){
            return false;
        }

        if(!a.modPow(n.subtract(BigInteger.ONE), n).equals(BigInteger.ONE)){
            return false;
        }

        return true;
    }
}
