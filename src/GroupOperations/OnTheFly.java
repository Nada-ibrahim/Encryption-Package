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
import SecurityMath.Add;
import SecurityMath.MathOp;
import SecurityMath.Multiply;

import java.util.ArrayList;
import java.util.List;

public class OnTheFly {
    List<Integer> getAllInverse(List<Integer> numberList, char operation) {
        List<Integer> allInverse = new ArrayList<>();
        int ident;
        MathOp op;
        if (operation == '*') {
            ident = 1;
            op = new Multiply();
        } else {
            ident = 0;
            op = new Add();
        }
        boolean flag = false;
        for (int i = 0; i < numberList.size(); i++) {
            if (operation == '*' && numberList.get(i) == 0) {
                allInverse.add(0);
                continue;
            }
            for (int j = 0; j < numberList.size(); j++) {
                if (op.call(numberList.get(i), numberList.get(j), numberList.size()) == ident) {
                    allInverse.add(numberList.get(j));
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                allInverse.add(-1);
            } else {
                flag = false;
            }

        }
        return allInverse;
    }
    public int getMultiInverse(int num ){
        if(num == 0){return 0;}
        for (int i = 1; i < 26; i++) {
                if ((i*num) % 26  == 1) {
                    return i;
                }
        }
        return -1;
    }
}

