package SecurityMath;

import java.math.BigInteger;

public class CheckPrime {
    public static boolean isPrime(BigInteger p){
        for(BigInteger i = BigInteger.valueOf(2); i.multiply(i).compareTo(p) <=0; i = i.add(BigInteger.ONE)){
            if(p.mod(i).equals(BigInteger.ZERO)){
                return false;
            }
        }
        return true;
    }
}
