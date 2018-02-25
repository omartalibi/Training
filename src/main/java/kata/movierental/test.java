package kata.movierental;

public class test {
    public static void main(String[] args) {


        String word = "djim";

        for (char lettre : word.toCharArray()){

            if(lettre == 'd'){
                lettre = 't';
            }

            System.out.println(lettre);

        }



    }
}
