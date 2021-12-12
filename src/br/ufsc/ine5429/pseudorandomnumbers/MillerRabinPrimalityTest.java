package br.ufsc.ine5429.pseudorandomnumbers;

import java.math.BigInteger;

public class MillerRabinPrimalityTest {

    public static boolean isPrime(BigInteger n){
        System.out.println("testando: "+ n);
        if(n.mod(new BigInteger("2")).equals(new BigInteger("0"))){
            return false;
        }

        int k = 1;
        BigInteger m = null;
        BigInteger nMinOne = n.subtract(new BigInteger("1"));
        BigInteger a = null;
        BigInteger b = null;
        BigInteger[] lastDivided = new BigInteger[2];

        while (true) {
            lastDivided = nMinOne.divideAndRemainder(new BigInteger("2").pow(k));
            System.out.println("prob: "+ lastDivided[0]+", "+ lastDivided[1]);
            if (lastDivided[1].equals(new BigInteger("0"))) {
                m = lastDivided[0];
                k++;
            }else if(k == 1 && !lastDivided[1].equals(new BigInteger("0"))){
               // System.out.println("caiu no if matador");
                return false;
            }else {
                k = k-1;
                break;
            }
        }
       // System.out.println();
        
        while (true) {
            a = LinearCongruentialGenerator.generatePseudoRandomNumber(nMinOne.bitLength() - 1, 5, 2, 257, true);
            if (a.compareTo(new BigInteger("1")) == 1 && a.compareTo(nMinOne) == -1) {
                break;
            }
        }

        int i = 1;
        System.out.println("a="+a+" m="+m+" n="+n);
        b = a.modPow(m, n);
        System.out.println("b: "+ b);
        BigInteger lastB = null;
        int repetitions = 0;
        while (true) {

            if(b.equals(new BigInteger("1")) || repetitions>=10){
                return false;
            }else if(b.equals(nMinOne)){
                return true;
            }
           // System.out.println(b);
            i++;
            lastB = b;
            b = b.pow(i).mod(n);
            if(lastB.equals(b)){
               // System.out.println(b);
                repetitions++;
            }else{
                repetitions = 0;
            }
        }        
    }
}