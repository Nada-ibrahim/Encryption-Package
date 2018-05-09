package RSAEncryption;

import SecurityMath.GCD;
import SecurityMath.ModInv;
import javafx.util.Pair;

import java.math.BigInteger;
import java.util.Random;
import java.util.function.BiFunction;

public class RSA {
    public BigInteger n;
    public BigInteger e;
    public BigInteger d;
    int k;
    public void generateKey(String p, String q){
        n = new BigInteger(p).multiply(new BigInteger(q));
        BigInteger pMinOne = new BigInteger(p).subtract(BigInteger.ONE);
        BigInteger qMinOne = new BigInteger(q).subtract(BigInteger.ONE);
        BigInteger FIn = pMinOne.multiply(qMinOne);
        e = calcE(FIn);
        d = ModInv.modInverse(e, FIn);

    }

    public String encrypt(String txt, BigInteger e, BigInteger n) {
        setK(n);
        StringBuilder m = new StringBuilder();
        for (int i = 0; i < txt.length(); ++i) {
            String ch = (Integer.toString(txt.charAt(i) - 97));
            if (ch.length() == 1) {
                m.append('0').append(ch);
            } else {
                m.append(ch);
            }
        }
        if (k < txt.length()) {
            return "Can't encrypt. p & q are too small";
        }else {

            BigInteger mInt = new BigInteger(m.toString());
            BigInteger cipher = mInt.modPow(e, n);

            return cipher.toString();
        }
    }

    public String decrypt(String cipher, BigInteger d, BigInteger n) {

        BigInteger c = new BigInteger(cipher);
        BigInteger mInt = c.modPow(d, n);
        String m = mInt.toString();
        StringBuilder txtStr = new StringBuilder();
        if (m.length() % 2 == 1) {
            m = "0" + m;
        }
        for (int i = 0; i < m.length() - 1; i = i + 2) {
            int x = Integer.parseInt(m.substring(i, i + 2));
            txtStr.append(Character.toString((char) (x + 97)));
        }
        return txtStr.toString();


    }


    private BigInteger calcE(BigInteger FIn){
        Random rand = new Random();
        BigInteger k;
        BigInteger n;
        do {
            n = new BigInteger(FIn.bitLength(), rand);
            n = n.mod(FIn.subtract(BigInteger.ONE));
            k = GCD.gcd(n, FIn);
        }while(!k.equals(BigInteger.ONE));
        return n;
    }

    private void setK(BigInteger n){
        k = 0;
        String mx = "26";
        while(new BigInteger(mx).compareTo(n) <= 0){
            k = k+1;
            mx = "26" + mx;
        }
    }
}
