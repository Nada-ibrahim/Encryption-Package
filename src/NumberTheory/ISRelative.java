package NumberTheory;

import java.math.BigInteger;
import java.util.Objects;

import static java.lang.Math.pow;

public class ISRelative {
    private RelativePrime R=new RelativePrime();
    public String isRelative(int a, int n)
    {
        int num=R.numOFrelative(n);
        BigInteger A_N=BigInteger.valueOf(a).pow(num);
        if (Objects.equals(A_N.mod(BigInteger.valueOf(n)), BigInteger.ONE))
            return "Relative Prime because " + a + "^" + num + " mod " + n + " = 1" ;
//        else if ((A_N*a) % n== a%n)
//            return false ;
        return "Not Relative Prime because " + a + "^" + num + " mod " + n + " = " +  A_N.mod(BigInteger.valueOf(n)) ;
    }
}
