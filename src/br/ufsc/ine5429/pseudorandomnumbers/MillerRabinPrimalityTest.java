package br.ufsc.ine5429.pseudorandomnumbers;

import java.math.BigInteger;
import java.util.Random;

public class MillerRabinPrimalityTest {
    public boolean isPrime(BigInteger n){
        for (int i = 0; i < 40; i++) {
            if(!testPrime(n)){
                return false;
            }
        }
        return true;
    }

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