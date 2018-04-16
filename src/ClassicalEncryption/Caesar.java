package ClassicalEncryption;

public class Caesar {

    public String Encryption(String Plaintext, int K) {
        StringBuilder Cipher = new StringBuilder();
        char C;
        Plaintext = Plaintext.toUpperCase();
        for (int i = 0; i < Plaintext.length(); i++) {
            if(Plaintext.charAt(i) == ' '){
                Cipher.append(' ');
                continue;
            }
            char P = Plaintext.charAt(i);
            int Asci = (int) P + K;
            int B = Asci % 90;
            //System.out.println("B= " + B);
            if (B >= 65 && B <= 90) {
                C = (char) B;

            } else {
                C = (char) ((char) B + 65 - 1);
            }
            Cipher.append(C);
        }

        return Cipher.toString();
    }

    public String Decryption(String Ciphertext, int K) {
        StringBuilder Plain = new StringBuilder();
        char C;
        Ciphertext = Ciphertext.toUpperCase();
        for (int i = 0; i < Ciphertext.length(); i++) {
            if(Ciphertext.charAt(i) == ' '){
                Plain.append(' ');
                continue;
            }
            char P = Ciphertext.charAt(i);
            int Asci = (int) P - K;
            int B = Asci % 90;
            //System.out.println("B= " + B);
            if (B >= 65 && B <= 90) {
                C = (char) B;

            } else {
                C = (char) (B+26);
            }
            Plain.append(C);
        }

        return Plain.toString();
    }

}
