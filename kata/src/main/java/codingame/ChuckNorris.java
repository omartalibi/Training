package codingame;

import java.util.Scanner;

public class ChuckNorris {

    public static String chuckNorris(String message) {
        StringBuilder binaryValueMessage = new StringBuilder();
        StringBuilder res = new StringBuilder();
        int i = 0;
        int n = 1;

        //BinaryCodeForMessage
        for (char lettre : message.toCharArray()) {
            int asciival = (int) lettre;
            binaryValueMessage.append(Integer.toBinaryString(asciival));
        }

        int nbElements = binaryValueMessage.length();

        System.out.println(binaryValueMessage);
        while (i <= nbElements - 1) {
            if (i < nbElements - 1 &&  binaryValueMessage.charAt(i) ==  binaryValueMessage.charAt(i+1)) {
                n = n + 1;
            } else {
                if ( binaryValueMessage.charAt(i) == '0')
                    res.append("00 ");
                else
                    res.append("0 ");

                for (int j = 0; j < n; j++)
                    res.append("0");

                if(!(i == nbElements - 1))
                    res.append(" ");
                n = 1;
            }

            i = i + 1;
        }

        return res.toString();
    }

    public static void main(String[] args) {
        System.out.print("Enter a character : ");

        Scanner sc = new Scanner(System.in);
        String msg = sc.nextLine();

        System.out.println(chuckNorris(msg));

    }
}