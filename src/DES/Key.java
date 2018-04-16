package DES;

import SecurityMath.BinaryOp;

import java.util.ArrayList;
import java.util.List;

public class Key {
    private List<String> AllKeys = new ArrayList<>();
    private List<String> LKeys = new ArrayList<>();
    private List<String> RKeys = new ArrayList<>();

    private int[][] Pc1 = new int[8][7];
    private int[][] Pc2 = new int[8][6];

    private void CreatPC_1() {
        Pc1[0][0] = 57;
        Pc1[0][1] = 49;
        Pc1[0][2] = 41;
        Pc1[0][3] = 33;
        Pc1[0][4] = 25;
        Pc1[0][5] = 17;
        Pc1[0][6] = 9;

        Pc1[1][0] = 1;
        Pc1[1][1] = 58;
        Pc1[1][2] = 50;
        Pc1[1][3] = 42;
        Pc1[1][4] = 34;
        Pc1[1][5] = 26;
        Pc1[1][6] = 18;

        Pc1[2][0] = 10;
        Pc1[2][1] = 2;
        Pc1[2][2] = 59;
        Pc1[2][3] = 51;
        Pc1[2][4] = 43;
        Pc1[2][5] = 35;
        Pc1[2][6] = 27;

        Pc1[3][0] = 19;
        Pc1[3][1] = 11;
        Pc1[3][2] = 3;
        Pc1[3][3] = 60;
        Pc1[3][4] = 52;
        Pc1[3][5] = 44;
        Pc1[3][6] = 36;

        Pc1[4][0] = 63;
        Pc1[4][1] = 55;
        Pc1[4][2] = 47;
        Pc1[4][3] = 39;
        Pc1[4][4] = 31;
        Pc1[4][5] = 23;
        Pc1[4][6] = 15;

        Pc1[5][0] = 7;
        Pc1[5][1] = 62;
        Pc1[5][2] = 54;
        Pc1[5][3] = 46;
        Pc1[5][4] = 38;
        Pc1[5][5] = 30;
        Pc1[5][6] = 22;

        Pc1[6][0] = 14;
        Pc1[6][1] = 6;
        Pc1[6][2] = 61;
        Pc1[6][3] = 53;
        Pc1[6][4] = 45;
        Pc1[6][5] = 37;
        Pc1[6][6] = 29;

        Pc1[7][0] = 21;
        Pc1[7][1] = 13;
        Pc1[7][2] = 5;
        Pc1[7][3] = 28;
        Pc1[7][4] = 20;
        Pc1[7][5] = 12;
        Pc1[7][6] = 4;

    }

    private void CreatPC_2() {
        Pc2[0][0] = 14;
        Pc2[0][1] = 17;
        Pc2[0][2] = 11;
        Pc2[0][3] = 24;
        Pc2[0][4] = 1;
        Pc2[0][5] = 5;

        Pc2[1][0] = 3;
        Pc2[1][1] = 28;
        Pc2[1][2] = 15;
        Pc2[1][3] = 6;
        Pc2[1][4] = 21;
        Pc2[1][5] = 10;

        Pc2[2][0] = 23;
        Pc2[2][1] = 19;
        Pc2[2][2] = 12;
        Pc2[2][3] = 4;
        Pc2[2][4] = 26;
        Pc2[2][5] = 8;

        Pc2[3][0] = 16;
        Pc2[3][1] = 7;
        Pc2[3][2] = 27;
        Pc2[3][3] = 20;
        Pc2[3][4] = 13;
        Pc2[3][5] = 2;

        Pc2[4][0] = 41;
        Pc2[4][1] = 52;
        Pc2[4][2] = 31;
        Pc2[4][3] = 37;
        Pc2[4][4] = 47;
        Pc2[4][5] = 55;

        Pc2[5][0] = 30;
        Pc2[5][1] = 40;
        Pc2[5][2] = 51;
        Pc2[5][3] = 45;
        Pc2[5][4] = 33;
        Pc2[5][5] = 48;

        Pc2[6][0] = 44;
        Pc2[6][1] = 49;
        Pc2[6][2] = 39;
        Pc2[6][3] = 56;
        Pc2[6][4] = 34;
        Pc2[6][5] = 53;

        Pc2[7][0] = 46;
        Pc2[7][1] = 42;
        Pc2[7][2] = 50;
        Pc2[7][3] = 36;
        Pc2[7][4] = 29;
        Pc2[7][5] = 32;

    }

    private String Key_56(String K) {
        StringBuilder key = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                key.append(K.charAt(Pc1[i][j] - 1));
            }
        }
        return key.toString();
    }

    private String Key_48(String K) {
        StringBuilder key = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 6; j++) {
                key.append(K.charAt(Pc2[i][j] - 1));
            }
        }
        return key.toString();
    }

    public List<String> KeyList(String hex) {
        CreatPC_1();
        CreatPC_2();
        String Allkey = Key_56(BinaryOp.HexToBin(hex).substring(0,64));
        String Lkey = Allkey.substring(0, 28);
        String Rkey = Allkey.substring(28);
        Shift(Lkey, Rkey);
        return  CreatKey();

    }

    private void Shift(String Lkey, String Rkey) {
        String LSh = Lkey.substring(1);
        LSh += Lkey.charAt(0);
        String RSh = Rkey.substring(1);
        RSh += Rkey.charAt(0);
        LKeys.add(LSh);
        RKeys.add(RSh);

        for (int i = 2; i < 17; i++) {
            if (i == 2 || i == 9 || i == 16) {
                char C1 = LSh.charAt(0);
                char C2 = RSh.charAt(0);

                LSh = LSh.substring(1);
                LSh += C1;
                RSh = RSh.substring(1);
                RSh += C2;
                LKeys.add(LSh);
                RKeys.add(RSh);
            } else {
                String C1 = LSh.substring(0, 2);
                String C2 = RSh.substring(0, 2);
                LSh = LSh.substring(2);
                LSh += C1;
                RSh = RSh.substring(2);
                RSh += C2;
                LKeys.add(LSh);
                RKeys.add(RSh);

            }


        }

    }

    private List<String> CreatKey() {
        for (int i = 0; i < 16; i++) {
            String L = LKeys.get(i);
            String R = RKeys.get(i);
            String allkey = L + R;
            String key = Key_48(allkey);
            AllKeys.add(key);
        }
        return AllKeys;
    }
}
