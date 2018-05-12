package ClassicalEncryption;

import GroupOperations.OnTheFly;
import SecurityMath.Matrix;
import SecurityMath.ModInv;

import java.math.BigInteger;

public class Hill {
    private Matrix key;
    int sz;
    public Hill(String k, int sz){
        String kCaps = k.toUpperCase();
        int[][] arr = new int[sz][sz];
        for (int i =0; i < sz; ++i){
            for(int j = 0; j < sz; ++j){
                arr[i][j] = kCaps.charAt(sz*i + j) - 65;
            }
        }
        this.sz = sz;
        key = new Matrix(arr);
    }

    public String encrypt(String plain){
        int[][] subPlain = new int[sz][1];
        StringBuilder cipherText = new StringBuilder();
        String plainCaps = PlayFair.removeSpaces(plain.toUpperCase());
        for(int i = 0; i < plainCaps.length(); i=i+sz){
            for(int j = i; j < i + sz; ++j ){
                if(j <= plainCaps.length() - 1){
                    subPlain[j - i][0] = (int)plainCaps.charAt(j) - 65;
                }else{
                    subPlain[j - i][0] = (int)'X' - 65;
                }
            }
            Matrix m1 = new Matrix(subPlain);
            Matrix cipherMatrix = Matrix.dotProduct(key,m1);
            for(int j = 0; j < sz; ++j ) {
                cipherText.append((char) (cipherMatrix.getElement(j, 0) + 65));
            }
        }
        return cipherText.toString();
    }

    public String decrypt(String cipher){
        Matrix keyInv = generateInvKey();
        String cipherCaps = PlayFair.removeSpaces(cipher.toUpperCase());
        int[][] subPlain = new int[sz][1];
        StringBuilder plainText = new StringBuilder();
        for(int i = 0; i < cipherCaps.length(); i=i+sz){
            for(int j = i; j < i + sz; ++j ){
                if(j <= cipherCaps.length() - 1){
                    subPlain[j - i][0] = (int)cipherCaps.charAt(j) - 65;
                }else{
                    subPlain[j - i][0] = (int)'X' - 65;
                }
            }
            Matrix m1 = new Matrix(subPlain);
            Matrix plainMatrix = Matrix.dotProduct(keyInv,m1);
            for(int j = 0; j < sz; ++j ) {
                plainText.append((char) (plainMatrix.getElement(j, 0) + 65));
            }
        }
        return plainText.toString();
    }

    private Matrix generateInvKey(){
        int det = Math.floorMod(Matrix.det(key),26);
        OnTheFly of = new OnTheFly();
        int inv = of.getMultiInverse(det);
        int[][] conjArr = new int[sz][sz];
        for(int i = 0; i < sz; ++i){
            for(int j = 0; j < sz; ++j){
                conjArr[i][j] = Math.floorMod((int)(inv* Math.pow(-1, i + j) * Matrix.det(new Matrix(key, j, i))), 26);
            }
        }
        return new Matrix(conjArr);
    }
}
