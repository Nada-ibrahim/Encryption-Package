package ClassicalEncryption;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Yassmin
 */

public class PlayFair {

    char[][] array = new char[5][5];
    char ch = ' ';
    char[][] CreatArray(String Key) {
        Key = Key.toUpperCase();
        List<Character> arry = new ArrayList<>();
        for (int i = 0; i < Key.length(); i++) {
            if(!arry.contains(Key.charAt(i))) {
                if ((Key.charAt(i) == 'I') && ch == ' ') {
                    ch = 'I';
                    arry.add('I');
                } else if ((Key.charAt(i) == 'J') && ch == ' ') {
                    arry.add('J');
                    ch = 'J';
                } else if((Key.charAt(i) != 'J') && (Key.charAt(i) != 'I')){
                    arry.add(Key.charAt(i));
                }
            }
        }

        System.out.println(arry.size());//10
        for (int i = 65; i <= 90; i++) {
            char c = (char) i;
            if (!arry.contains(c) && !((c == 'J') && arry.contains('I')) && !((c == 'I') && arry.contains('J'))) {
                arry.add(c);

            } else {
                continue;
            }

        }
        int k = 0;
        for (int i = 0; i < 5; i++) {
            {
                for (int j = 0; j < 5; j++) {

                    array[i][j] = (char) arry.get(k++);
                    System.out.print(array[i][j]);
                }
//            System.out.println();
            }

        }
        return array;
    }

    public String Encryption(String Plain, String Key) {
        char[][] array = CreatArray(Key);
        Plain = PlayFair.removeSpaces(Plain.toUpperCase());
        String Cipher = "";
        int k = 0;
        for(int i = 0; i < Plain.length(); ++i){
            if(Plain.charAt(i) == 'I' || Plain.charAt(i) == 'J'){
                Plain = Plain.substring(0,i) + ch + Plain.substring(i+1) ;
            }
        }
        int X1 = -1, X2 = -1, Y1 = -1, Y2 = -1;
        char ch1, ch2;
        for (k = 0; k < Plain.length(); k += 2) {
            if (k == Plain.length() - 1 || Plain.charAt(k) == Plain.charAt(k + 1)) {
                ch2 = 'X';
                ch1 = Plain.charAt(k);
                k--;
            } else {
                ch2 = Plain.charAt(k + 1);
                ch1 = Plain.charAt(k);
            }

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (ch1 == array[i][j]) {
                        X1 = i;
                        Y1 = j;
                    } else if (ch2 == array[i][j]) {
                        X2 = i;
                        Y2 = j;
                    }
                }
            }
            if (X1 != X2 && Y1 != Y2) {
                Cipher += array[X1][Y2];
                Cipher += array[X2][Y1];
            } else if (X1 == X2 && Y1 != Y2) {
                Cipher += array[X1][(Y1 + 1) % 5];
                Cipher += array[X2][(Y2 + 1) % 5];
            } else if (X1 != X2 && Y1 == Y2) {
                Cipher += array[(X1 + 1) % 5][Y2];
                Cipher += array[(X2 + 1) % 5][Y2];
            }

        }
        return Cipher;
    }

    public String Decryption(String Cipher, String Key) {
        char[][] array = CreatArray(Key);
        Cipher = Cipher.toUpperCase();
        String Plain = "";
        int k = 0;
        int X1 = -1, X2 = -1, Y1 = -1, Y2 = -1;
        for (k = 0; k < Cipher.length(); k += 2) {

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (Cipher.charAt(k) == array[i][j]) {
                        X1 = i;
                        Y1 = j;
                    } else if (Cipher.charAt(k + 1) == array[i][j]) {
                        X2 = i;
                        Y2 = j;
                    }
                }
            }
            if (X1 != X2 && Y1 != Y2) {
                Plain += array[X1][Y2];
                Plain += array[X2][Y1];
            } else if (X1 == X2 && Y1 != Y2) {
                Plain += array[X1][Math.floorMod((Y1 - 1), 5)];
                Plain += array[X2][Math.floorMod((Y2 - 1), 5)];
            } else if (X1 != X2 && Y1 == Y2) {
                Plain += array[(X1 - 1) % 5][Y2];
                Plain += array[(X2 - 1) % 5][Y2];
            }

        }
        return Plain;
    }
    static String removeSpaces(String text){
        StringBuilder textEd = new StringBuilder(text);

        for(int i = 0; i < textEd.length(); ++i){
            if(textEd.charAt(i) == ' '){
                textEd.deleteCharAt(i);
            }
        }
        return textEd.toString();
    }
}


