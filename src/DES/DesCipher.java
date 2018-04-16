package DES;

import SecurityMath.BinaryOp;

import java.util.Collections;
import java.util.List;

public class DesCipher {

    private PBox perm = new PBox();
    private SBox sub = new SBox();

    private String modifyPlain(String text, List<String> keys){
        text = BinaryOp.HexToBin(text);
        StringBuilder output = new StringBuilder();
        for(int i = 0; i < text.length(); i = i + 64){
            String subText = divideTxt(text, i);
            String subTextIP = perm.doIp(subText);
            String leftTxt = subTextIP.substring(0, 32);
            String rightTxt = subTextIP.substring(32, 64);
            //Start Rounds
            for(int x = 0; x < 16; ++x){
                String rightTxtEd = perm.doExtension(rightTxt);
                //xor with key
                rightTxtEd = BinaryOp.xor(rightTxtEd, keys.get(x));
                rightTxtEd = BinaryOp.padTo(rightTxtEd, 48);
                //substitution
                rightTxtEd = sub.doSub(rightTxtEd);
                rightTxtEd = perm.doPermutation(rightTxtEd);
                rightTxtEd = BinaryOp.xor(rightTxtEd,leftTxt);
                rightTxtEd = BinaryOp.padTo(rightTxtEd, 32);
                leftTxt = rightTxt;
                rightTxt = rightTxtEd;

                System.out.println(BinaryOp.binToHex(keys.get(x)));
                System.out.println(BinaryOp.binToHex(leftTxt));
                System.out.println(BinaryOp.binToHex(rightTxt));
                System.out.println();

            }
            subText = rightTxt.concat(leftTxt);
            subText = perm.doInvIP(subText);
            output.append(subText);
            System.out.println(BinaryOp.binToHex(output.toString()));
        }
        return BinaryOp.binToHex(output.toString());
    }

    private String divideTxt(String text, int i){
        String subText;
        if( i + 64 <= text.length()){
            subText = text.substring(i, i + 64);
        }else{
            subText = text.substring(i, text.length());
            StringBuilder padding = new StringBuilder();
            for(int j = 0; j < 64 - subText.length(); ++j){
                padding.append('0');
            }
            subText = subText.concat(padding.toString());
        }
        return subText;
    }

    public String encrypt(String txt, String key){
        Key myKey = new Key();
        return modifyPlain(txt, myKey.KeyList(key));
    }
    public String decrypt(String txt, String key){
        Key myKey = new Key();
        List<String> keys = myKey.KeyList(key);
        Collections.reverse(keys);
        return modifyPlain(txt, keys);
    }
}
