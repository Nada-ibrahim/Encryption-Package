package NumberTheory;

import static java.lang.Math.pow;

public class ISRelative {
    RelativePrime R=new RelativePrime();
    boolean isRelative(int a, int n)
    {
        int num=R.numOFrelative(n);
        int A_N=(int) pow(a,num);
        if (A_N % n == 1%n)
            return true ;
        else if ((A_N*a) % n== a%n)
            return false ;
        return false ;
    }
}
