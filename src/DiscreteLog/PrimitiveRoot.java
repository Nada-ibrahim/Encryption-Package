package DiscreteLog;

import NumberTheory.RelativePrime;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static java.lang.Math.pow;

public class PrimitiveRoot {
    RelativePrime R = new RelativePrime();
    int Fi_OF_n;
    public String reason;
    public boolean GetA(int g, int n) {
        Fi_OF_n = R.numOFrelative(n);
        List<Integer> RNum = R.SetRelative;
        List<Integer> Value_Of_A = new ArrayList<Integer>();
        int Z = 0;
        int a = (int) (pow(g, 0) % n);
        BigInteger gBig = BigInteger.valueOf(g);
        BigInteger nBig = BigInteger.valueOf(n);
        while (!Value_Of_A.contains(a)) {
            Value_Of_A.add(a);
            System.out.println("b=  "+RNum.get(Z));

            Z++;
            a = gBig.pow(Z).mod(nBig).intValue();
            //a = (int) (pow(g, Z) % n);
            System.out.println("A=  "+a);
        }
        System.out.print("=========================");

        Collections.sort(Value_Of_A);
        Collections.sort(RNum);

        if (Z != Fi_OF_n) {
            reason = "Is not root primtive becouse Z not equal Fi(n) ";
            return false;
        }
        if (Z == Fi_OF_n && RNum.size() != Value_Of_A.size()) {
            reason = "Is not root primtive becouse list of value not contain all value of primitive prime";
            return false;
        }
        if (Z == Fi_OF_n && RNum.size() == Value_Of_A.size()) {
            boolean flage=true ;
            for (int i = 0; i < RNum.size(); i++) {
                if(!Objects.equals(RNum.get(i), Value_Of_A.get(i)))
                {
                    flage =false;
                    break ;
                }

            }
            if (flage)
            {
                reason = "Is root primtive becouse list of value contain all value of primitive prime";
                return true;
            }
            else
            {
                reason = "Is not root primtive becouse list of value not contain all value of primitive prime";
                return false;
            }

        }


        return false;
    }

}
