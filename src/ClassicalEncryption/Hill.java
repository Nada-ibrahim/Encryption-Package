package ClassicalEncryption;

import GroupOperations.OnTheFly;
import SecurityMath.Matrix;

public class Hill {
    private Matrix key;
    public Hill(String k){
        String kCaps = k.toUpperCase();
        int[][] arr = new int[2][2];
        for (int i =0; i < 2; ++i){
            for(int j = 0; j < 2; ++j){
                arr[i][j] = kCaps.charAt(2*i + j) - 65;
            }
        }
        key = new Matrix(arr);
    }

    public String encrypt(String plain){
        int[][] subPlain = new int[2][1];
        StringBuilder cipherText = new StringBuilder();
        String plainCaps = PlayFair.removeSpaces(plain.toUpperCase());
        for(int i = 0; i < plainCaps.length(); i=i+2){
            subPlain[0][0] = (int)plainCaps.charAt(i) - 65;
            if(i != subPlain.length - 1){
                subPlain[1][0] = (int)plainCaps.charAt(i+1) - 65;
            }else{
                subPlain[1][0] = (int)'X' - 65;
            }
            Matrix m1 = new Matrix(subPlain);
            Matrix cipherMatrix = Matrix.dotProduct(key,m1);
            cipherText.append((char)(cipherMatrix.getElement(0,0) + 65));
            cipherText.append((char)(cipherMatrix.getElement(1,0)+65));
        }
        return cipherText.toString();
    }

    public String decrypt(String cipher){
        int det = key.det();
        OnTheFly f = new OnTheFly();
        int inv = f.getMultiInverse(det);
        String cipherCaps = PlayFair.removeSpaces(cipher.toUpperCase());
        int[][] conjArr = new int[2][2];
        conjArr[0][0] = key.getElement(1,1);
        conjArr[0][1] = -1 * key.getElement(0,1);
        conjArr[1][0] = -1*key.getElement(1,0);
        conjArr[1][1] = key.getElement(0,0);

        Matrix keyInv = new Matrix(conjArr);
        keyInv = Matrix.scalarProduct(keyInv, inv);
        int[][] subPlain = new int[2][1];
        StringBuilder plainText = new StringBuilder();
        for(int i = 0; i < cipherCaps.length(); i=i+2){
            subPlain[0][0] = (int)cipherCaps.charAt(i) - 65;
            if(i != subPlain.length - 1){
                subPlain[1][0] = (int)cipherCaps.charAt(i+1) - 65;
            }else{
                subPlain[1][0] = (int)'X' - 65;
            }
            Matrix m1 = new Matrix(subPlain);
            Matrix plainMatrix = Matrix.dotProduct(keyInv,m1);
            plainText.append((char)(plainMatrix.getElement(0,0) + 65));
            plainText.append((char)(plainMatrix.getElement(1,0)+65));
        }
        return plainText.toString();
    }
}
