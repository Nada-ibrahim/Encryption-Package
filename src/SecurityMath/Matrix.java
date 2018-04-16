package SecurityMath;

import com.sun.istack.internal.localization.NullLocalizable;

public class Matrix {
    int[][] arr;
    public Matrix(int[][] matrixArr){
        arr = matrixArr;
    }

    public static Matrix dotProduct(Matrix m1, Matrix m2){
        if(m1.arr[0].length != m2.arr.length){
            return null;
        }
        int[][] resultArr = new int[m1.arr.length][m2.arr[0].length];
        for(int i = 0; i < m1.arr.length; ++i){
            for(int j = 0; j < m2.arr[0].length; ++j){
                for(int x = 0; x < m2.arr.length; ++x){
                    resultArr[i][j] += m1.getElement(i,x)*m2.getElement(x,j);
                }
                resultArr[i][j] = Math.floorMod(resultArr[i][j], 26);
            }

        }
        return new Matrix(resultArr);
    }

    public int getElement(int r, int c){
        return arr[r][c];
    }

    public int det(){
        return Math.floorMod(arr[0][0]*arr[1][1] - arr[0][1] * arr[1][0], 26);
    }

    public static Matrix scalarProduct(Matrix m, int s){
        for(int i = 0; i < m.arr.length; ++i){
            for(int j = 0; j < m.arr[0].length; ++j){
                m.arr[i][j] *= s;
            }
        }
        return m;
    }


}
