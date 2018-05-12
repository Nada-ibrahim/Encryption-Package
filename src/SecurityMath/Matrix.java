package SecurityMath;

import com.sun.istack.internal.localization.NullLocalizable;

public class Matrix {
    int[][] arr;
    public Matrix(int[][] matrixArr){
        arr = matrixArr;
    }
    public Matrix(Matrix matrixArr, int r, int c){
        int sz = matrixArr.arr.length - 1;
        arr = new int[sz][sz];
        int rmin = 0;
        for(int i = 0; i < matrixArr.arr.length; ++i) {
            int cmin = 0;
            if(i == r){
                rmin = -1;
                continue;
            }
            for(int j = 0; j < matrixArr.arr[i].length; ++j){
                if(j == c){
                    cmin = -1;
                }else{
                    arr[i + rmin][j+cmin] = matrixArr.getElement(i, j);
                }
            }
        }
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

    public static int det(Matrix mat){
        if(mat.arr.length == 1){
            return mat.getElement(0,0);
        }else if(mat.arr.length == 2) {
            return mat.arr[0][0] * mat.arr[1][1] - mat.arr[0][1] * mat.arr[1][0];
        }else{
            int sum = 0;
            for(int i = 0; i < mat.arr.length; ++i){
                sum += Math.pow(-1, i) * mat.getElement(0,i) * det(new Matrix(mat, 0, i));
            }
            return Math.floorMod(sum, 26);
        }

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
