import java.math.BigInteger;

import br.ufsc.ine5429.pseudorandomnumbers.FermatPrimalityTest;
import br.ufsc.ine5429.pseudorandomnumbers.LaggedFibonacciGenerator;
import br.ufsc.ine5429.pseudorandomnumbers.LinearCongruentialGenerator;
import br.ufsc.ine5429.pseudorandomnumbers.MillerRabinPrimalityTest;

public class PseudoRandomNumbers {
    
    /*
    *Método principal, executa tudo que foi solicitado.
    */
    public static void main(String[] args) {
        
        int[] tamanhos = { 40, 56, 80, 128, 168, 224, 256, 512, 1024, 2048 , 4096 };

        // Gera um numero pseudo aleatorio para cada tamanho utilizando o Lagged Fibonacci Generator
        for (int tamanho : tamanhos) {
            long start = System.currentTimeMillis();
            System.out.println("Gerando numero pseudo aleatorio de "+tamanho+" bits utilizando o Lagged Fibonacci Generator");
            BigInteger num = LaggedFibonacciGenerator.generatePseudoRandomNumber(tamanho, 3, 7, false);
            System.out.println("Numero gerado em "+ (System.currentTimeMillis() - start)+"ms");
            System.out.println("Numero gerado: "+ num+", bit length: "+ num.toString(2).length());
            System.out.println("==================================================================================================");
        }

        // Gera um numero pseudo aleatorio para cada tamanho utilizando o Linear Congruential Generator
        for (int tamanho : tamanhos) {
            long start = System.currentTimeMillis();
            System.out.println("Gerando numero pseudo aleatorio de "+tamanho+" bits utilizando o Linear Congruential Generator");
            BigInteger num = LinearCongruentialGenerator.generatePseudoRandomNumber(tamanho, 5, 2, 257, true);
            System.out.println("Numero gerado em "+ (System.currentTimeMillis() - start)+"ms");
            System.out.println("Numero gerado: "+ num+", bit length: "+ num.toString(2).length());
            System.out.println("==================================================================================================");
        }

        MillerRabinPrimalityTest millerRabin = new MillerRabinPrimalityTest();
        FermatPrimalityTest fermat = new FermatPrimalityTest();

        //Executa até encontrar um primo para cada tamanho utilizando o teste Miller-Rabin 
        for (int tamanho : tamanhos) {
            long start = System.currentTimeMillis();
            System.out.println("Gerando numero primo de "+tamanho+" bits utilizando o Miller-Rabin");
            BigInteger num = null;
            int reps = 0;
            while (true) {
                num = LaggedFibonacciGenerator.generatePseudoRandomNumber(tamanho, 3, 7, true);
                if(millerRabin.isPrime(num)){
                    System.out.println('+');
                    break;
                }else{
                    reps++;
                    if (reps == 100) {
                        System.out.print('.');
                        reps = 0;
                    }
                }
            }
            System.out.println("Primo gerado em "+ (System.currentTimeMillis() - start)+"ms");
            System.out.println("Primo gerado: "+ num+", bit length: "+ num.toString(2).length());
            System.out.println("==================================================================================================");
        }

        //Executa até encontrar um primo para cada tamanho utilizando o teste Fermat 
        for (int tamanho : tamanhos) {
            long start = System.currentTimeMillis();
            System.out.println("Gerando primo de "+tamanho+" bits utilizando Fermat");
            BigInteger num = null;
            while (true) {
                num = LaggedFibonacciGenerator.generatePseudoRandomNumber(tamanho, 3, 7, true);
                if(fermat.isPrime(num)){
                    System.out.println('+');
                    break;
                }else{
                    //System.out.print('.');
                }
            }
            System.out.println("Primo gerado em "+ (System.currentTimeMillis() - start)+"ms");
            System.out.println("Primo gerado: "+ num+", bit length: "+ num.toString(2).length());
            System.out.println("==================================================================================================");
        }          
    }
}