package kata.codingame;

import java.util.Scanner;

public class ChuckNorris {

    public static StringBuilder chuckNorris(String message) {
        StringBuilder binaryValueMessage = new StringBuilder();
        StringBuilder res = new StringBuilder();
        String resf = "NULL";
        int n = 1;
        int m = 0;

        for (char lettre : message.toCharArray()) {
            int asciival = (int) lettre;
            binaryValueMessage.append(Integer.toBinaryString(asciival));


            char[] tab = binaryValueMessage.substring(0, binaryValueMessage.length()).toCharArray();
            int nbElements = tab.length;
            int indice = 1;

            while (indice < nbElements) {
                char r = tab[indice];
                if (r == tab[indice - 1])
                    n = n + 1;
                else {
                    if (r == '0')
                        res.append("00 ");
                    else
                        res.append("0 ");
                }

                for (int i = 0; i < n; i++) {
                    res.append("0");
                }

                indice = indice + 1;
                n = 1;

                res.append(" ");
            }
        }
        return res;
    }

        public static void main (String[]args){
            System.out.print("Enter a character : ");

            Scanner sc = new Scanner(System.in);
            String msg = sc.nextLine();

            System.out.println(chuckNorris(msg));
        }
    }