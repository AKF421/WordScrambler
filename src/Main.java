import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
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

    }
}
