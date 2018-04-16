/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GroupOperations;

import SecurityMath.Add;
import SecurityMath.MathOp;
import SecurityMath.Multiply;
import SecurityMath.Sub;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Table {

    private Integer[][] table;
    private List<Integer> numberList;
    private char operation;
    private MathOp op;
//    List table = new ArrayList<ArrayList<Integer>>();

    Table(List<Integer> l, Character c) {
        numberList = new ArrayList<>(l);
        if (c == '+') {
            buildAddTable();
            op = new Add();
        } else if (c == '*') {
            buildMultiTable();
            op = new Multiply();
        } else {
            buildsubTable();
            op = new Sub();
        }
        operation = c;
    }

    Integer[][] buildAddTable() {
        table = new Integer[numberList.size()][numberList.size()];
        for (int i = 0; i < numberList.size(); ++i) {
            for (int j = 0; j < numberList.size(); ++j) {
                table[i][j] = (numberList.get(i) + numberList.get(j)) % numberList.size();
            }
        }
        return table;
    }

    Integer[][] buildMultiTable() {
        table = new Integer[numberList.size()][numberList.size()];
        for (int i = 0; i < numberList.size(); ++i) {
            for (int j = 0; j < numberList.size(); ++j) {
                table[i][j] = (numberList.get(i) * numberList.get(j)) % numberList.size();
            }
        }
        return table;
    }

    Integer[][] buildsubTable() {
        table = new Integer[numberList.size()][numberList.size()];
        for (int i = 0; i < numberList.size(); ++i) {
            for (int j = 0; j < numberList.size(); ++j) {
                table[i][j] = (numberList.get(i) - numberList.get(j)) % numberList.size();
            }
        }
        return table;
    }

    boolean checkComm() {
        int sz = (int) Math.ceil(numberList.size() / 2);
        for (int i = 0; i < sz; ++i) {
            for (int j = i; j < sz; ++j) {
                if (!Objects.equals(table[i][j], table[j][i])) {
                    return false;
                }
            }
        }
        return true;
    }

    boolean checkAssoc() {
        for (int i = 0; i < numberList.size(); ++i) {
            for (int j = i; j < numberList.size(); ++j) {
                for (int k = j; k < numberList.size(); ++k) {
                    if (op.call(table[i][j], numberList.get(k), numberList.size())
                            != op.call(numberList.get(i), table[j][k], numberList.size())) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    boolean checkClosure() {
        for (int i = 0; i < numberList.size(); ++i) {
            for (int j = i; j < numberList.size(); ++j) {
                if (!numberList.contains(table[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }

    boolean identity(int ident) {

        for (int i = 0; i < numberList.size(); i++) {
            if (op.call(numberList.get(i), ident, numberList.size()) != numberList.get(i)) {
                return false;
            }
        }

        return true;
    }
//    boolean inverse (int ident) {
//        boolean flag = false;
//        for (int i = 0; i < numberList.size(); i++) {
//            if(operation == 'M' && numberList.get(i) == 0){
//                continue;
//            }
//            for (int j = 0; j < numberList.size(); j++) {
//                if (table[i][j] == ident) {
//                    flag = true;
//                    break;
//                }
//            }
//            if (!flag) {
//                return false;
//            } else {
//                flag = false;
//            }
//        }
//        return true;
//    }

    List<Integer> getAllInverse() {
        List<Integer> allInverse = new ArrayList<>();
        int ident;
        if (operation == '*') {
            ident = 1;
        } else {
            ident = 0;
        }
        boolean flag = false;
        for (int i = 0; i < numberList.size(); i++) {
            if (operation == '*' && numberList.get(i) == 0) {
                allInverse.add(0);
                continue;
            }
            for (int j = 0; j < numberList.size(); j++) {
                if (table[i][j] == ident) {
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

    List<Integer> getAllInverse(int ident) {
        List<Integer> allInverse = new ArrayList<>();
        boolean flag = false;
        for (int i = 0; i < numberList.size(); i++) {
            if (operation == '*' && numberList.get(i) == 0) {
                allInverse.add(0);
                continue;
            }
            for (int j = 0; j < numberList.size(); j++) {
                if (table[i][j] == ident) {
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

    int getInverse(){
        int ident;
        if (operation == '*') {
            ident = 1;
        } else {
            ident = 0;
        }
        for (int i = 0; i < numberList.size(); i++) {
            if (operation == '*' && numberList.get(i) == 0) {
                return 0;
            }
            for (int j = 0; j < numberList.size(); j++) {
                if (table[i][j] == ident) {
                    return table[i][j];
                }
            }
        }
        return -1;
    }
}
