package ClassicalEncryption;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Yassmin
 */

public class PlayFair {
    private char[][] array = new char[5][5];

    char[][] CreatArray(String Key) {
        List<Character> arry = new ArrayList<>();

        Key = Key.toUpperCase();
        for (int i = 0; i < Key.length(); i++) {
            if(Key.charAt(i) == ' '){continue;}
            if (!arry.contains(Key.charAt(i)) && !((Key.charAt(i) == 'J') && arry.contains('I')) && !((Key.charAt(i) == 'I') && arry.contains('J'))) {
                arry.add(Key.charAt(i));
            }
        }

        System.out.println(arry.size());//10
        for (int i = 65; i <= 90; i++) {
            char c = (char) i;
            if (!arry.contains(c) && !((c == 'J') && arry.contains('I')) && !((c == 'I') && arry.contains('J'))) {
                arry.add(c);
            }

        }
        int k = 0;
        for (int i = 0; i < 5; i++) {
            {
                for (int j = 0; j < 5; j++) {

                    array[i][j] = (char) arry.get(k++);
                     System.out.print(array[i][j]);
                }
            System.out.println();
            }

        }
        return array;
    }

    public String Encryption(String Plain, String Key) {
        char[][] array = CreatArray(Key);
        Plain = removeSpaces(Plain.toUpperCase());
        StringBuilder Cipher = new StringBuilder();
        int k = 0;
        int X1 = -1, X2 = -1, Y1 = -1, Y2 = -1;
        char ch2, ch1;
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
                Cipher.append(array[X1][Y2]);
                Cipher.append(array[X2][Y1]);
            } else if (X1 == X2 && Y1 != Y2) {
                Cipher.append(array[X1][(Y1 + 1) % 5]);
                Cipher.append(array[X2][(Y2 + 1) % 5]);
            } else if (X1 != X2 && Y1 == Y2) {
                Cipher.append(array[(X1 + 1) % 5][Y2]);
                Cipher.append(array[(X2 + 1) % 5][Y2]);
            }

        }
        return Cipher.toString();
    }

    public String Decryption(String cipher, String Key) {
        char[][] array = CreatArray(Key);
        cipher = removeSpaces(cipher.toUpperCase());
        StringBuilder Plain = new StringBuilder();

        int k = 0;
        int X1 = -1, X2 = -1, Y1 = -1, Y2 = -1;
        for (k = 0; k < cipher.length(); k += 2) {

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (cipher.charAt(k) == array[i][j]) {
                        X1 = i;
                        Y1 = j;
                    } else if (cipher.charAt(k + 1) == array[i][j]) {
                        X2 = i;
                        Y2 = j;
                    }
                }
            }
            if (X1 != X2 && Y1 != Y2) {
                Plain.append(array[X1][Y2]);
                Plain.append(array[X2][Y1]);
            } else if (X1 == X2 && Y1 != Y2) {
                Plain.append(array[X1][(Y1 - 1) % 5]);
                Plain.append(array[X2][(Y2 - 1) % 5]);
            } else if (X1 != X2 && Y1 == Y2) {
                Plain.append(array[(X1 - 1) % 5][Y2]);
                Plain.append(array[(X2 - 1) % 5][Y2]);
            }

        }
        return Plain.toString();
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


