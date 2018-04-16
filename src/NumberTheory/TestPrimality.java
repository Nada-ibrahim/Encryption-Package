package NumberTheory;

import sun.rmi.runtime.Log;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Objects;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class TestPrimality {
    //false --> composite
    //true --> prime
    private Set<BigInteger> generatedRandNos = new HashSet<>();
    BigInteger two = new BigInteger("2");
    BigInteger zero = new BigInteger("0");
    BigInteger one = new BigInteger("1");
    BigInteger three = new BigInteger("3");
    BigInteger randsize = new BigInteger("0");
    public boolean test(BigInteger number) {

        if (Objects.equals(number.mod(two), zero)) {
            return false;
        }
        int k = 0;
        BigInteger q = number.subtract(one);
        while (Objects.equals(q.mod(two), zero)) {
            q = q.divide(two);
            k++;
        }
        BigInteger a = new BigInteger("1");
        A:
        while (a.compareTo(number.subtract(one)) < 0) {
          // BigInteger a = generateRandom(number.subtract(one));
           a = a.add(one);
           if(a.compareTo(number.divide(two)) > 0){
               int c = 0;
           }
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
            return false;
        }
        return true;
    }

    private BigInteger generateRandom(BigInteger number) {
        Random rand = new Random();
        BigInteger n = new BigInteger(number.bitCount()+2, rand);
        n = n.mod(number);
//        long n = ThreadLocalRandom.current().nextLong(2,number-1);
        while (generatedRandNos.contains(n) || n.equals(one) || n.equals(zero)) {
            n = new BigInteger(number.bitCount()+2, rand).mod(number);
        }
        generatedRandNos.add(n);
        randsize = randsize.add(one);
        return n;
    }
}
