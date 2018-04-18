package NumberTheory;


import java.math.BigInteger;
import java.util.HashSet;
import java.util.Objects;
import java.util.Random;
import java.util.Set;

public class TestPrimality {
    //false --> composite
    //true --> prime
    private Set<BigInteger> generatedRandNos = new HashSet<>();
    private BigInteger two = new BigInteger("2");
    private BigInteger zero = new BigInteger("0");
    private BigInteger one = new BigInteger("1");
    private BigInteger three = new BigInteger("3");
    private BigInteger randsize = new BigInteger("0");
    public String test(BigInteger number) {

        if (Objects.equals(number.mod(two), zero)) {
            return "Not prime because number is not odd";
        }
        int k = 0;
        BigInteger q = number.subtract(one);
        while (Objects.equals(q.mod(two), zero)) {
            q = q.divide(two);
            k++;
        }
//        BigInteger a = new BigInteger("1");
        A:
        while (randsize.compareTo(number.subtract(three)) < 0) {
           BigInteger a = generateRandom(number.subtract(one));
//            a = a.add(one);
            BigInteger g = a.modPow(q, number);
            if (g.equals(one)) {
                continue;
            }
            for (int j = 0; j < k; j++) {
                BigInteger b = new BigInteger(Long.toString((long)Math.pow(2, j))).multiply(q);
                BigInteger x = a.modPow(b, number);
//                long y = (long)Math.pow(a, Math.pow(2, j) * q);
//                long x = Math.floorMod(y , number);
                if (x.equals(number.subtract(one))) {
                    continue A;
                }
            }
            return "Not prime because the theory fails at a = " + a;
        }
        return "Prime because the theory holds for all 1 < a < " + (number.subtract(one));
    }

    private BigInteger generateRandom(BigInteger number) {
        Random rand = new Random();
        BigInteger n = new BigInteger(number.bitLength(), rand);
        n = n.mod(number);
//        long n = ThreadLocalRandom.current().nextLong(2,number-1);
        while (generatedRandNos.contains(n) || n.equals(one) || n.equals(zero)) {
            n = new BigInteger(number.bitLength(), rand).mod(number);
        }
        generatedRandNos.add(n);
        randsize = randsize.add(one);
        return n;
    }
}
