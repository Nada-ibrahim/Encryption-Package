package SecurityMath;

public class BinaryOp {
    public static String xor(String s1, String s2){
        long s1Int = Long.parseLong(s1,2);
        long s2Int = Long.parseLong(s2,2);
        long result = s1Int ^ s2Int;
        return Long.toBinaryString(result);
    }
    public static String HexToBin(String hex) {
        StringBuilder bin = new StringBuilder();
        StringBuilder binFragment;
        int iHex;
        hex = hex.trim();
        hex = hex.replaceFirst("0x", "");

        for (int i = 0; i < hex.length(); i++) {
            iHex = Integer.parseInt("" + hex.charAt(i), 16);
            binFragment = new StringBuilder(Integer.toBinaryString(iHex));

            while (binFragment.length() < 4) {
                binFragment.insert(0, "0");
            }
            bin.append(binFragment);
        }
        return bin.toString();
    }

    public static String padTo(String bin, int number){
        int l = bin.length();
        StringBuilder output = new StringBuilder();
        while(output.length() < number - l){
            output.append("0");
        }
        output.append(bin);
        return output.toString();
    }

    public static String binToHex(String bin){
        StringBuilder hex = new StringBuilder();
        StringBuilder hexFragment;
        int iBin;
        bin = bin.trim();

        for (int i = 0; i < bin.length(); i = i + 4) {
            iBin = Integer.parseInt(bin.substring(i, i+4), 2);
            hexFragment = new StringBuilder(Integer.toHexString(iBin));

            hex.append(hexFragment);
        }
        return hex.toString();
    }
}
