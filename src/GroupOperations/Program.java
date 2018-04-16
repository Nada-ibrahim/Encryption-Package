package GroupOperations;

import java.util.ArrayList;
import java.util.List;

public class Program {
    String eq1, eq2, redEq ,eq;
    OnTheFly Fly = new OnTheFly();
    //Table t = new Table();




    public String zField(int ListSize, char operation, int identity) {
        List<Integer> numberList = new ArrayList<>();
        for (int i = 0; i < ListSize; i++) {
            numberList.add(i);
        }
        Table t = new Table(numberList, operation);

        boolean Assoc = t.checkAssoc();
        boolean comm = t.checkComm();
        boolean clousre = t.checkClosure();
        boolean ident = t.identity(identity);
        List<Integer> inverseValueByTable = t.getAllInverse();

        String output ="";
        if (Assoc && comm && clousre && ident && (!inverseValueByTable.contains(-1))) {
            output = "Yes it’s group field";
        } else if (!Assoc) {
            output = " No it isn’t group field because it is not Associative";
        } else if (!comm) {
            output = " No it isn’t group field because it is not Commutative";
        } else if (!clousre) {
            output = " No it isn’t group field because it is not Closure";
        } else if (!ident) {
            output = " No it isn’t group field because it is not Identity";
        } else if ((inverseValueByTable.contains(-1))) {
            output = " No it isn’t group field because it is not inverse";
        }
        return output;
    }

    public String List(List<Integer> List, char operation, int identity) {
        Table t = new Table(List, operation);
        boolean Assoc = t.checkAssoc();
        boolean comm = t.checkComm();
        boolean clousre = t.checkClosure();
        boolean ident = t.identity(identity);
        List<Integer> inverseValueByTable = t.getAllInverse(identity);

        String output ="";
        if (Assoc && comm && clousre && ident && (!inverseValueByTable.contains(-1))) {
            output = "Yes it’s group field";
        } else if (!Assoc) {
            output = " No it isn’t group field because it is not Associative";
        } else if (!comm) {
            output = " No it isn’t group field because it is not Commutative";
        } else if (!clousre) {
            output = " No it isn’t group field because it is not Closure";
        } else if (!ident) {
            output = " No it isn’t group field because it is not Identity";
        } else if ((inverseValueByTable.contains(-1))) {
            output = " No it isn’t group field because it is not inverse";
        }
        return output;

    }

//    String Cardinality(int number, char operation) {
//
//        boolean isprime = P.isPrime(number);
//        boolean aprime = P.APrime(number);
//        List<Integer> List = new ArrayList<>();
//        String output = "";
//        if (isprime && aprime) {
//            for (int i = 0; i < number; i++) {
//                List.add(i);
//            }
//            Table t = new Table(List, operation);
//            List<Integer> inverseValueByTable = t.getAllInverse();
//            List<Integer> inverseValueOnTheFly = Fly.getAllInverse(List, operation);
//            output = "The cardinality is valid";
//        } else if (!isprime && aprime) {
//            output = "The field is not cardinality because it is not prime";
//        } else if (isprime && !aprime) {
//            output = "The field is not cardinality because it is not Aprime";
//        }
//        return output;
//
//    }

//    void polynomials() {
//        String Add = GF.add();
//        String divide = GF.divide();
//        String multi = GF.multiply();
//        String inverse = GF.inverse(eq);
//
//
//    }

}
