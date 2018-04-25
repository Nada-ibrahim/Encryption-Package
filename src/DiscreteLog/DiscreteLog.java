package DiscreteLog;

import java.math.BigInteger;
import java.util.List;

public class DiscreteLog {
    public int[] bList;
    public int[] iList;
    public long[] timeList;
    public DiscreteLog(int m){
        iList = new int[m];
        bList = new int[m];
        timeList = new long[m];
        for(int x = 0; x < m; ++x){
            bList[x] = x+1;
        }
    }
    public void getDiscreteLog(int a, int p){
        int i = 1;
        long start = System.nanoTime();
        BigInteger aBig = BigInteger.valueOf(a);
        BigInteger pBig = BigInteger.valueOf(p);
        int sz = 0;
        int m = bList.length;
        while(sz < m){
            BigInteger b = aBig.pow(i).mod(pBig);
            int bInt = (int)b.doubleValue();
            if (bInt <= m && bInt > 0){
                if(iList[bInt - 1] == 0) {
                    timeList[bInt - 1] = System.nanoTime() - start;
                    iList[bInt - 1] = i;
                }
                sz++;
            }
            if(bInt == 0){
                sz++;
            }
            ++i;
        }
        for(int  x = 0; x < bList.length; ++x){
            System.out.print(bList[x] + " ");
        }
        System.out.println();
        for(int  x = 0; x < bList.length; ++x){
            System.out.print(iList[x] + " ");
        }
        System.out.println();
        for(int  x = 0; x < bList.length; ++x){
            System.out.print(timeList[x] + " ");
        }
        System.out.println();


    }
}
