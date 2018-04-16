/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GroupOperations;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.log;
import static java.lang.Math.pow;

/**
 *
 * @author Yassmin
 */
public class Cardinality {
    private boolean isPrime;
    private boolean isAprime;
    private List<Integer> originalList;
    public Cardinality(int number){
        isPrime = isPrime(number);
        isAprime = APrime(number);
        originalList = new ArrayList<>();
        if (isPrime || isAprime) {
            for (int i = 0; i < number; i++) {
                originalList.add(i);
            }
        }
    }
    public String testCardinality(){
        String output;
        if (isAprime) {
            output = "The field is cardinality because it is Aprime";
        } else if (isPrime) {
            output = "The field is cardinality because it is prime";
        }else{
            output = "The field is not cardinality because it's neither prime nor aprime";
        }
        return output;
    }
    public List<Integer> getInverseTable(Character c){
        Table t = new Table(originalList, c);
        return t.getAllInverse();
    }
    public List<Integer> getInverseFly(Character c){
        OnTheFly Fly = new OnTheFly();
        return Fly.getAllInverse(originalList, c);
    }
    public List<Integer> getNumberLs(){
        return originalList;
    }

    private boolean isPrime(int num) {
        int n = (int)Math.ceil(Math.sqrt(num));
        for (int i = 2; i < n; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    private boolean APrime(int num) {
        int n = (int)Math.ceil(log(num));
        for(int i = 2; i < n; ++i){
            double s = 1.0/(double)i;
            double x = pow(num, s);
            if(x == (int) x && isPrime((int)x)){
                return true;
            }
        }
        return false;
    }

    public boolean getPrime(){
        return isPrime;
    }
    public boolean getAprime(){
        return isAprime;
    }

}
