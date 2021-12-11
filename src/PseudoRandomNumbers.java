import br.ufsc.ine5429.pseudorandomnumbers.LaggedFibonacciGenerator;
import br.ufsc.ine5429.pseudorandomnumbers.LinearCongruentialGenerator;
// System.out.println(seed);
// seed ^= (seed << 21);
// seed ^= (seed >>> 35);
// seed ^= (seed << 4);

// System.out.println(seed);

public class PseudoRandomNumbers {
    public static void main(String[] args) {
        System.out.println(LaggedFibonacciGenerator.generatePseudoRandomNumber(1024, 3, 7));
        System.out.println();
        System.out.println(LinearCongruentialGenerator.generatePseudoRandomNumber(1024, 5, 2, 257));
    }
}