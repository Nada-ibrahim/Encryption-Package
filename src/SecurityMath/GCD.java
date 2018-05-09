package SecurityMath;

import java.math.BigInteger;

public class GCD {
    public static BigInteger gcd(BigInteger p, BigInteger q) {
        if (q.equals(BigInteger.ZERO)) {
            return p;
        }
        return gcd(q, p.mod(q));
    }
}
