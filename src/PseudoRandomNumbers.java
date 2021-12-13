import java.math.BigInteger;

import br.ufsc.ine5429.pseudorandomnumbers.FermatPrimalityTest;
import br.ufsc.ine5429.pseudorandomnumbers.LaggedFibonacciGenerator;
import br.ufsc.ine5429.pseudorandomnumbers.LinearCongruentialGenerator;
// System.out.println(seed);
// seed ^= (seed << 21);
// seed ^= (seed >>> 35);
// seed ^= (seed << 4);
import br.ufsc.ine5429.pseudorandomnumbers.MillerRabinPrimalityTest;

// System.out.println(seed);

public class PseudoRandomNumbers {
    
    public static void main(String[] args) {
    MillerRabinPrimalityTest millerRabin = new MillerRabinPrimalityTest();
    FermatPrimalityTest fermat = new FermatPrimalityTest();
       //System.out.println(millerRabin.isPrime(new BigInteger("61")));
       //System.out.println(millerRabin.isPrime(LaggedFibonacciGenerator.generatePseudoRandomNumber(4096, 3, 7)));
        
        //Miller-Rabin
        // int numSize = 40;
        // System.out.println("gerando inteiro primo de "+numSize+" bits");
        // long start = System.currentTimeMillis();
        // BigInteger num = BigInteger.ZERO;
        // while (true) {
        //     num = LaggedFibonacciGenerator.generatePseudoRandomNumber(numSize, 3, 7);
        //     if(millerRabin.isPrime(num)){
        //         System.out.println('+');
        //         System.out.println("Primo encontrado: "+ num);
        //         break;
        //     }else{
        //         System.out.print('.');
        //     }
        // }
        // System.out.println("Tempo para gerar o primo "+ (System.currentTimeMillis() - start) +"ms");
               
        //Fermat
        int numSize = 1024;
        System.out.println("gerando inteiro primo de "+numSize+" bits");
        long start = System.currentTimeMillis();
        BigInteger num = BigInteger.ZERO;
        while (true) {
            num = LaggedFibonacciGenerator.generatePseudoRandomNumber(numSize, 3, 7);
            if(fermat.isPrime(num)){
                System.out.println('+');
                System.out.println("Primo encontrado: "+ num);
                break;
            }else{
                System.out.print('.');
            }
        }
        System.out.println("Tempo para gerar o primo "+ (System.currentTimeMillis() - start) +"ms");            
    }
}