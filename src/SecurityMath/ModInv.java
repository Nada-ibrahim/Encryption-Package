package SecurityMath;

import java.math.BigInteger;

public class ModInv {
    public static BigInteger modInverse(BigInteger a, BigInteger m)
    {
        BigInteger m0 = m;
        BigInteger y = BigInteger.ZERO, x = BigInteger.ONE;

        if (m.equals(BigInteger.ONE))
            return BigInteger.ZERO;

        while (a.compareTo(BigInteger.ONE) > 0)
        {
            // q is quotient
            BigInteger q = a.divide(m);

            BigInteger t = m;

            // m is remainder now, process
            // same as Euclid's algo
            m = a.mod(m);
            a = t;
            t = y;

            // Update x and y
            BigInteger qMulty =  q.multiply(y);
            y = x.subtract(qMulty);
            x = t;
        }

        // Make x positive
        if (x.compareTo(BigInteger.ZERO) < 0)
            x = x.add(m0);

        return x;
    }

}
