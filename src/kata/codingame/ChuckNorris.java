package kata.codingame;

import java.util.Scanner;

public class ChuckNorris {

    public static String chuckNorris(String message) {
        StringBuilder binaryValueMessage = new StringBuilder();
        StringBuilder res = new StringBuilder();
        String resf="NULL";
        int n = 1;

        for (char lettre : message.toCharArray()) {
            int asciival = (int) lettre;

            binaryValueMessage.append(Integer.toBinaryString(asciival));

            char t = binaryValueMessage.charAt(0);

            for (char bit : binaryValueMessage.substring(1, binaryValueMessage.length()).toCharArray()) {
                if (t == bit)
                    n = n + 1;
                if(t!= bit || bit == binaryValueMessage.charAt(binaryValueMessage.length() - 1)){
                    if (t == '0')
                        res.append("00 ");
                    else
                        res.append("0 ");

                    for (int i = 0; i < n; i++) {
                        res.append("0");
                    }

                    n = 1;
                    t = bit;

                    res.append(" ");
                }
            }
            resf = res.substring(0, res.length() - 1);
        }
        return resf;
    }

    public static void main(String[] args) {
        System.out.print("Enter a character : ");

        Scanner sc = new Scanner(System.in);
        String msg = sc.nextLine();

        System.out.println(chuckNorris(msg));
    }
}
