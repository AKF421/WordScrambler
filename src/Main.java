import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.scrambled();
    }

    private void scrambled() {
        Random r = new Random();
        System.out.println("How many words would you like to scramble?");
        Scanner numberOfPositions = new Scanner(System.in);
        Scanner word = new Scanner(System.in);
        int arraySize;
        arraySize = numberOfPositions.nextInt();

        System.out.println("Type the words you would like to scramble.");

        String[] words = new String[arraySize];
        for (int i = 0; i < words.length; i++) {
            words[i] = word.next();
        }

        String scrambledWord = null;
        for (String a : words) {
            char [] b = a.toCharArray();
            for (int k = 0; k < b.length; k++) {

                int j = r.nextInt(b.length);
                char temp = b[k];
                b[k] = b[j];
                b[j] = temp;
                scrambledWord = new String(b).toLowerCase();

            }
            System.out.println(scrambledWord);
            System.out.println("______________");
            System.out.println();
        }
    }
}
