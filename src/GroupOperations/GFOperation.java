/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GroupOperations;

/**
 *
 * @author Yassmin
 */
import java.util.Objects;

public class GFOperation {
    private int a;
    private int b;
    private int p;

    public GFOperation(String eq1, String eq2, String redEq){
        a = Integer.parseInt(eq1, 2);
        b = Integer.parseInt(eq2, 2);
        p = Integer.parseInt(redEq,2);
    }
    GFOperation(int n1, int n2, int n3){
        a = n1;
        b = n2;
        p = n3;
    }

    public String add(){
        Integer c = (a^b) % p;
        return Integer.toBinaryString(c);
    }
    public String multiply(){
        String bBin = Integer.toBinaryString(b);
        int asum;
        int c = 0;
        for(int i = bBin.length()-1; i >= 0; --i){
            if(bBin.charAt(i) == '1'){
                asum = a << (bBin.length() - i - 1);
                c = c^asum;
            }
        }
        GFOperation gf = new GFOperation(c,p,0);
        return gf.divide();
    }
    public String divide(){
        int acpy = a;
        int bcpy = b;
        String aBin = Integer.toBinaryString(a);
        String bBin = Integer.toBinaryString(b);
        int n = aBin.length() - bBin.length();
        while(n >= 0){
            int c = bcpy << n;
            acpy = acpy ^ c;
            aBin = Integer.toBinaryString(acpy);
            bBin = Integer.toBinaryString(bcpy);
            n = aBin.length() - bBin.length();
        }
        return Integer.toBinaryString(acpy);
    }

     public String inverse(){
        int result = 0;
        for(int i = 1; i < 255; ++i){
            GFOperation gf = new GFOperation(a, i, 283);
            String output = gf.multiply();
            if(Objects.equals(output, "1")){
                result = i;
                break;
            }
        }
        return Integer.toBinaryString(result);

    }
}
