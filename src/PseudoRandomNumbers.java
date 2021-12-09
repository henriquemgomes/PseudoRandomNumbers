import java.math.BigInteger;
import java.util.ArrayList;

import br.ufsc.ine5429.pseudorandomnumbers.Utils;
import br.ufsc.ine5429.pseudorandomnumbers.LaggedFibonacciGenerator;
// System.out.println(seed);
// seed ^= (seed << 21);
// seed ^= (seed >>> 35);
// seed ^= (seed << 4);

// System.out.println(seed);

public class PseudoRandomNumbers {
    public static void main(String[] args) {
        System.out.println(LaggedFibonacciGenerator.generatePseudoRandomNumber(24, 3, 7));
    }
}